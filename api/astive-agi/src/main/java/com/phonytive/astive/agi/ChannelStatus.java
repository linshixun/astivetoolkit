/*
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
public enum ChannelStatus {
    /**
     * Channel is in an unknown status.
     */
    UNKNOWN_STATUS(-1),
    /**
     * Channel is down and available.
     */
    CHANNEL_IS_DOWN_AND_AVAILABLE(0),
    /**
     * Channel is down but reserved.
     */
    CHANNEL_IS_DOWN_BUT_RESERVED(1),
    /**
     * Channel is off hook.
     */
    CHANNEL_IS_OFF_HOOK(2),
    /**
     * Digits have been dialed.
     */
    DIGITS_HAVE_BEEN_DIALED(3),
    /**
     * Line is ringing.
     */
    LINE_IS_RINGING(4),
    /**
     * Remote end is ringing.
     */
    REMOTE_END_IS_RINGING(5),
    /**
     * Line is up.
     */
    LINE_IS_UP(6),
    /**
     * Line is busy
     */
    LINE_IS_BUSY(7);
    /**
     * Int value of this type.
     */
    private int code;

    /**
     * Create a new ChannelStatus object with status code as parameter. This
     * class is an enum, therefore can't be instantiated directly.
     */
    private ChannelStatus(int code) {
        this.code = code;
    }

    /**
     * Return enum for channel status code.
     *
     * @param code channel status code
     * @return ChannelStatus enum
     */
    public static ChannelStatus get(int code) {
        for (ChannelStatus cs : ChannelStatus.values()) {
            if (cs.code == code) {
                return cs;
            }
        }

        return null;
    }

    /**
     * Get the int value of this type.
     *
     * @return value for the enum element.
     */
    public int getCode() {
        return code;
    }
}
