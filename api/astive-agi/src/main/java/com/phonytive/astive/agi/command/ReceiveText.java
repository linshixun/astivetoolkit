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
 * Receives a string of text on a <code>channel</code>. Most channels  do not 
 * support the reception of text. 
 * 
 * <p>Returns -1 for failure or 1 for success, and the string in parenthesis.
 * 
 * @since 1.0.0
 */
@AgiCommand(command = "RECEIVE TEXT")
public class ReceiveText implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 3207689243657325448L;
    /**
     * Time in milliseconds to wait for text.
     */
    @Parameter
    private Integer timeout;

    /**
     * Create a new ReceiveText object.
     */    
    public ReceiveText() {
        timeout = 0;
    }

    /**
     * Create a new ReceiveText object with timeout.
     * 
     * @param timeout time in milliseconds to wait for text.
     */    
    public ReceiveText(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * Get timeout in milliseconds to wait for text.
     * 
     * @return timeout in milliseconds.
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Set Timeout in milliseconds to wait for text.
     * 
     * @param timeout timeout in milliseconds.
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
