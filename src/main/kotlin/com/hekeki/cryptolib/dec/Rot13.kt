/**
 * Rot13 - Convert text to rot13 encoded string and vice versa.
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

object Rot13 {

    fun encode(str: String): String {
        val chars = str.toCharArray()

        for (i in 0 until chars.size) {
            chars[i] = rotate(chars[i])
        }

        return String(chars)
    }

    fun decode(str: String): String {
        return encode(str)
    }

    private fun rotate(ch: Char): Char {
        var c = ch
        if (c in 'a'..'m' || c in 'A'..'M')
            c = (c.toInt() + 13).toChar()
        else if (c in 'n'..'z' || c in 'N'..'Z')
            c = (c.toInt() - 13).toChar()
        return c
    }
}