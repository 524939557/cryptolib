/**
 * Base64Test - Class to test base64 encoding and decoding
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

import org.junit.Test

import org.junit.Assert.*

class Base64Test {

    @Test
    fun encodeRFC4648Examples() {
        assertEquals("", Base64.encode(""))
        assertEquals("Zg==", Base64.encode("f"))
        assertEquals("Zm8=", Base64.encode("fo"))
        assertEquals("Zm9v", Base64.encode("foo"))
        assertEquals("Zm9vYg==", Base64.encode("foob"))
        assertEquals("Zm9vYmE=", Base64.encode("fooba"))
        assertEquals("Zm9vYmFy", Base64.encode("foobar"))
    }

    @Test
    fun decodeRFC4648Examples() {
        assertEquals("", Base64.decode(""))
        assertEquals("f", Base64.decode("Zg=="))
        assertEquals("fo", Base64.decode("Zm8="))
        assertEquals("foo", Base64.decode("Zm9v"))
        assertEquals("foob", Base64.decode("Zm9vYg=="))
        assertEquals("fooba", Base64.decode("Zm9vYmE="))
        assertEquals("foobar", Base64.decode("Zm9vYmFy"))
    }

    @Test
    fun encodeFunctionCalls() {
        assertEquals("YmFzZTY0", Base64.encode("base64"))
        assertEquals("YmFzZTY0", Base64.encode("base64".toByteArray()))
        assertEquals("YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFz\r\n" + "ZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0",
                Base64.encode("base64base64base64base64base64base64base64base64base64base64base64base64base64base64", true))
        assertEquals("YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFz\r\n" + "ZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0",
                Base64.encode("base64base64base64base64base64base64base64base64base64base64base64base64base64base64".toByteArray(), true))
        assertEquals("YmFzZTY0", Base64.encode("base64", Charsets.UTF_8))
        assertEquals("w6TDvMO2YmFzZTY0", Base64.encode("äüöbase64".toByteArray(Charsets.UTF_8), Charsets.UTF_8))
        assertEquals("w6TDvMO2YmFzZTY0", Base64.encode("äüöbase64".toByteArray(Charsets.UTF_8), Charsets.ISO_8859_1))
        assertNotEquals("w6TDvMO2YmFzZTY0", Base64.encode("äüöbase64".toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8))
        assertEquals("YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFz\r\n" + "ZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0",
                Base64.encode("base64base64base64base64base64base64base64base64base64base64base64base64base64base64", true, Charsets.UTF_8))
        assertEquals("YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFz\r\n" + "ZTY0YmFzZTY0YmFzZTY0YmFzZTY0YmFzZTY0",
                Base64.encode("base64base64base64base64base64base64base64base64base64base64base64base64base64base64".toByteArray(), true, Charsets.UTF_8))

        assertEquals("base64", Base64.decode("YmFzZTY0"))
        assertEquals("base64", Base64.decode("YmFzZTY0".toByteArray()))
        assertEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0", Charsets.UTF_8))
        assertEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0".toByteArray(), Charsets.UTF_8))
        assertNotEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0", Charsets.ISO_8859_1))
        assertNotEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0".toByteArray(), Charsets.ISO_8859_1))
    }

    @Test
    fun decodeFunctionCalls() {
        assertEquals("base64", Base64.decode("YmFzZTY0"))
        assertEquals("base64", Base64.decode("YmFzZTY0".toByteArray()))
        assertEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0", Charsets.UTF_8))
        assertEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0".toByteArray(), Charsets.UTF_8))
        assertNotEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0", Charsets.ISO_8859_1))
        assertNotEquals("äüöbase64", Base64.decode("w6TDvMO2YmFzZTY0".toByteArray(), Charsets.ISO_8859_1))
    }

    @Test
    fun encodePangrams() {
        assertEquals("QSBxdWljayBtb3ZlbWVudCBvZiB0aGUgZW5lbXkgd2lsbCBqZW9wYXJkaXplIHNpeCBndW5ib2F0cy4=",
                Base64.encode("A quick movement of the enemy will jeopardize six gunboats.".toByteArray(Charsets.UTF_8), false))
        assertEquals("U2Nod2Vpw59nZXF1w6RsdCB6w7xuZGV0IFR5cG9ncmFmIEpha29iIHZlcmZsaXh0IMO2ZGUgUGFuZ3JhbW1lIGFuLg==",
                Base64.encode("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an.".toByteArray()))
    }

    @Test
    fun decodePangrams() {
        assertEquals("A quick movement of the enemy will jeopardize six gunboats.",
                Base64.decode("QSBxdWljayBtb3ZlbWVudCBvZiB0aGUgZW5lbXkgd2lsbCBqZW9wYXJkaXplIHNpeCBndW5ib2F0cy4=".toByteArray()))
        assertEquals("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an.",
                Base64.decode("U2Nod2Vpw59nZXF1w6RsdCB6w7xuZGV0IFR5cG9ncmFmIEpha29iIHZlcmZsaXh0IMO2ZGUgUGFuZ3JhbW1lIGFuLg==".toByteArray()))
    }
}