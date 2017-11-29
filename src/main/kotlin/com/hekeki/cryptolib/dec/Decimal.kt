/**
 * Decimal - Convert decimal to binary, hex or octal.
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

object Decimal {

    fun toBinary(decimal: Long): String {
        var erg = decimal.toString(2)
        if(erg.length % 2 != 0) erg = "0" + erg
        return erg
    }

    fun toHex(decimal: Long): String {
        return decimal.toString(16)
    }

    fun toOctal(decimal: Long): Long {
        return decimal.toString(8).toLong()
    }
}