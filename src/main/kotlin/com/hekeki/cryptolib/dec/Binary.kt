/**
 * Binary - Convert (ascii or unicode) text to binary, convert binary to decimal, hex or text.
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

object Binary {

    fun toDecimal(binary: String): String {
        var i = 0
        var erg = ""
        while (i < binary.length) {
            val str = binary.substring(i, i + 8)
            erg += str.toInt(2)
            i+=8
        }
        return erg
    }

    fun toHex(binary: String): String {
        var i = 0
        var erg = ""
        while (i < binary.length) {
            val str = binary.substring(i, i + 8)
            erg += str.toInt(2).toString(16)
            i+=8
        }
        return erg
    }

    fun toText(binary: String): String {
        var i = 0
        var erg = ""
        while (i < binary.length) {
            val str = binary.substring(i, i + 8)
            erg += str.toInt(2).toChar()
            i+=8
        }
        return erg
    }

    fun encode(str: String): String = Text.toBinary(str)

    fun encode(bytes: ByteArray, charset: Charset): String = encode(String(bytes, charset))

    internal fun paddingBinary(bin: String, length: Int): String {
        var erg = bin
        while (erg.length < length) erg = "0" + erg
        return erg
    }
}