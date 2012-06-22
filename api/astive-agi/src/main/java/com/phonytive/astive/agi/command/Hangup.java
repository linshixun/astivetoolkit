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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Hangs up the specified channel. If no channel name is given, hangs up the
 * current <code>channel</code>.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "HANGUP")
public class Hangup implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -7294601691881839635L;

    /**
     * Channel name.
     */
    @Parameter(optional = false)
    private String channel;

    /**
     * Create a new Hangup object.
     */
    public Hangup() {
    }

    /**
     * Create a new Hangup object with channel.
     * 
     * @param channel channel name to hangup or null for current channel.
     */
    public Hangup(String channel) {
        this.channel = channel;
    }

    /**
     * Channel name or null for current channel.
     *
     * @return channel name.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Set channel name. Null for current channel.
     *
     * @param channel channel name.
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }
}
