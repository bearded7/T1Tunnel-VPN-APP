package com.t1tunnel.protocols

import android.app.Service
import android.content.Intent
import android.os.IBinder

/** See OpenVpnUdpService - same reasoning, TCP is just useTcp=true in OpenVpnBridge.connect(). */
class OpenVpnTcpService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        stopSelf()
        return START_NOT_STICKY
    }
}
