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
 * Cause the channel to automatically hangup at <code>time</code> seconds in 
 * the future. Of course it can be hungup before then as well. Setting to 0 will 
 * cause the autohangup feature to be disabled on this channel.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET AUTOHANGUP")
public class SetAutoHangup implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -5343593827052978984L;

    /**
     * Time in seconds to automatically hangup channel.
     */
    @Parameter(optional = false)
    private Integer time;

    /**
     * Create a new SetAutoHangup object with time.
     * 
     * @param time time in seconds to automatically hangup channel.
     */
    public SetAutoHangup(Integer time) {
        this.time = time;
    }

    /**
     * Get time to autohangup channel.
     * 
     * @return time in seconds to autohangup channel.
     */
    public Integer getTime() {
        return time;
    }

    /**
     * Set time to autohangup channel.
     * 
     * @param time time in seconds to autohangup channel.
     */
    public void setTime(Integer time) {
        this.time = time;
    }
}
