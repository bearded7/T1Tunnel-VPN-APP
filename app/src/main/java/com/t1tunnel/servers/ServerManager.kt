package com.t1tunnel.servers

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ServerManager {
    private var allServers: List<Server> = emptyList()

    fun init(context: Context) {
        val json = context.assets.open("servers.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Server>>() {}.type
        allServers = Gson().fromJson(json, type)
    }

    fun getServers(protocol: String): List<Server> {
        return allServers.filter { it.protocol.equals(protocol, ignoreCase = true) }
    }

    fun getWireGuardPeers(): List<Server> {
        return getServers("wireguard")
    }
}

data class Server(
    val name: String,
    val host: String,
    val port: Int,
    val protocol: String = "vless",
    val sni: String? = null,
    val bugHost: String? = null,
    val publicKey: String? = null,
    val endpoint: String? = null
)