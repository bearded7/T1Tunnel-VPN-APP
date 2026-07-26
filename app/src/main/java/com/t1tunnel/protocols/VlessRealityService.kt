package com.t1tunnel.protocols
import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
class VlessRealityService : BaseVpnService() {
    override val protocolName = "VlessRealityService"
    override fun startProtocol(config: ProtocolConfig) { /* integrate library */ }
    override fun stopProtocol() {}
}
