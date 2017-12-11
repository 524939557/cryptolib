/**
 * SHA384Test - Class to test SHA384 hash function
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

class SHA384Test {

    @Test
    fun hash() {
        Assert.assertEquals("54a59b9f22b0b80880d8427e548b7c23abd873486e1f035dce9cd697e85175033caa88e6d57bc35efae0b5afd3145f31", SHA384.hash("a"))
        Assert.assertEquals("cb00753f45a35e8bb5a03d699ac65007272c32ab0eded1631a8b605a43ff5bed8086072ba1e7cc2358baeca134c825a7", SHA384.hash("abc"))
        Assert.assertEquals("feb67349df3db6f5924815d6c3dc133f091809213731fe5c7b5f4999e463479ff2877f5f2936fa63bb43784b12f3ebb4", SHA384.hash("abcdefghijklmnopqrstuvwxyz"))
        Assert.assertEquals("473ed35167ec1f5d8e550368a3db39be54639f828868e9454c239fc8b52e3c61dbd0d8b4de1390c256dcbb5d5fd99cd5", SHA384.hash("message digest"))
        Assert.assertEquals("1761336e3f7cbfe51deb137f026f89e01a448e3b1fafa64039c1464ee8732f11a5341a6f41e0c202294736ed64db1a84", SHA384.hash("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"))
        Assert.assertEquals("b12932b0627d1c060942f5447764155655bd4da0c9afa6dd9b9ef53129af1b8fb0195996d2de9ca0df9d821ffee67026", SHA384.hash("12345678901234567890123456789012345678901234567890123456789012345678901234567890"))
        Assert.assertEquals("bf58ce1ace30308a48e61ba626033ff933087210a3372086a418159a53df22813a1b57501161e0301b8c61a769a62901", SHA384.hash("A quick movement of the enemy will jeopardize six gunboats."))
        Assert.assertEquals("faf1258731db71195f8358b160914d235141b2c0bb7d203c2e15b9d44bee4efa8c919368a463a0dcf3486bbc16cce0c1", SHA384.hash("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }
}