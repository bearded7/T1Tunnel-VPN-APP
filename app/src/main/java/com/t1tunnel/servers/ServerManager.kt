package com.t1tunnel.servers
object ServerManager {
    val servers = listOf(Server("US East", "us1.t1tunnel.xyz", 443))
}
data class Server(val name: String, val host: String, val port: Int, val sni: String = "www.microsoft.com", val bugHost: String = "www.microsoft.com")
