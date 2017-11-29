package com.hekeki.cryptolib.dec

object Binary {

    fun toDecimal(binary: String): String {
        return ""
    }

    fun toHex(binary: String): String {
        return ""
    }

    fun asText(binary: String): String {
        return ""
    }

    fun encode(bytes: ByteArray): String {
        return ""
    }

    internal fun paddingBinary(bin: String): String {
        var erg = bin
        while (erg.length < 8) erg = "0" + erg
        return erg;
    }
}