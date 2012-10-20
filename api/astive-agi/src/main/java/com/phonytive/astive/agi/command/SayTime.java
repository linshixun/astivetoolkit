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
import com.phonytive.astive.agi.annotation.ParamConverter;
import com.phonytive.astive.agi.annotation.Parameter;
import java.io.Serializable;
import java.util.Date;


/**
 * Say a given time, returning early if any of the given DTMF digits are 
 * received on the <code>channel</code>
 * 
 * <p>Returns 0 if playback completes without a digit being pressed, or the 
 * ASCII numerical value of the digit if one was pressed or -1 on error/hangup.
 *  
 * @since 1.0.0
 */
@AgiCommand(command = "SAY TIME")
public class SayTime implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 0x9ac51056f87cfc28L;
    
    /**
     * Time to say.
     */
    @ParamConverter
    @Parameter(optional = false)
    private Date date;
    
    /**
     * Can be use to the interrupt the audio on a channel.
     */
    @Parameter(position = 0x1, optional = false)
    private String escapeDigits;

    /**
     * Create a new SayTime object with the time to say.
     *
     * @param date time to say.
     */    
    public SayTime(Date date) {
        this.date = date;
        this.escapeDigits = "";
    }

    /**
     * Create a new SayTime object with the time to say and escape digits.
     *
     * @param date datetime to say.
     * @param escapeDigits escape digits.
     */    
    public SayTime(Date date, String escapeDigits) {
        this.date = date;
        this.escapeDigits = escapeDigits;
    }

    /**
     * Get time to say.
     * 
     * @return time to say.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set date to say.
     * 
     * @param date time to say.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the digits used to interrupt the audio.
     *
     * @return digits used to interrupt the audio.
     */
    public String getEscapeDigits() {
        return escapeDigits;
    }

    /**
     * Set the digits to be use to interrupt the audio.
     *
     * @param escapeDigits digits to be use to interrupt the audio.
     */
    public void setEscapeDigits(String escapeDigits) {
        this.escapeDigits = escapeDigits;
    }
}
