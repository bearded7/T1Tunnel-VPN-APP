package com.t1tunnel.protocols
import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
class OpenVpnUdpService : BaseVpnService() {
    override val protocolName = "OpenVpnUdpService"
    override fun startProtocol(config: ProtocolConfig) { /* integrate library */ }
    override fun stopProtocol() {}
}
