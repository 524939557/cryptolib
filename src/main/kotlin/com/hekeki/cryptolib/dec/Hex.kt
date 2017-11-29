/**
 * Hex - Convert (ascii or unicode) text to hex, convert hex to binary, decimal or text.
 *
 * Copyright (c) 2017 Dirk Gerhardt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.hekeki.cryptolib.dec

import java.nio.charset.Charset

object Hex {

    fun toBinary(hex: String): String {
        var i = 0
        var erg = ""
        while (i < hex.length) {
            val str = hex.substring(i, i + 2)
            erg += Binary.paddingBinary(str.toLong(16).toString(2), 8)
            i+=2
        }
        return erg
    }

    fun toDecimal(hex: String): String {
        var i = 0
        var erg = ""
        while (i < hex.length) {
            val str = hex.substring(i, i + 2)
            erg += str.toLong(16).toString(10)
            i+=2
        }
        return erg
    }

    fun toText(hex: String): String {
        var i = 0
        var erg = ""
        while (i < hex.length) {
            val str = hex.substring(i, i + 2)
            erg += str.toInt(16).toChar()
            i+=2
        }
        return erg
    }

    fun encode(str: String): String {
        val chars = str.toCharArray()
        var erg = ""
        for (i in chars.indices) {
            erg += Integer.toHexString(chars[i].toInt())
        }
        return erg
    }

    fun encode(bytes: ByteArray, charset: Charset): String = encode(String(bytes, charset))
}