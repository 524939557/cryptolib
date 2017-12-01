/**
 * MD5Test - Class to test md5 hash function
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

class MD5Test {

    @Test
    fun hash() {
        Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e", MD5.hash(""))
        Assert.assertEquals("0cc175b9c0f1b6a831c399e269772661", MD5.hash("a"))
        Assert.assertEquals("900150983cd24fb0d6963f7d28e17f72", MD5.hash("abc"))
        Assert.assertEquals("c3fcd3d76192e4007dfb496cca67e13b", MD5.hash("abcdefghijklmnopqrstuvwxyz"))
        Assert.assertEquals("f96b697d7cb7938d525a2f31aaf161d0", MD5.hash("message digest"))
        Assert.assertEquals("d174ab98d277d9f5a5611c2c9f419d9f", MD5.hash("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"))
        Assert.assertEquals("57edf4a22be3c955ac49da2e2107b67a", MD5.hash("12345678901234567890123456789012345678901234567890123456789012345678901234567890"))
        Assert.assertEquals("5f8cf08267cde2cdc4a331d191b26587", MD5.hash("A quick movement of the enemy will jeopardize six gunboats."))
        Assert.assertEquals("3c5184010296cdd5f20e354c5fdd5ee8", MD5.hash("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }
}