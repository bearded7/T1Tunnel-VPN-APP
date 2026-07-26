package com.t1tunnel.protocols.openvpn

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.core.content.FileProvider
import com.t1tunnel.servers.Server
import org.json.JSONObject
import java.io.File

/**
 * IKEv2 tunneling via the official strongSwan VPN Client Android app, using its documented
 * Intent-based control API (see https://wiki.strongswan.org/projects/strongswan/wiki/androidvpnclient
 * and the .sswan profile import format: https://docs.strongswan.org/docs/5.9/os/androidVpnClientProfiles.html).
 * strongSwan's Android engine isn't published as an embeddable Maven library either (it's an
 * app, built from the strongSwan C sources via NDK) - as with OpenVPN, we drive the installed
 * companion app rather than re-implementing IKEv2/IPsec ourselves.
 *
 * Requires the "strongSwan VPN Client" app (org.strongswan.android) installed.
 */
object StrongSwanBridge {
    private const val PACKAGE = "org.strongswan.android"
    private const val ACTION_START_PROFILE = "org.strongswan.android.action.START_PROFILE"
    private const val ACTION_DISCONNECT = "org.strongswan.android.action.DISCONNECT"
    private const val EXTRA_VPN_PROFILE_ID = "org.strongswan.android.VPN_PROFILE_ID"
    const val REQUEST_IMPORT_PROFILE = 301

    fun isCompanionAppInstalled(activity: Activity): Boolean = try {
        activity.packageManager.getPackageInfo(PACKAGE, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }

    fun promptInstall(activity: Activity) {
        Toast.makeText(activity, "Install \"strongSwan VPN Client\" to use IKEv2", Toast.LENGTH_LONG).show()
        try {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$PACKAGE")))
        } catch (e: Exception) {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://f-droid.org/packages/$PACKAGE/")))
        }
    }

    /**
     * strongSwan only exposes "start by profile UUID" over Intents - it can't create a
     * profile that way. So the flow is: generate a .sswan file, hand it to strongSwan via
     * ACTION_VIEW so the user taps "import" (one-time per server), then use the UUID
     * strongSwan assigns (stored in Server-keyed prefs by the caller) for subsequent
     * one-tap connects via startByStoredProfile().
     */
    fun importProfile(activity: Activity, server: Server) {
        if (!isCompanionAppInstalled(activity)) {
            promptInstall(activity)
            return
        }
        val profile = JSONObject().apply {
            put("uuid", java.util.UUID.randomUUID().toString())
            put("name", "T1Tunnel (${server.name})")
            put("type", "ikev2-eap")
            put("remote", JSONObject().apply { put("addr", server.ikev2Remote.ifBlank { server.host }) })
            put("local", JSONObject().apply {
                put("eap_id", server.ikev2Username)
            })
            put("username", server.ikev2Username)
            put("password", server.ikev2Password)
        }
        val file = File(activity.cacheDir, "t1tunnel_${server.name.replace(" ", "_")}.sswan")
        file.writeText(profile.toString())
        val uri = FileProvider.getUriForFile(activity, "${activity.packageName}.fileprovider", file)
        val viewIntent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/vnd.strongswan.profile")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        try {
            activity.startActivityForResult(viewIntent, REQUEST_IMPORT_PROFILE)
        } catch (e: Exception) {
            Toast.makeText(activity, "Couldn't open strongSwan for import: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    /** Start a profile strongSwan already knows about, by the UUID it was imported with. */
    fun startByStoredProfile(activity: Activity, profileUUID: String) {
        val intent = Intent(ACTION_START_PROFILE).apply {
            setClassName(PACKAGE, "$PACKAGE.ui.MainActivity")
            putExtra(EXTRA_VPN_PROFILE_ID, profileUUID)
        }
        try {
            activity.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(activity, "Couldn't start strongSwan profile: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    fun disconnect(activity: Activity, profileUUID: String?) {
        val intent = Intent(ACTION_DISCONNECT).apply {
            setClassName(PACKAGE, "$PACKAGE.ui.MainActivity")
            profileUUID?.let { putExtra(EXTRA_VPN_PROFILE_ID, it) }
        }
        try {
            activity.startActivity(intent)
        } catch (e: Exception) {
            android.util.Log.e("StrongSwanBridge", "Failed to disconnect", e)
        }
    }
}
