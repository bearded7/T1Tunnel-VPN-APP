package com.t1tunnel.protocols

import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
import com.t1tunnel.servers.ServerManager
import com.wireguard.android.backend.GoBackend
import com.wireguard.config.*
import kotlin.random.Random

class WireGuardService : BaseVpnService() {
    override val protocolName = "WireGuard"

    override fun startProtocol(config: ProtocolConfig) {
        val peers = ServerManager.getWireGuardPeers()
        if (peers.isEmpty()) return

        // Pick a random peer for each connection
        val randomPeer = peers[Random.nextInt(peers.size)]

        // ⚠️ Replace this with your actual local WireGuard private key
        val localPrivateKey = "a0cfa4a0-916e-4f74-a20a-1b2a54e0c556"

        val interfaceAddress = InetNetwork.parse("10.0.0.2/24")
        val peer = Peer.Builder()
            .setPublicKey(randomPeer.publicKey)
            .setEndpoint(InetEndpoint.parse(randomPeer.endpoint))
            .setAllowedIps("0.0.0.0/0")
            .setPersistentKeepalive(25)
            .build()
        val iface = Interface.Builder()
            .addAddress(interfaceAddress)
            .setPrivateKey(localPrivateKey)
            .addDnsServer(InetAddresses.parse("1.1.1.1"))
            .build()
        val wgConfig = Config.Builder()
            .setInterface(iface)
            .addPeer(peer)
            .build()

        GoBackend(this).apply {
            setState(wgConfig, GoBackend.State.UP)
        }
    }

    override fun stopProtocol() {
        GoBackend(this).apply { setState(null, GoBackend.State.DOWN) }
    }
}