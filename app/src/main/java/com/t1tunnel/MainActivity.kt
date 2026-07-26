package com.t1tunnel

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.t1tunnel.ads.AdManager
import com.t1tunnel.protocols.Ikev2Service
import com.t1tunnel.protocols.OpenVpnTcpService
import com.t1tunnel.protocols.OpenVpnUdpService
import com.t1tunnel.protocols.VlessRealityService
import com.t1tunnel.protocols.WireGuardService
import com.t1tunnel.protocols.openvpn.OpenVpnBridge
import com.t1tunnel.protocols.openvpn.StrongSwanBridge
import com.t1tunnel.servers.Server
import com.t1tunnel.servers.ServerManager
import com.t1tunnel.tunneld.TunnelMode
import com.t1tunnel.tweaks.SecureStorage
import com.t1tunnel.tweaks.TweakManager

private enum class Protocol { VLESS_REALITY, WIREGUARD, OPENVPN_UDP, OPENVPN_TCP, IKEV2 }

class MainActivity : Activity() {
    private lateinit var btnToggle: Button
    private lateinit var btnExport: Button
    private lateinit var btnImport: Button
    private lateinit var protocolSpinner: Spinner
    private lateinit var serverSpinner: Spinner
    private lateinit var modeSpinner: Spinner
    private var isRunning = false
    private var activeProtocol: Protocol? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SecureStorage.init(this)

        AdManager.loadBanner(this, findViewById(R.id.ad_container))
        protocolSpinner = findViewById(R.id.protocol_spinner)
        serverSpinner = findViewById(R.id.server_spinner)
        modeSpinner = findViewById(R.id.mode_spinner)
        btnToggle = findViewById(R.id.btn_toggle)
        btnExport = findViewById(R.id.btn_export)
        btnImport = findViewById(R.id.btn_import)

        ArrayAdapter.createFromResource(this, R.array.protocols, android.R.layout.simple_spinner_item)
            .also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); protocolSpinner.adapter = it }
        // Order must match TunnelMode's enum ordinal order exactly - MainActivity sends the
        // selected index straight through as "modeOrdinal" for XrayConfigBuilder to consume.
        modeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            arrayOf("Direct", "HTTP Connect", "Raw TCP", "TLS Tunnel", "WebSocket", "WS Secure", "WS CDN", "WS Secure CDN"))
        serverSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            ServerManager.servers.map { it.name })

        btnToggle.setOnClickListener {
            if (!isRunning) {
                startVpn()
            } else {
                stopVpn()
            }
        }
        btnExport.setOnClickListener { exportTweaks() }
        btnImport.setOnClickListener { importTweaks() }
    }

    private fun currentServer(): Server = ServerManager.servers[serverSpinner.selectedItemPosition]

    private fun currentProtocol(): Protocol = when (protocolSpinner.selectedItemPosition) {
        0 -> Protocol.VLESS_REALITY
        1 -> Protocol.WIREGUARD
        2 -> Protocol.OPENVPN_UDP
        3 -> Protocol.OPENVPN_TCP
        4 -> Protocol.IKEV2
        else -> Protocol.VLESS_REALITY
    }

    private fun startVpn() {
        when (currentProtocol()) {
            Protocol.VLESS_REALITY, Protocol.WIREGUARD -> {
                // These two establish the OS-level tun themselves, so this app needs the
                // standard VpnService consent dialog.
                val intent = VpnService.prepare(this)
                if (intent != null) {
                    startActivityForResult(intent, REQUEST_VPN)
                } else {
                    onVpnPermissionGranted()
                }
            }
            Protocol.OPENVPN_UDP -> OpenVpnBridge.connect(this, currentServer(), useTcp = false)
                .also { markRunning(Protocol.OPENVPN_UDP) }
            Protocol.OPENVPN_TCP -> OpenVpnBridge.connect(this, currentServer(), useTcp = true)
                .also { markRunning(Protocol.OPENVPN_TCP) }
            Protocol.IKEV2 -> StrongSwanBridge.importProfile(this, currentServer())
                .also { markRunning(Protocol.IKEV2) }
        }
    }

    private fun markRunning(protocol: Protocol) {
        activeProtocol = protocol
        isRunning = true
        btnToggle.text = "Stop VPN"
        Toast.makeText(this, "VPN connecting via companion app...", Toast.LENGTH_LONG).show()
    }

    private fun stopVpn() {
        when (activeProtocol) {
            Protocol.VLESS_REALITY -> stopService(Intent(this, VlessRealityService::class.java))
            Protocol.WIREGUARD -> stopService(Intent(this, WireGuardService::class.java))
            Protocol.OPENVPN_UDP, Protocol.OPENVPN_TCP -> OpenVpnBridge.disconnect(this)
            Protocol.IKEV2 -> StrongSwanBridge.disconnect(this, null)
            null -> {}
        }
        activeProtocol = null
        isRunning = false
        btnToggle.text = "Connect to Torit"
        Toast.makeText(this, "VPN disconnected", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_VPN -> if (resultCode == RESULT_OK) onVpnPermissionGranted()
            OpenVpnBridge.REQUEST_OVPN_PERMISSION -> if (resultCode == RESULT_OK) {
                OpenVpnBridge.onPermissionResult(this, currentServer(), currentProtocol() == Protocol.OPENVPN_TCP)
            }
            OpenVpnBridge.REQUEST_OVPN_VPN_CONSENT -> if (resultCode == RESULT_OK) {
                OpenVpnBridge.onVpnConsentResult(this, currentServer(), currentProtocol() == Protocol.OPENVPN_TCP)
            }
            StrongSwanBridge.REQUEST_IMPORT_PROFILE -> {
                Toast.makeText(this, "In strongSwan, tap the imported profile to connect.", Toast.LENGTH_LONG).show()
            }
            REQUEST_IMPORT -> data?.data?.let { uri ->
                val inputStream = contentResolver.openInputStream(uri)
                val file = java.io.File(cacheDir, "temp_import.enc")
                inputStream?.use { it.copyTo(file.outputStream()) }
                showPasswordDialog("Enter password to decrypt") { password ->
                    val map = TweakManager.importTweaks(file, password)
                    if (map != null) {
                        applyTweaks(map)
                        Toast.makeText(this, "Tweaks imported", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Wrong password or corrupted file", Toast.LENGTH_SHORT).show()
                    }
                    file.delete()
                }
            }
        }
    }

    private fun onVpnPermissionGranted() {
        val protocol = currentProtocol()
        val serviceClass = when (protocol) {
            Protocol.VLESS_REALITY -> VlessRealityService::class.java
            Protocol.WIREGUARD -> WireGuardService::class.java
            // OpenVPN/IKEv2 don't reach this branch (handled in startVpn() directly), but the
            // `when` must be exhaustive.
            Protocol.OPENVPN_UDP -> OpenVpnUdpService::class.java
            Protocol.OPENVPN_TCP -> OpenVpnTcpService::class.java
            Protocol.IKEV2 -> Ikev2Service::class.java
        }
        val server = currentServer()
        val modeOrdinal = modeSpinner.selectedItemPosition
            .coerceIn(0, TunnelMode.entries.size - 1)
        val configIntent = Intent(this, serviceClass).apply {
            putExtra("server", server.host)
            putExtra("port", server.port)
            putExtra("uuid", server.vlessUuid)
            putExtra("sni", server.sni)
            putExtra("bugHost", server.bugHost)
            putExtra("mode", modeSpinner.selectedItem.toString())
            putExtra("modeOrdinal", modeOrdinal)
            putExtra("realityPublicKey", server.realityPublicKey)
            putExtra("realityShortId", server.realityShortId)
            putExtra("wgPrivateKey", server.wgPrivateKey)
            putExtra("wgServerPublicKey", server.wgServerPublicKey)
            putExtra("wgPresharedKey", server.wgPresharedKey)
            putExtra("wgAddress", server.wgAddress)
            putExtra("wgDns", server.wgDns)
        }
        startService(configIntent)
        markRunning(protocol)
        btnToggle.text = "Stop VPN"
        Toast.makeText(this, "VPN connected", Toast.LENGTH_SHORT).show()
    }

    private fun exportTweaks() {
        showPasswordDialog("Enter password for export") { password ->
            val tweaks = getCurrentTweaksAsMap()
            val file = TweakManager.exportTweaks(this, tweaks, password)
            val uri = FileProvider.getUriForFile(this, "${packageName}.fileprovider", file)
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "application/octet-stream"
                putExtra(Intent.EXTRA_STREAM, uri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivity(Intent.createChooser(shareIntent, "Share tweaks file"))
        }
    }

    private fun importTweaks() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"
        }
        startActivityForResult(intent, REQUEST_IMPORT)
    }

    private fun getCurrentTweaksAsMap(): Map<String, Any> {
        return mapOf(
            "protocol" to protocolSpinner.selectedItem.toString(),
            "mode" to modeSpinner.selectedItem.toString(),
            "server" to serverSpinner.selectedItem.toString()
        )
    }

    private fun applyTweaks(map: Map<String, Any>) {
        val protocolName = map["protocol"] as? String
        val protocolIndex = (protocolSpinner.adapter as? ArrayAdapter<String>)?.let { adapter ->
            (0 until adapter.count).firstOrNull { adapter.getItem(it) == protocolName }
        }
        protocolIndex?.let { protocolSpinner.setSelection(it) }

        val modeName = map["mode"] as? String
        val modeIndex = (modeSpinner.adapter as? ArrayAdapter<String>)?.let { adapter ->
            (0 until adapter.count).firstOrNull { adapter.getItem(it) == modeName }
        }
        modeIndex?.let { modeSpinner.setSelection(it) }

        val serverName = map["server"] as? String
        val serverIndex = ServerManager.servers.indexOfFirst { it.name == serverName }
        if (serverIndex >= 0) serverSpinner.setSelection(serverIndex)
    }

    private fun showPasswordDialog(title: String, callback: (String) -> Unit) {
        val editText = EditText(this)
        editText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        AlertDialog.Builder(this)
            .setTitle(title)
            .setView(editText)
            .setPositiveButton("OK") { dialog, _ ->
                callback(editText.text.toString())
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    companion object {
        private const val REQUEST_VPN = 100
        private const val REQUEST_IMPORT = 101
    }
}
