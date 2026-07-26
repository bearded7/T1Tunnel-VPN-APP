package com.t1tunnel

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.t1tunnel.ads.AdManager
import com.t1tunnel.protocols.*
import com.t1tunnel.servers.ServerManager
import com.t1tunnel.tweaks.SecureStorage
import com.t1tunnel.tweaks.TweakManager

class MainActivity : Activity() {
    private lateinit var btnToggle: Button
    private lateinit var btnExport: Button
    private lateinit var btnImport: Button
    private lateinit var protocolSpinner: Spinner
    private lateinit var serverSpinner: Spinner
    private lateinit var modeSpinner: Spinner
    private var isRunning = false
    private var currentProtocolTag = "vless"   // default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SecureStorage.init(this)
        ServerManager.init(this)   // load servers from assets

        AdManager.loadBanner(this, findViewById(R.id.ad_container))
        protocolSpinner = findViewById(R.id.protocol_spinner)
        serverSpinner = findViewById(R.id.server_spinner)
        modeSpinner = findViewById(R.id.mode_spinner)
        btnToggle = findViewById(R.id.btn_toggle)
        btnExport = findViewById(R.id.btn_export)
        btnImport = findViewById(R.id.btn_import)

        // Protocol spinner entries
        ArrayAdapter.createFromResource(this, R.array.protocols, android.R.layout.simple_spinner_item)
            .also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); protocolSpinner.adapter = it }

        // Tunnel mode entries
        modeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            arrayOf("Direct","HTTP Connect","Raw TCP","TLS Tunnel","WebSocket","WS Secure","WS CDN","WS Secure CDN"))

        // When protocol changes, reload server list
        protocolSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentProtocolTag = when (position) {
                    0 -> "vless"
                    1 -> "wireguard"
                    2 -> "openvpn_udp"
                    3 -> "openvpn_tcp"
                    4 -> "ikev2"
                    else -> "vless"
                }
                val servers = ServerManager.getServers(currentProtocolTag)
                val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, servers.map { it.name })
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                serverSpinner.adapter = adapter
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Start / Stop VPN
        btnToggle.setOnClickListener {
            if (!isRunning) startVpn() else stopVpn()
        }
        btnExport.setOnClickListener { exportTweaks() }
        btnImport.setOnClickListener { importTweaks() }
    }

    private fun startVpn() {
        val intent = VpnService.prepare(this)
        if (intent != null) {
            startActivityForResult(intent, REQUEST_VPN)
        } else {
            onVpnPermissionGranted()
        }
    }

    private fun stopVpn() {
        stopService(Intent(this, VlessRealityService::class.java))   // adjust if needed
        isRunning = false
        btnToggle.text = "Connect to Torit"
        Toast.makeText(this, "VPN disconnected", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_VPN && resultCode == RESULT_OK) {
            onVpnPermissionGranted()
        } else if (requestCode == REQUEST_IMPORT) {
            data?.data?.let { uri ->
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
        val servers = ServerManager.getServers(currentProtocolTag)
        if (servers.isEmpty()) {
            Toast.makeText(this, "No servers for this protocol", Toast.LENGTH_SHORT).show()
            return
        }
        val server = servers[serverSpinner.selectedItemPosition]

        val serviceClass = when (currentProtocolTag) {
            "vless" -> VlessRealityService::class.java
            "wireguard" -> WireGuardService::class.java
            "openvpn_udp" -> OpenVpnUdpService::class.java
            "openvpn_tcp" -> OpenVpnTcpService::class.java
            "ikev2" -> Ikev2Service::class.java
            else -> return
        }

        val configIntent = Intent(this, serviceClass).apply {
            putExtra("server", server.host)
            putExtra("port", server.port)
            putExtra("uuid", "YOUR_UUID_HERE")
            putExtra("sni", server.sni ?: "")
            putExtra("bugHost", server.bugHost ?: "")
            putExtra("mode", modeSpinner.selectedItem.toString())
            putExtra("publicKey", server.publicKey ?: "")
            putExtra("endpoint", server.endpoint ?: "")
        }
        startService(configIntent)
        isRunning = true
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

    private fun getCurrentTweaksAsMap(): Map<String, Any> = mapOf(
        "protocol" to currentProtocolTag,
        "mode" to modeSpinner.selectedItem.toString(),
        "server" to serverSpinner.selectedItem.toString()
    )

    private fun applyTweaks(map: Map<String, Any>) {
        // Apply imported settings (demo)
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