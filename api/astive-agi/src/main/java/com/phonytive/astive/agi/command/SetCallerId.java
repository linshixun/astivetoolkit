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
 * Changes the <code>callerid</code> of the current <code>channel.</code>
 * 
 * @since 1.0.0
 */
@AgiCommand(command = "SET CALLERID")
public class SetCallerId implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -920453570097230648L;
    
    /**
     * Caller Id.
     */
    @Parameter(optional = false)
    private String callerId;

    /**
     * Create a new SetCallerId object to change the caller id for the 
     * current channel.
     * 
     * @param callerId caller id for the current channel.
     */
    public SetCallerId(String callerId) {
        this.callerId = callerId;
    }

    /**
     * Get caller id.
     * 
     * @return caller id.
     */
    public String getCallerId() {
        return callerId;
    }

    /**
     * Set caller id for the current channel.
     * 
     * @param callerId caller id.
     */
    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }
}
