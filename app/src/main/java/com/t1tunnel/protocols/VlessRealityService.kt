package com.t1tunnel.protocols

import com.t1tunnel.XrayEngine
import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
import com.t1tunnel.xray.XrayConfigBuilder
import java.io.File

class VlessRealityService : BaseVpnService() {
    override val protocolName = "VLESS+Reality"

    override fun startProtocol(config: ProtocolConfig) {
        val json = XrayConfigBuilder.build(config, config.tunnelMode)
        val configFile = File(filesDir, "xray_config.json")
        configFile.writeText(json)
        XrayEngine.start(configFile.absolutePath)
    }

    override fun stopProtocol() {
        XrayEngine.stop()
    }
}
