/**
 * Text - Convert text to binary, decimal or hex.
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

object Text {

    fun toBinary(text: String): String {
        var erg = ""
        val chars = text.toCharArray()
        for (i in chars.indices)
            erg += Binary.paddingBinary(chars[i].toInt().toString(2))
        return erg
    }

    fun toDecimal(text: String): String {
        var erg = ""
        val chars = text.toCharArray()
        for (i in chars.indices)
            erg += chars[i].toInt()
        return erg
    }

    fun toHex(text: String): String {
        return Hex.encode(text)
    }
}