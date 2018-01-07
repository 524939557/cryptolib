package com.hekeki.cryptolib.chf

import java.security.SecureRandom

object BCrypt {

    private val DEFAULT_SALT_SIZE = 16
    private val DEFAULT_LOG2_ROUNDS = 10
    private val CIPHERTEXT = intArrayOf(0x4f727068, 0x65616e42, 0x65686f6c, 0x64657253, 0x63727944, 0x6f756274)
    val BCRYPT_BASE64_ENCODE = "./ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val BCRYPT_BASE64_DECODE = byteArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -1, -1, -1, -1, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, -1, -1, -1, -1, -1, -1, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
            48, 49, 50, 51, 52, 53, -1, -1, -1, -1, -1)

    fun hash(message: String): String {
        return hash(message, DEFAULT_LOG2_ROUNDS)
    }

    fun hash(message: String, rounds: Int): String {
        return hash(message, rounds, salt())
    }

    fun hash(message: String, rounds: Int, salt: ByteArray): String {
        return String(bcrypt(rounds, salt, message.toByteArray()))
    }

    fun verify(message: String, hashed: String): Boolean {
        return true
    }

    private fun bcrypt(cost: Int, salt: ByteArray, password: ByteArray): ByteArray {

        var i = 0
        val ctext = CIPHERTEXT.clone()
        while(i in 0..63) {

        }
        return ByteArray(1)
    }

    private fun salt(): ByteArray {
        val saltBytes = ByteArray(DEFAULT_SALT_SIZE)
        SecureRandom.getInstance("SHA1PRNG").nextBytes(saltBytes)
        return saltBytes;
    }

    internal fun encodeBase64(bytes: ByteArray, len: Int): String {
        val chars = "./ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        var salt = ""
        var c1: Int
        var c2: Int
        var si = 0
        while (si < len) {
            c1 = bytes[si++].toInt() and 0xff
            salt += chars[c1 shr 2 and 0x3f]
            c1 = c1 and 0x03 shl 4
            if (si >= len) {
                salt += chars[c1 and 0x3f]
                break
            }
            c2 = bytes[si++].toInt() and 0xff
            c1 = c1 or (c2 shr 4 and 0x0f)
            salt += chars[c1 and 0x3f]
            c1 = c2 and 0x0f shl 2
            if (si >= len) {
                salt += chars[c1 and 0x3f]
                break
            }
            c2 = bytes[si++].toInt() and 0xff
            c1 = c1 or (c2 shr 6 and 0x03)
            salt += chars[c1 and 0x3f]
            salt += chars[c2 and 0x3f]
        }
        return salt
    }
}