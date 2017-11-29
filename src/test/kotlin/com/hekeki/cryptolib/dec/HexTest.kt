/**
 * HexTest - Class to test hex encoding
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

class HexTest {

    @Test
    fun toBinary() {

        Assert.assertEquals("010100110110001101101000011101110110010101101001110111110110011101100101011100010111010111100100011011000111010" +
                "0001000000111101011111100011011100110010001100101011101000010000001010100011110010111000001101111011001110111001001100001011001100010" +
                "0000010010100110000101101011011011110110001000100000011101100110010101110010011001100110110001101001011110000111010000100000111101100" +
                "1100100011001010010000001010000011000010110111001100111011100100110000101101101011011010110010100100000011000010110111000101110",
                Hex.toBinary("536368776569df67657175e46c74207afc6e646574205479706f67726166204a616b6f6220766572666c69787420f664652050616e6772616d6d6520616e2e"))
    }

    @Test
    fun toDecimal() {
        Assert.assertEquals("839910411910110522310310111311722810811632122252110100101116328412111211110311497102327497" +
                "10711198321181011141021081051201163224610010132809711010311497109109101329711046",
                Hex.toDecimal("536368776569df67657175e46c74207afc6e646574205479706f67726166204a616b6f6220766572666c69787420f664652050616e6772616d6d6520616e2e"))
    }

    @Test
    fun toText() {
        Assert.assertEquals("A quick movement of the enemy will jeopardize six gunboats.",
                Hex.toText("4120717569636b206d6f76656d656e74206f662074686520656e656d792077696c6c206a656f70617264697a65207369782067756e626f6174732e"))
        Assert.assertEquals("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an.",
                Hex.toText("536368776569df67657175e46c74207afc6e646574205479706f67726166204a616b6f6220766572666c69787420f664652050616e6772616d6d6520616e2e"))
    }

    @Test
    fun encode() {
        Assert.assertEquals("4120717569636b206d6f76656d656e74206f662074686520656e656d792077696c6c206a656f70617264697a65207369782067756e626f6174732e",
                Hex.encode("A quick movement of the enemy will jeopardize six gunboats."))
        Assert.assertEquals("536368776569df67657175e46c74207afc6e646574205479706f67726166204a616b6f6220766572666c69787420f664652050616e6772616d6d6520616e2e",
                Hex.encode("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
        Assert.assertEquals("536368776569df67657175e46c74207afc6e646574205479706f67726166204a616b6f6220766572666c69787420f664652050616e6772616d6d6520616e2e",
                Hex.encode("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an.".toByteArray(Charsets.UTF_8), Charsets.UTF_8))
    }
}