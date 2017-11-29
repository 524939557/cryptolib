/**
 * DecimalTest - Class to test decimal encoding
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

import org.junit.Assert
import org.junit.Test

class DecimalTest {

    @Test
    fun toBinary() {
        Assert.assertEquals("11010100100100100010010110101010111111", Decimal.toBinary(228246252223))
    }

    @Test
    fun toHex() {
        Assert.assertEquals("3524896abf", Decimal.toHex(228246252223))
    }

    @Test
    fun toText() {
        Assert.assertEquals(3244442265277, Decimal.toOctal(228246252223))
    }
}