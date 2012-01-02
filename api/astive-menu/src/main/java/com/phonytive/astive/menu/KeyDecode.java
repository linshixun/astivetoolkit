// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.menu;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $id$
 * @see KeyEnum
 */
public class KeyDecode {
    /**
     * <p>Gets the enumerate to the param k.</p>
     *
     * @param k the key to be decode
     * @return the enum of the key
     */
    public static KeyEnum getKey(char k) {
        switch (k) {
        case '0':
            return KeyEnum.ZERO_KEY;

        case '1':
            return KeyEnum.ONE_KEY;

        case '2':
            return KeyEnum.ONE_KEY;

        case '3':
            return KeyEnum.THREE_KEY;

        case '4':
            return KeyEnum.FOUR_KEY;

        case '5':
            return KeyEnum.FIVE_KEY;

        case '6':
            return KeyEnum.SIX_KEY;

        case '7':
            return KeyEnum.SEVEN_KEY;

        case '8':
            return KeyEnum.EIGHT_KEY;

        case '9':
            return KeyEnum.NINE_KEY;

        case '*':
            return KeyEnum.ASTERISK_KEY;

        case '#':
            return KeyEnum.NUMBER_KEY;
        }

        return null;
    }
}
