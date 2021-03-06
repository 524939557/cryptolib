/**
 * TextTest - Class to test text encoding
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

class TextTest {

    @Test
    fun toBinary() {

        Assert.assertEquals("0100000100100000011100010111010101101001011000110110101100100000011011010110111101" +
                "11011001100101011011010110010101101110011101000010000001101111011001100010000001110100011010000110010100" +
                "10000001100101011011100110010101101101011110010010000001110111011010010110110001101100001000000110101001" +
                "10010101101111011100000110000101110010011001000110100101111010011001010010000001110011011010010111100000" +
                "100000011001110111010101101110011000100110111101100001011101000111001100101110",
                Text.toBinary("A quick movement of the enemy will jeopardize six gunboats."))

        Assert.assertEquals("0101001101100011011010000111011101100101011010011101111101100111011001010111000101" +
                "11010111100100011011000111010000100000011110101111110001101110011001000110010101110100001000000101010001" +
                "11100101110000011011110110011101110010011000010110011000100000010010100110000101101011011011110110001000" +
                "10000001110110011001010111001001100110011011000110100101111000011101000010000011110110011001000110010100" +
                "10000001010000011000010110111001100111011100100110000101101101011011010110010100100000011000010110111000101110",
                Text.toBinary("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))

    }

    @Test
    fun toDecimal() {

        Assert.assertEquals("6532113117105991073210911111810110910111011632111102321161041013210111010110912132" +
                "11910510810832106101111112971141001051221013211510512032103117110981119711611546",
                Text.toDecimal("A quick movement of the enemy will jeopardize six gunboats."))

        Assert.assertEquals("8399104119101105223103101113117228108116321222521101001011163284121112111103114971" +
                "0232749710711198321181011141021081051201163224610010132809711010311497109109101329711046",
                Text.toDecimal("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))

    }

    @Test
    fun toHex() {

        Assert.assertEquals("4120717569636b206d6f76656d656e74206f662074686520656e656d792077696c6c206a656f70617264697a65207369782067756e626f6174732e",
                Text.toHex("A quick movement of the enemy will jeopardize six gunboats."))

        Assert.assertEquals("536368776569df67657175e46c74207afc6e646574205479706f67726166204a616b6f6220766572666c69787420f664652050616e6772616d6d6520616e2e",
                Text.toHex("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }
}