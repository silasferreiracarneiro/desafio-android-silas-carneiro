package br.com.silas.desafio_android_silas_carneiro.utils

import java.security.MessageDigest

fun md5(value: String) : String {
    return try {
        val digest = MessageDigest.getInstance("MD5")
        digest.update(value.toByteArray())
        val messageDigest = digest.digest()
        byteArrayToHexString(messageDigest)
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}

private fun byteArrayToHexString(array: ByteArray): String {
    val hexString = StringBuilder()
    for (aMessageDigest in array) {
        var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
        while (h.length < 2) h = "0$h"
        hexString.append(h)
    }
    return hexString.toString()
}