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
package com.phonytive.astive.util;

import java.text.Format;
import java.text.MessageFormat;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $id$
 */
public class AppLocale {
    // A usual resource bundle class
    private static final ResourceBundle messages = ResourceBundle.getBundle(
            "Messages");
    private static MessageFormat messageForm = new MessageFormat("");
    private static Format[] formats = { null };

    public static String getI18n(String key) {
        try {
            return messages.getString(key);
        } catch (MissingResourceException ex) {
            return key;
        }
    }

    public static String getI18n(String key, Object[] args) {
        try {
            String msgPatter = messages.getString(key);
            messageForm.setFormats(formats);
            messageForm.applyPattern(msgPatter);

            String result = messageForm.format(args);

            return result;
        } catch (MissingResourceException ex) {
            return key;
        }
    }
}
