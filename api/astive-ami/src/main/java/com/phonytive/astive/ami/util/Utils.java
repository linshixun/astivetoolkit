/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
 *
 * This file is part of Astive Toolkit
 *
 * Astive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Astive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Astive.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.phonytive.astive.ami.util;

import com.phonytive.astive.ami.MessageType;
import com.phonytive.astive.ami.ResponseStatus;
import com.phonytive.astive.ami.action.ActionType;
import com.phonytive.astive.ami.event.EventType;
import java.util.ArrayList;

/**
 *
 * @since 1.0.0
 */
public class Utils {

    /**
     * DOCUMENT ME!
     *
     * @param actionTypeStr DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static ActionType getActionType(String actionTypeStr) {
        StringBuilder b = new StringBuilder();
        String[] s = splitOnCapitals(actionTypeStr);

        for (int i = 0x0; i < s.length; i++) {
            b.append(s[i]);

            if (i < (s.length - 0x1)) {
                b.append("_");
            }
        }

        return ActionType.valueOf(b.toString().toUpperCase());
    }

    /**
     * DOCUMENT ME!
     *
     * @param actionType DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getActionType(ActionType actionType) {
        String s = joinCapitals(actionType.toString().split("_"));

        return s;
    }

    /**
     * DOCUMENT ME!
     *
     * @param eventTypeStr DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static EventType getEventType(String eventTypeStr) {
        StringBuilder b = new StringBuilder();
        String[] s = splitOnCapitals(eventTypeStr);

        for (int i = 0x0; i < s.length; i++) {
            b.append(s[i]);

            if (i < (s.length - 0x1)) {
                b.append("_");
            }
        }

        return EventType.valueOf(b.toString().toUpperCase());
    }

    /**
     * DOCUMENT ME!
     *
     * @param eventType DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getEventType(EventType eventType) {
        String s = joinCapitals(eventType.toString().split("_"));

        return s;
    }

    /**
     * DOCUMENT ME!
     *
     * @param messageTypeStr DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static MessageType getMessageType(String messageTypeStr) {
        return MessageType.valueOf(messageTypeStr.toUpperCase());
    }

    /**
     * DOCUMENT ME!
     *
     * @param messageType DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getMessageType(MessageType messageType) {
        return capitalizeFirstLetters(messageType.toString().replace("_", ""));
    }

    /**
     * DOCUMENT ME!
     *
     * @param actionTypeStr DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static ResponseStatus getResponseStatus(String actionTypeStr) {
        return ResponseStatus.valueOf(actionTypeStr.toUpperCase());
    }

    /**
     * DOCUMENT ME!
     *
     * @param responseStatus DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getResponseStatus(ResponseStatus responseStatus) {
        return capitalizeFirstLetters(responseStatus.toString().replace("_", "").toLowerCase());
    }

    // TODO: Move this to a most general util
    private static String capitalizeFirstLetters(String s) {
        s = s.toLowerCase();

        for (int i = 0x0; i < s.length(); i++) {
            if (i == 0x0) {
                // Capitalize the first letter of the string.
                s = String.format("%s%s", Character.toUpperCase(s.charAt(0x0)), s.substring(0x1));
            }
        }

        return s;
    }

    /**
     * DOCUMENT ME!
     *
     * @param str DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String joinCapitals(String[] str) {
        StringBuilder b = new StringBuilder();

        for (int i = 0x0; i < str.length; i++) {
            b.append(capitalizeFirstLetters(str[i]));
        }

        return b.toString();
    }

    /**
     * DOCUMENT ME!
     *
     * @param str DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String[] splitOnCapitals(String str) {
        ArrayList<String> array = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0x0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                String line = builder.toString().trim();

                if (line.length() > 0x0) {
                    array.add(line);
                }

                builder = new StringBuilder();
            }

            builder.append(str.charAt(i));
        }

        array.add(builder.toString().trim()); // get the last little bit too

        return array.toArray(new String[0x0]);
    }

    private Utils() {
    }
}
