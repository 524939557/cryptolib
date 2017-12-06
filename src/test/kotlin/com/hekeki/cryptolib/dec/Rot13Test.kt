/**
 * Rot13Test - Class to test rot13 encoding and decoding.
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

class Rot13Test {

    @Test
    fun encode() {
        assertEquals("", Rot13.encode(""))
        assertEquals("Jul qvq gur puvpxra pebff gur ebnq? To get to the other side!", Rot13.encode("Why did the chicken cross the road? Gb trg gb gur bgure fvqr!"))
        assertEquals("Fpujrvßtrdhäyg müaqrg Glcbtens Wnxbo iresyvkg öqr Cnatenzzr na.", Rot13.encode("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an."))
    }

    @Test
    fun decode() {
        assertEquals("", Rot13.encode(""))
        assertEquals("The Quick Brown Fox Jumps Over The Lazy Dog", Rot13.decode("Gur Dhvpx Oebja Sbk Whzcf Bire Gur Ynml Qbt"))
        assertEquals("Schweißgequält zündet Typograf Jakob verflixt öde Pangramme an.", Rot13.decode("Fpujrvßtrdhäyg müaqrg Glcbtens Wnxbo iresyvkg öqr Cnatenzzr na."))
    }
}