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
package com.phonytive.astive.agi;


/**
 * Enum that handle the status of a <code>channel</code>.
 *
 * @since 1.0.0
 */
public enum ChannelType {
    /**
     * Channel type is unknown.
     */
    UNKNOWN("UNKNOWN"),
    /**
     * Channel type ZAP.
     */
    ZAP("ZAP"),
    /**
     * Channel type SIP
     */
    SIP("SIP"),
    /**
     * Channel type IAX
     */
    IAX("IAX"),
    /**
     * Channel type H.323
     */
    H323("H.323");
    /**
     * Type of channel as string.
     */
    private String name;

    /**
     * Create a new ChannelStatus object with status code as parameter. This
     * class is an enum, therefore can't be instantiated directly.
     */
    private ChannelType(String name) {
        this.name = name;
    }

    /**
     * Return enum for channel status code.
     *
     * @param code channel status code
     * @return ChannelStatus enum
     */
    public static ChannelType get(String name) {
        for (ChannelType ct : ChannelType.values()) {
            if (ct.toString().equalsIgnoreCase(name)) {
                return ChannelType.valueOf(name);
            }
        }

        return ChannelType.UNKNOWN;
    }

    /**
     * Get the name for this channel type.
     *
     * @return the name for this channel type.
     */
    public String getName() {
        return name;
    }
}
