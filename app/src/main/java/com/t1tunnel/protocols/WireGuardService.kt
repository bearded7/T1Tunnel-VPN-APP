package com.t1tunnel.protocols
import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
class WireGuardService : BaseVpnService() {
    override val protocolName = "WireGuardService"
    override fun startProtocol(config: ProtocolConfig) { /* integrate library */ }
    override fun stopProtocol() {}
}
