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
 * Waits up to <code>timeout</code> milliseconds for channel to receive a DTMF 
 * digit. 
 * 
 * <p>Returns -1 on channel failure, 0 if no digit is received in the timeout, 
 * or the numerical value of the ASCII of the digit if one is received. 
 * 
 * <p>Use -1 for the <code>timeout</code> value if you desire the call to block 
 * indefinitely.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "WAIT FOR DIGIT")
public class WaitForDigit implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 1274177415080200306L;
    
    /**
     * Timeout in milliseconds. 
     */
    @Parameter(optional = false)
    private Integer timeout;

    /**
     * Create a new WaitForDigit object.
     */
    public WaitForDigit() {
    }    
    
    /**
     * Create a new WaitForDigit object with timeout.
     * 
     * @param timeout time in milliseconds to wait for a digit.
     */
    public WaitForDigit(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * Get time to wait for a digit.
     * 
     * @return time(in milliseconds) to wait for a digit.
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Set time to wait for a digit or null to wait forever.
     * 
     * @param timeout time(in milliseconds) to wait for a digit.
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
