package com.hekeki.cryptolib.chf

object HMAC {

    private val BLOCK_SIZE_64 = 64
    private val BLOCK_SIZE_128 = 128

    fun md5(key: String, message: String) = hmac(key.toByteArray(), message.toByteArray(), BLOCK_SIZE_64, MD5::hash)

    fun md5(key: ByteArray, message: ByteArray) = hmac(key, message, BLOCK_SIZE_64, MD5::hash)

    fun sha1(key: String, message: String) = hmac(key.toByteArray(), message.toByteArray(), BLOCK_SIZE_64, SHA1::hash)

    fun sha1(key: ByteArray, message: ByteArray) = hmac(key, message, BLOCK_SIZE_64, SHA1::hash)

    fun sha224(key: String, message: String) = hmac(key.toByteArray(), message.toByteArray(), BLOCK_SIZE_64, SHA224::hash)

    fun sha224(key: ByteArray, message: ByteArray) = hmac(key, message, BLOCK_SIZE_64, SHA224::hash)

    fun sha256(key: String, message: String) = hmac(key.toByteArray(), message.toByteArray(), BLOCK_SIZE_64, SHA256::hash)

    fun sha256(key: ByteArray, message: ByteArray) = hmac(key, message, BLOCK_SIZE_64, SHA256::hash)

    fun sha384(key: String, message: String) = hmac(key.toByteArray(), message.toByteArray(), BLOCK_SIZE_128, SHA384::hash)

    fun sha384(key: ByteArray, message: ByteArray) = hmac(key, message, BLOCK_SIZE_128, SHA384::hash)

    fun sha512(key: String, message: String) = hmac(key.toByteArray(), message.toByteArray(), BLOCK_SIZE_128, SHA512::hash)

    fun sha512(key: ByteArray, message: ByteArray) = hmac(key, message, BLOCK_SIZE_128, SHA512::hash)

    private fun hmac(key: ByteArray, message: ByteArray, blockSize: Int, hashFunction: (m: ByteArray) -> ByteArray): String {

        var preprocessedKey = key
        if (preprocessedKey.size > blockSize) {
            preprocessedKey = hashFunction(preprocessedKey)
        }

        if (preprocessedKey.size < blockSize) {
            preprocessedKey = preprocessedKey.copyOf(blockSize)
        }

        val outerPaddedKey = xorByteArray(preprocessedKey, ByteArray(blockSize, { 0x5c }))
        val innerPaddedKey = xorByteArray(preprocessedKey, ByteArray(blockSize, { 0x36 }))

        val ipk = hashFunction(appendBytes(innerPaddedKey, message))
        return encode(hashFunction(appendBytes(outerPaddedKey, ipk)))
    }

    private fun xorByteArray(a: ByteArray, b: ByteArray): ByteArray {
        val result = ByteArray(a.size)
        for (i in b.indices) {
            result[i] = (a[i].toInt() xor b[i].toInt()).toByte()
        }
        return result
    }

    private fun appendBytes(origin: ByteArray, bytesToAppend: ByteArray): ByteArray {
        val result = origin.copyOf(origin.size + bytesToAppend.size)
        for (i in bytesToAppend.indices) {
            result[i+origin.size] = bytesToAppend[i]
        }
        return result
    }

    private fun encode(bytes: ByteArray): String {
        var buf = ""
        var i = 0
        while (i < bytes.size) {
            if (bytes[i].toInt() and 0xff < 0x10) buf += "0"
            buf += (bytes[i].toInt() and 0xff).toLong().toString(16)
            i++
        }
        return buf
    }
}