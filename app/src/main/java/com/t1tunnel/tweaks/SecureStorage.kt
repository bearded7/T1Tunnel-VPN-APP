package com.t1tunnel.tweaks

import android.content.Context
import android.content.SharedPreferences
import android.util.Base64

object SecureStorage {
    private const val PREFS_NAME = "secure_prefs"
    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveHostPort(host: String, port: Int, password: String) {
        val data = "$host:$port".toByteArray()
        val encrypted = TweakManager.encrypt(data, password)
        prefs.edit().putString("bug", Base64.encodeToString(encrypted, Base64.DEFAULT)).apply()
    }

    fun getHostPort(password: String): Pair<String, Int>? {
        val encryptedStr = prefs.getString("bug", null) ?: return null
        val encrypted = Base64.decode(encryptedStr, Base64.DEFAULT)
        val decrypted = TweakManager.decrypt(encrypted, password)
        val parts = String(decrypted).split(":")
        return Pair(parts[0], parts[1].toInt())
    }
}
