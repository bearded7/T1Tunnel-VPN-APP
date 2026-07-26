package com.t1tunnel
object Tun2Socks {
    init { System.loadLibrary("tun2socks") }
    external fun start(vpnFd: Int, proxyUrl: String, mtu: Int)
    external fun stop()
}
