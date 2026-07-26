package com.t1tunnel.protocols

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * OpenVPN UDP is actually driven through OpenVpnBridge (com.t1tunnel.protocols.openvpn),
 * called directly from MainActivity - establishing the tunnel needs startActivityForResult
 * for permission/consent, which only an Activity can do, so it can't live in a background
 * Service. This class is kept only so the manifest's service declaration and any existing
 * external references don't dangle; MainActivity no longer starts it.
 */
class OpenVpnUdpService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        stopSelf()
        return START_NOT_STICKY
    }
}
