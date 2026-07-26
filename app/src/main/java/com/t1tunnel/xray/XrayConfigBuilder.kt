package com.t1tunnel.xray

import com.t1tunnel.base.ProtocolConfig
import com.t1tunnel.tunneld.TunnelMode
import org.json.JSONArray
import org.json.JSONObject

/**
 * Shared local SOCKS port that tun2socks routes captured device traffic into, and that Xray
 * listens on. Kept in one place so BaseVpnService and this builder can't drift out of sync.
 */
object TunnelPorts {
    const val LOCAL_SOCKS_PORT = 10808
}

/**
 * Builds an xray-core JSON config for the VLESS+Reality protocol, varying the outbound
 * streamSettings by the selected TunnelMode. This is what actually gets handed to
 * XrayEngine.start() (the gomobile-bound native Xray core built by scripts/build_xray.sh).
 *
 * Mode -> transport mapping:
 *  DIRECT                  -> raw tcp, Reality security straight to the server
 *  HTTP_CONNECT            -> raw tcp with Xray's "http" header obfuscation (fake HTTP request
 *                              bytes on the wire to defeat naive DPI signature matching)
 *  RAW_TCP_CONNECT         -> raw tcp, no header, no TLS (use only if you know why)
 *  TLS_TUNNEL              -> raw tcp wrapped in a real TLS handshake to `sni`
 *  WEBSOCKET_UPGRADE       -> ws transport, no TLS
 *  WEBSOCKET_SECURE        -> ws transport + TLS to `sni`
 *  WEBSOCKET_CDN           -> ws transport, Host header set to `bugHost` (domain fronting through
 *                              a CDN edge that isn't blocked, common bug-host technique)
 *  WEBSOCKET_SECURE_CDN_SNI-> ws + TLS, SNI *and* Host both set to `bugHost`
 *
 * Reality security is only valid over a raw TCP transport in real-world xray-core deployments;
 * for the ws-based modes we fall back to TLS security instead of Reality, since mixing Reality
 * with ws isn't a supported combination. Adjust here if your server's config differs.
 */
object XrayConfigBuilder {

    fun build(config: ProtocolConfig, mode: TunnelMode): String {
        val root = JSONObject()
        root.put("log", JSONObject().apply { put("loglevel", "warning") })

        // Local inbound: tun2socks connects here, we forward everything to the vless outbound.
        val inbounds = JSONArray()
        inbounds.put(JSONObject().apply {
            put("listen", "127.0.0.1")
            put("port", TunnelPorts.LOCAL_SOCKS_PORT)
            put("protocol", "socks")
            put("settings", JSONObject().apply {
                put("udp", true)
                put("auth", "noauth")
            })
            put("sniffing", JSONObject().apply {
                put("enabled", true)
                put("destOverride", JSONArray(listOf("http", "tls")))
            })
        })
        root.put("inbounds", inbounds)

        val outbounds = JSONArray()
        outbounds.put(buildVlessOutbound(config, mode))
        outbounds.put(JSONObject().apply {
            put("protocol", "freedom")
            put("tag", "direct")
        })
        root.put("outbounds", outbounds)

        return root.toString(2)
    }

    private fun buildVlessOutbound(config: ProtocolConfig, mode: TunnelMode): JSONObject {
        val sni = config.sni?.takeIf { it.isNotBlank() } ?: "www.microsoft.com"
        val bugHost = config.bugHost?.takeIf { it.isNotBlank() } ?: sni

        val user = JSONObject().apply {
            put("id", config.uuid)
            put("encryption", "none")
            // Vision flow control is what makes Reality's anti-fingerprinting work; only
            // meaningful when the security below is actually "reality".
            if (usesReality(mode)) put("flow", "xtls-rprx-vision")
        }
        val vnext = JSONObject().apply {
            put("address", config.server)
            put("port", config.port)
            put("users", JSONArray().put(user))
        }
        val settings = JSONObject().apply { put("vnext", JSONArray().put(vnext)) }

        val streamSettings = JSONObject()
        when (mode) {
            TunnelMode.DIRECT -> {
                streamSettings.put("network", "tcp")
                streamSettings.put("security", "reality")
                streamSettings.put("realitySettings", realitySettings(config, sni))
            }
            TunnelMode.HTTP_CONNECT -> {
                streamSettings.put("network", "tcp")
                streamSettings.put("security", "reality")
                streamSettings.put("realitySettings", realitySettings(config, sni))
                streamSettings.put("tcpSettings", httpObfuscationHeader(sni))
            }
            TunnelMode.RAW_TCP_CONNECT -> {
                streamSettings.put("network", "tcp")
                streamSettings.put("security", "none")
            }
            TunnelMode.TLS_TUNNEL -> {
                streamSettings.put("network", "tcp")
                streamSettings.put("security", "tls")
                streamSettings.put("tlsSettings", tlsSettings(sni))
            }
            TunnelMode.WEBSOCKET_UPGRADE -> {
                streamSettings.put("network", "ws")
                streamSettings.put("security", "none")
                streamSettings.put("wsSettings", wsSettings(sni))
            }
            TunnelMode.WEBSOCKET_SECURE -> {
                streamSettings.put("network", "ws")
                streamSettings.put("security", "tls")
                streamSettings.put("tlsSettings", tlsSettings(sni))
                streamSettings.put("wsSettings", wsSettings(sni))
            }
            TunnelMode.WEBSOCKET_CDN -> {
                streamSettings.put("network", "ws")
                streamSettings.put("security", "none")
                streamSettings.put("wsSettings", wsSettings(bugHost))
            }
            TunnelMode.WEBSOCKET_SECURE_CDN_SNI -> {
                streamSettings.put("network", "ws")
                streamSettings.put("security", "tls")
                streamSettings.put("tlsSettings", tlsSettings(bugHost))
                streamSettings.put("wsSettings", wsSettings(bugHost))
            }
        }

        return JSONObject().apply {
            put("tag", "proxy")
            put("protocol", "vless")
            put("settings", settings)
            put("streamSettings", streamSettings)
        }
    }

    private fun usesReality(mode: TunnelMode) = mode == TunnelMode.DIRECT || mode == TunnelMode.HTTP_CONNECT

    private fun realitySettings(config: ProtocolConfig, sni: String) = JSONObject().apply {
        put("serverName", sni)
        put("publicKey", config.realityPublicKey ?: "")
        put("shortId", config.realityShortId ?: "")
        put("fingerprint", "chrome")
        put("show", false)
    }

    private fun tlsSettings(sni: String) = JSONObject().apply {
        put("serverName", sni)
        put("allowInsecure", false)
    }

    private fun wsSettings(host: String) = JSONObject().apply {
        put("path", "/")
        put("headers", JSONObject().apply { put("Host", host) })
    }

    /** Xray's tcp "http" header type disguises the initial bytes as a real HTTP/1.1 request. */
    private fun httpObfuscationHeader(host: String) = JSONObject().apply {
        put("header", JSONObject().apply {
            put("type", "http")
            put("request", JSONObject().apply {
                put("version", "1.1")
                put("method", "GET")
                put("path", JSONArray(listOf("/")))
                put("headers", JSONObject().apply {
                    put("Host", JSONArray(listOf(host)))
                    put("User-Agent", JSONArray(listOf(
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
                    )))
                    put("Connection", JSONArray(listOf("keep-alive")))
                })
            })
        })
    }
}
