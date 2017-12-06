/**
 * SHA256Test - Class to test sha256 hash function
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
package com.hekeki.cryptolib.chf

import org.junit.Assert
import org.junit.Test

class SHA256Test {

    @Test
    fun hash() {
        Assert.assertEquals("ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb", SHA256.hash("a"))
        Assert.assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad", SHA256.hash("abc"))
        Assert.assertEquals("71c480df93d6ae2f1efad1447c66c9525e316218cf51fc8d9ed832f2daf18b73", SHA256.hash("abcdefghijklmnopqrstuvwxyz"))
        Assert.assertEquals("f7846f55cf23e14eebeab5b4e1550cad5b509e3348fbc4efa3a1413d393cb650", SHA256.hash("message digest"))
        Assert.assertEquals("db4bfcbd4da0cd85a60c3c37d3fbd8805c77f15fc6b1fdfe614ee0a7c8fdb4c0", SHA256.hash("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"))
        Assert.assertEquals("f371bc4a311f2b009eef952dd83ca80e2b60026c8e935592d0f9c308453c813e", SHA256.hash("12345678901234567890123456789012345678901234567890123456789012345678901234567890"))
        Assert.assertEquals("44c6ca4bc6499411de24a6bb71945b3043e08d2bf5f62b5527c20f72b2279531", SHA256.hash("A quick movement of the enemy will jeopardize six gunboats."))
        Assert.assertEquals("769d3267b99ee6a8c9adcacaec064d34dbce28a43762e1b2585c25318a67dbbd", SHA256.hash("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }
}