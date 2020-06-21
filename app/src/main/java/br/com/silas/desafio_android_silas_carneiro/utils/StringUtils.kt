package br.com.silas.desafio_android_silas_carneiro.utils

import java.lang.Exception
import java.lang.StringBuilder
import java.security.MessageDigest

fun getMd5(value: String) : String {
    return try {
        val md5 = MessageDigest.getInstance("MD5")
        val md5ByteArray = md5.digest(value.toByteArray()).toTypedArray()
        byteArrayToHexString(md5ByteArray)
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}

private fun byteArrayToHexString(array: Array<Byte>): String {
    val result = StringBuilder(array.size * 2)

    for (byte in array) {
        val toAppend = String.format("%2X", byte).replace(" ", "0")
        result.append(toAppend)
    }
    return result.toString()
}