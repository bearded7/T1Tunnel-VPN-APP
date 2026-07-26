package com.t1tunnel.protocols

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * IKEv2 is driven through StrongSwanBridge (com.t1tunnel.protocols.openvpn), called directly
 * from MainActivity for the same reason as OpenVpnUdpService: importing/starting a strongSwan
 * profile needs startActivityForResult. Kept only for manifest/reference compatibility.
 */
class Ikev2Service : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        stopSelf()
        return START_NOT_STICKY
    }
}
