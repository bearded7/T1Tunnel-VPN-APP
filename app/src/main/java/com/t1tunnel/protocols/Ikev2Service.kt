package com.t1tunnel.protocols
import com.t1tunnel.base.BaseVpnService
import com.t1tunnel.base.ProtocolConfig
class Ikev2Service : BaseVpnService() {
    override val protocolName = "Ikev2Service"
    override fun startProtocol(config: ProtocolConfig) { /* integrate library */ }
    override fun stopProtocol() {}
}
