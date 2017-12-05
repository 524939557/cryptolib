/**
 * SHA1Test - Class to test sha1 hash function
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

class SHA1Test {

    @Test
    fun hash() {
        Assert.assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", SHA1.hash(""))
        Assert.assertEquals("86f7e437faa5a7fce15d1ddcb9eaeaea377667b8", SHA1.hash("a"))
        Assert.assertEquals("a9993e364706816aba3e25717850c26c9cd0d89d", SHA1.hash("abc"))
        Assert.assertEquals("32d10c7b8cf96570ca04ce37f2a19d84240d3a89", SHA1.hash("abcdefghijklmnopqrstuvwxyz"))
        Assert.assertEquals("c12252ceda8be8994d5fa0290a47231c1d16aae3", SHA1.hash("message digest"))
        Assert.assertEquals("761c457bf73b14d27e9e9265c46f4b4dda11f940", SHA1.hash("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"))
        Assert.assertEquals("50abf5706a150990a08b2c5ea40fa0e585554732", SHA1.hash("12345678901234567890123456789012345678901234567890123456789012345678901234567890"))
        Assert.assertEquals("2925b1e66a9bc6546ce0aba28dc340cd20af121a", SHA1.hash("A quick movement of the enemy will jeopardize six gunboats."))
        Assert.assertEquals("73e726fbce61818e7f4f93c9c02770238285233f", SHA1.hash("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }
}