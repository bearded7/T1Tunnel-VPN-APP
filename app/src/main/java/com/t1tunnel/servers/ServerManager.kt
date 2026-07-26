package com.t1tunnel.servers

object ServerManager {
    // Fill in real per-protocol credentials for whichever protocol(s) you intend to use -
    // a server entry only needs the fields for the protocol you'll actually pick in the UI.
    val servers = listOf(
        Server(
            name = "US East",
            host = "us1.t1tunnel.xyz",
            port = 443,
            sni = "www.microsoft.com",
            bugHost = "www.microsoft.com",
            // VLESS+Reality (see keys/reality.env after running scripts/generate_keys.sh)
            vlessUuid = "00000000-0000-0000-0000-000000000000",
            realityPublicKey = "",
            realityShortId = "",
            // WireGuard
            wgPrivateKey = "",
            wgServerPublicKey = "",
            wgPresharedKey = "",
            wgAddress = "10.66.66.2/32",
            wgDns = "1.1.1.1",
            // OpenVPN - either paste a full .ovpn file's contents into ovpnConfig (recommended,
            // since it can embed certs inline with <ca>/<cert>/<key> blocks), or leave it blank
            // and rely on ovpnUsername/ovpnPassword with a config pulled from elsewhere
            ovpnConfig = "",
            ovpnUsername = "",
            ovpnPassword = "",
            // IKEv2 (strongSwan)
            ikev2Remote = "",
            ikev2Username = "",
            ikev2Password = ""
        )
    )
}

data class Server(
    val name: String,
    val host: String,
    val port: Int,
    val sni: String = "www.microsoft.com",
    val bugHost: String = "www.microsoft.com",
    val vlessUuid: String = "",
    val realityPublicKey: String = "",
    val realityShortId: String = "",
    val wgPrivateKey: String = "",
    val wgServerPublicKey: String = "",
    val wgPresharedKey: String = "",
    val wgAddress: String = "10.66.66.2/32",
    val wgDns: String = "1.1.1.1",
    val ovpnConfig: String = "",
    val ovpnUsername: String = "",
    val ovpnPassword: String = "",
    val ikev2Remote: String = "",
    val ikev2Username: String = "",
    val ikev2Password: String = ""
)
