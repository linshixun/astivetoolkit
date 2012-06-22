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
 * Sets the context for continuation upon exiting the application.
 * 
 * @since 1.0.0
 */
@AgiCommand(command = "SET CONTEXT")
public class SetContext implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -518908570483537151L;
    
    /**
     * Desired context for channel.
     */
    @Parameter(optional = false)
    private String context;

    /**
     * Create a new SetContext object.
     * 
     * @param context channel context
     */
    public SetContext(String context) {
        this.context = context;
    }

    /**
     * Get context.
     * 
     * @return context.
     */
    public String getContext() {
        return context;
    }

    /**
     * Set desired context for channel.
     * 
     * @param context desired context for channel.
     */
    public void setContext(String context) {
        this.context = context;
    }
}
