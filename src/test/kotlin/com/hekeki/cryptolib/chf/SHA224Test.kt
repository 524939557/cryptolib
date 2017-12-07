/**
 * SHA224Test - Class to test sha224 hash function
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

class SHA224Test {

    @Test
    fun hash() {
        Assert.assertEquals("abd37534c7d9a2efb9465de931cd7055ffdb8879563ae98078d6d6d5", SHA224.hash("a"))
        Assert.assertEquals("23097d223405d8228642a477bda255b32aadbce4bda0b3f7e36c9da7", SHA224.hash("abc"))
        Assert.assertEquals("45a5f72c39c5cff2522eb3429799e49e5f44b356ef926bcf390dccc2", SHA224.hash("abcdefghijklmnopqrstuvwxyz"))
        Assert.assertEquals("2cb21c83ae2f004de7e81c3c7019cbcb65b71ab656b22d6d0c39b8eb", SHA224.hash("message digest"))
        Assert.assertEquals("bff72b4fcb7d75e5632900ac5f90d219e05e97a7bde72e740db393d9", SHA224.hash("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"))
        Assert.assertEquals("b50aecbe4e9bb0b57bc5f3ae760a8e01db24f203fb3cdcd13148046e", SHA224.hash("12345678901234567890123456789012345678901234567890123456789012345678901234567890"))
        Assert.assertEquals("2f28d06085fc21406330807d363f6bab28397db0961f69e46adbfd90", SHA224.hash("A quick movement of the enemy will jeopardize six gunboats."))
        Assert.assertEquals("c351077fb359c8dc9f87adb486826bdb92894aca9090095d2ca11133", SHA224.hash("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }
}