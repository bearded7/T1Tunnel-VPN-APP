package com.t1tunnel.protocols

import android.app.PendingIntent
import android.content.Intent
import android.net.VpnService
import android.os.Build
import androidx.core.app.NotificationCompat
import com.t1tunnel.MainActivity
import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
import com.wireguard.android.backend.Backend
import com.wireguard.android.backend.GoBackend
import com.wireguard.android.backend.Tunnel
import com.wireguard.config.Config
import com.wireguard.config.Interface
import com.wireguard.config.Peer
import kotlin.concurrent.thread

/**
 * WireGuard doesn't go through tun2socks/BaseVpnService's generic SOCKS-based flow - the
 * wireguard-android library's GoBackend manages the tun device itself (via its own userspace
 * wireguard-go engine) and needs this class to *be* the VpnService it binds to, so this extends
 * android.net.VpnService directly instead of BaseVpnService.
 */
class WireGuardService : VpnService(), Tunnel {

    private lateinit var backend: Backend
    @Volatile private var state: Tunnel.State = Tunnel.State.DOWN

    override fun getName(): String = "t1tunnel_wg"

    override fun onStateChange(newState: Tunnel.State) {
        state = newState
    }

    override fun onCreate() {
        super.onCreate()
        backend = GoBackend(this)
        BaseVpnService.createNotificationChannel(this)
        startForeground(BaseVpnService.NOTIFICATION_ID, buildNotification("Initializing..."))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val config = ProtocolConfig.fromIntent(intent ?: return START_NOT_STICKY)
        thread {
            try {
                val wgConfig = buildWgConfig(config)
                backend.setState(this, Tunnel.State.UP, wgConfig)
            } catch (e: Exception) {
                android.util.Log.e("WireGuardService", "Failed to bring tunnel up", e)
                stopSelf()
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        try {
            if (::backend.isInitialized) backend.setState(this, Tunnel.State.DOWN, null)
        } catch (e: Exception) {
            android.util.Log.e("WireGuardService", "Failed to bring tunnel down", e)
        }
        super.onDestroy()
    }

    override fun onRevoke() {
        stopSelf()
    }

    private fun buildWgConfig(config: ProtocolConfig): Config {
        require(!config.wgPrivateKey.isNullOrBlank()) { "WireGuard private key is missing - fill Server.wgPrivateKey" }
        require(!config.wgServerPublicKey.isNullOrBlank()) { "WireGuard server public key is missing - fill Server.wgServerPublicKey" }

        val iface = Interface.Builder()
            .parsePrivateKey(config.wgPrivateKey)
            .parseAddresses(config.wgAddress ?: "10.66.66.2/32")
            .parseDnsServers(config.wgDns ?: "1.1.1.1")
            .build()

        val peerBuilder = Peer.Builder()
            .parsePublicKey(config.wgServerPublicKey)
            .parseEndpoint("${config.server}:${config.port}")
            .parseAllowedIPs("0.0.0.0/0, ::/0")
            .setPersistentKeepalive(25)
        if (!config.wgPresharedKey.isNullOrBlank()) {
            peerBuilder.parsePreSharedKey(config.wgPresharedKey)
        }

        return Config.Builder()
            .setInterface(iface)
            .addPeer(peerBuilder.build())
            .build()
    }

    private fun buildNotification(text: String) =
        NotificationCompat.Builder(this, BaseVpnService.CHANNEL_ID)
            .setContentTitle("T1Tunnel WireGuard")
            .setContentText(text)
            .setSmallIcon(android.R.drawable.ic_menu_share)
            .setContentIntent(
                PendingIntent.getActivity(
                    this, 0, Intent(this, MainActivity::class.java),
                    PendingIntent.FLAG_IMMUTABLE
                )
            )
            .build()
}
