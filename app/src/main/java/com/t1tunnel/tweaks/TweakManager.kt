package com.t1tunnel.tweaks

import android.content.Context
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

object TweakManager {
    private const val SALT = "T1Tunnel_Salt_2025"
    private const val ITERATIONS = 10000
    private const val GCM_NONCE_LENGTH = 12
    private const val GCM_TAG_LENGTH = 128

    fun exportTweaks(context: Context, tweaks: Map<String, Any>, password: String): File {
        val json = com.google.gson.Gson().toJson(tweaks)
        val encrypted = encrypt(json.toByteArray(Charsets.UTF_8), password)
        val exportFile = File(context.cacheDir, "tweaks.enc")
        exportFile.writeBytes(encrypted)
        return exportFile
    }

    fun importTweaks(file: File, password: String): Map<String, Any>? {
        val encrypted = file.readBytes()
        val decrypted = decrypt(encrypted, password)
        return try {
            com.google.gson.Gson().fromJson(String(decrypted, Charsets.UTF_8), Map::class.java)
                .mapKeys { it.key.toString() } as Map<String, Any>
        } catch (e: Exception) {
            null
        }
    }

    fun encrypt(data: ByteArray, password: String): ByteArray {
        val key = deriveKey(password)
        val nonce = ByteArray(GCM_NONCE_LENGTH)
        SecureRandom().nextBytes(nonce)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val spec = GCMParameterSpec(GCM_TAG_LENGTH, nonce)
        cipher.init(Cipher.ENCRYPT_MODE, key, spec)
        val encrypted = cipher.doFinal(data)
        val output = ByteArrayOutputStream()
        output.write(nonce)
        output.write(encrypted)
        return output.toByteArray()
    }

    fun decrypt(encryptedData: ByteArray, password: String): ByteArray {
        val nonce = encryptedData.copyOfRange(0, GCM_NONCE_LENGTH)
        val ciphertext = encryptedData.copyOfRange(GCM_NONCE_LENGTH, encryptedData.size)
        val key = deriveKey(password)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val spec = GCMParameterSpec(GCM_TAG_LENGTH, nonce)
        cipher.init(Cipher.DECRYPT_MODE, key, spec)
        return cipher.doFinal(ciphertext)
    }

    private fun deriveKey(password: String): SecretKey {
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val spec = PBEKeySpec(password.toCharArray(), SALT.toByteArray(), ITERATIONS, 256)
        val tmp = factory.generateSecret(spec)
        return SecretKeySpec(tmp.encoded, "AES")
    }
}
