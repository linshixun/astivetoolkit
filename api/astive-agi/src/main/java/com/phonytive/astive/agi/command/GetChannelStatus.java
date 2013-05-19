/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Returns the status of the specified channel. If no channel name is given
 * then returns the status of the current channel.
 * Return values:
 * <ul>
 * <li>0 - Channel is down and available.
 * <li>1 - Channel is down, but reserved.
 * <li>2 - Channel is off hook.
 * <li>3 - Digits (or equivalent) have been dialed.
 * <li>4 - Line is ringing.
 * <li>5 - Remote end is ringing.
 * <li>6 - Line is up.
 * <li>7 - Line is busy.
 * </ul>
 *
 * @since 1.0.0
 * @see GetChannelStatus
 */
@AgiCommand(command = "CHANNEL STATUS")
public class GetChannelStatus implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -820579790841625915L;

    /**
     * Channel name, or null for current channel.
     */
    @Parameter
    private String channel;

    /**
     * Create a new GetChannelStatus object.
     */
    public GetChannelStatus() {
    }

    /**
     * Create a new GetChannelStatus object with channel name as parameter.
     *
     * @param channel
     */
    public GetChannelStatus(String channel) {
        this.channel = channel;
    }

    /**
     * Get channel name or null for current channel.
     *
     * @return channel name.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Set channel name.
     *
     * @param channel channel name, or null for current channel.
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }
}
