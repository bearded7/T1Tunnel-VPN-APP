package com.t1tunnel.base

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.net.VpnService
import android.os.Build
import android.os.ParcelFileDescriptor
import androidx.core.app.NotificationCompat
import com.t1tunnel.MainActivity
import com.t1tunnel.Tun2Socks
import kotlin.concurrent.thread

abstract class BaseVpnService : VpnService() {
    protected var tunFd: ParcelFileDescriptor? = null
    abstract val protocolName: String
    abstract fun startProtocol(config: ProtocolConfig)
    abstract fun stopProtocol()

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        startForeground(NOTIFICATION_ID, buildNotification("Initializing..."))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (tunFd != null) return START_STICKY
        val builder = Builder()
            .setSession(protocolName)
            .addAddress("10.0.0.2", 24)
            .addRoute("0.0.0.0", 0)
            .addDnsServer("1.1.1.1")
            .setMtu(1350)
            .setBlocking(false)
        tunFd = builder.establish() ?: return START_NOT_STICKY

        val config = ProtocolConfig.fromIntent(intent!!)
        startProtocol(config)
        thread {
            Tun2Socks.start(tunFd!!.fd, "127.0.0.1:10808", 1350)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Tun2Socks.stop()
        stopProtocol()
        tunFd?.close()
        tunFd = null
        super.onDestroy()
    }

    private fun buildNotification(text: String): Notification {
        val pi = PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), PendingIntent.FLAG_IMMUTABLE)
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("T1Tunnel $protocolName")
            .setContentText(text)
            .setSmallIcon(android.R.drawable.ic_menu_share)
            .setContentIntent(pi)
            .build()
    }

    companion object {
        const val CHANNEL_ID = "t1tunnel_vpn"
        const val NOTIFICATION_ID = 1
        fun createNotificationChannel(context: android.content.Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(CHANNEL_ID, "VPN Service", NotificationManager.IMPORTANCE_LOW)
                (context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)
            }
        }
    }
}

data class ProtocolConfig(
    val server: String,
    val port: Int,
    val uuid: String?,
    val sni: String?,
    val bugHost: String?,
    val mode: String?
) {
    companion object {
        fun fromIntent(intent: Intent) = ProtocolConfig(
            intent.getStringExtra("server") ?: "vpn.example.com",
            intent.getIntExtra("port", 443),
            intent.getStringExtra("uuid") ?: "",
            intent.getStringExtra("sni") ?: "www.microsoft.com",
            intent.getStringExtra("bugHost") ?: "",
            intent.getStringExtra("mode") ?: "direct"
        )
    }
}
