package com.t1tunnel.protocols.openvpn

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.net.Uri
import android.os.IBinder
import android.widget.Toast
import de.blinkt.openvpn.api.IOpenVPNAPIService
import com.t1tunnel.servers.Server

/**
 * OpenVPN UDP/TCP tunneling via the "OpenVPN for Android" app's documented external control
 * API (de.blinkt.openvpn.api.IOpenVPNAPIService AIDL). We don't embed OpenVPN's own engine -
 * that project isn't published as a Maven library (see app/build.gradle notes) - instead we
 * push a generated .ovpn profile into the companion app and ask it to connect, which is the
 * integration path ics-openvpn itself documents for third-party apps:
 * https://github.com/schwabe/ics-openvpn (FAQ: "How can I control the app from an external app?")
 *
 * Requires "OpenVPN for Android" (de.blinkt.openvpn) installed, and - on first use - the user
 * approving this app in OpenVPN for Android's Settings > "Allowed apps to control OpenVPN".
 */
object OpenVpnBridge {
    private const val PACKAGE = "de.blinkt.openvpn"
    private const val SERVICE_ACTION = "de.blinkt.openvpn.api.IOpenVPNAPIService"
    const val REQUEST_OVPN_PERMISSION = 201
    const val REQUEST_OVPN_VPN_CONSENT = 202

    private var api: IOpenVPNAPIService? = null
    private var connection: ServiceConnection? = null
    private var pendingProfileUUID: String? = null

    fun isCompanionAppInstalled(context: Context): Boolean = try {
        context.packageManager.getPackageInfo(PACKAGE, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }

    fun promptInstall(activity: Activity) {
        Toast.makeText(activity, "Install \"OpenVPN for Android\" to use OpenVPN UDP/TCP", Toast.LENGTH_LONG).show()
        try {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$PACKAGE")))
        } catch (e: Exception) {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://f-droid.org/packages/$PACKAGE/")))
        }
    }

    /** Build a minimal inline .ovpn profile using the given server + UDP/TCP proto. */
    fun buildOvpnConfig(server: Server, useTcp: Boolean): String {
        if (server.ovpnConfig.isNotBlank()) return server.ovpnConfig
        val proto = if (useTcp) "tcp-client" else "udp"
        return buildString {
            appendLine("client")
            appendLine("dev tun")
            appendLine("proto $proto")
            appendLine("remote ${server.host} ${server.port}")
            appendLine("resolv-retry infinite")
            appendLine("nobind")
            appendLine("persist-key")
            appendLine("persist-tun")
            appendLine("remote-cert-tls server")
            appendLine("cipher AES-256-GCM")
            appendLine("verb 3")
            if (server.ovpnUsername.isNotBlank()) {
                appendLine("auth-user-pass")
            }
            // NOTE: a real deployment needs <ca>...</ca> (and usually <cert>/<key> or
            // <tls-crypt>) inlined here - OpenVPN for Android will reject a profile with no
            // trust material. Paste your provider's full .ovpn into Server.ovpnConfig instead
            // of relying on this generated skeleton whenever possible.
        }
    }

    /**
     * Connects, walking through: bind -> permission check -> (maybe) VPN consent -> add
     * profile -> start. Must be called from an Activity because two of those steps need
     * startActivityForResult.
     */
    fun connect(activity: Activity, server: Server, useTcp: Boolean) {
        if (!isCompanionAppInstalled(activity)) {
            promptInstall(activity)
            return
        }
        val intent = Intent(SERVICE_ACTION).apply { setPackage(PACKAGE) }
        val conn = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                api = IOpenVPNAPIService.Stub.asInterface(binder)
                proceedAfterBind(activity, server, useTcp)
            }
            override fun onServiceDisconnected(name: ComponentName?) {
                api = null
            }
        }
        connection = conn
        activity.bindService(intent, conn, Context.BIND_AUTO_CREATE)
    }

    private fun proceedAfterBind(activity: Activity, server: Server, useTcp: Boolean) {
        val svc = api ?: return
        val permissionIntent = svc.prepare(activity.packageName)
        if (permissionIntent != null) {
            // First run: OpenVPN for Android needs the user to explicitly allow this app.
            activity.startActivityForResult(permissionIntent, REQUEST_OVPN_PERMISSION)
            return
        }
        startProfile(activity, server, useTcp)
    }

    /** Call this from MainActivity.onActivityResult for REQUEST_OVPN_PERMISSION. */
    fun onPermissionResult(activity: Activity, server: Server, useTcp: Boolean) {
        startProfile(activity, server, useTcp)
    }

    private fun startProfile(activity: Activity, server: Server, useTcp: Boolean) {
        val svc = api ?: return
        try {
            val vpnConsent = svc.prepareVPNService()
            if (vpnConsent != null) {
                activity.startActivityForResult(vpnConsent, REQUEST_OVPN_VPN_CONSENT)
                return
            }
            val ovpn = buildOvpnConfig(server, useTcp)
            val profile = svc.addNewVPNProfile("T1Tunnel (${server.name})", false, ovpn)
            pendingProfileUUID = profile.mUUID
            svc.startProfile(profile.mUUID)
        } catch (e: Exception) {
            android.util.Log.e("OpenVpnBridge", "Failed to start profile", e)
            Toast.makeText(activity, "OpenVPN start failed: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    /** Call this from MainActivity.onActivityResult for REQUEST_OVPN_VPN_CONSENT. */
    fun onVpnConsentResult(activity: Activity, server: Server, useTcp: Boolean) {
        val svc = api ?: return
        try {
            val ovpn = buildOvpnConfig(server, useTcp)
            val profile = svc.addNewVPNProfile("T1Tunnel (${server.name})", false, ovpn)
            pendingProfileUUID = profile.mUUID
            svc.startProfile(profile.mUUID)
        } catch (e: Exception) {
            android.util.Log.e("OpenVpnBridge", "Failed to start profile", e)
            Toast.makeText(activity, "OpenVPN start failed: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    fun disconnect(activity: Activity) {
        try {
            api?.disconnect()
        } catch (e: Exception) {
            android.util.Log.e("OpenVpnBridge", "Failed to disconnect", e)
        }
        connection?.let { activity.unbindService(it) }
        connection = null
        api = null
    }
}
