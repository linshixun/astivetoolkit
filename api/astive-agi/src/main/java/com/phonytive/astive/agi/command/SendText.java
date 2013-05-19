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
 * Sends the given text on a <code>channel</code>. Most channels do not support 
 * the transmission of text. 
 * 
 * <p>Returns 0 if text is sent, or if the channel does not support text 
 * transmission. Returns -1 only on error/hangup.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SEND TEXT")
public class SendText implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -323324435661044014L;
    
    /**
     * Text to send to channel.
     */
    @Parameter(optional = false)
    private String text;

    /**
     * Create a new SendText object.
     * 
     * @param text text to send.
     */
    public SendText(String text) {
        this.text = text;
    }

    /**
     * Get text to send.
     * 
     * @return text to send.
     */
    public String getText() {
        return text;
    }

    /**
     * Set text to send.
     * 
     * @param text text to send.
     */
    public void setText(String text) {
        this.text = text;
    }
}
