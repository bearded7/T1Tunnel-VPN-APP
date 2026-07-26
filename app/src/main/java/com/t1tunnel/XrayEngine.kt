package com.t1tunnel
import com.t1tunnel.xray.Xray
object XrayEngine {
    private var running = false
    fun start(configPath: String) {
        if (running) return
        val json = java.io.File(configPath).readText(Charsets.UTF_8)
        Xray.startXray(json)
        running = true
    }
    fun stop() {
        if (!running) return
        Xray.stopXray()
        running = false
    }
}
