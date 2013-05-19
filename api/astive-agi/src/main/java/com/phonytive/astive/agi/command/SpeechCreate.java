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
 * Create a speech object to be used by the other Speech AGI commands.
 *
 * @since 1.0.0
 * @see SpeechDestroy
 */
@AgiCommand(command = "SPEECH CREATE")
public class SpeechCreate implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -8343359487319664122L;
    
    /**
     * The name of the speech engine to use for subsequent Speech AGI commands.
     */
    @Parameter(optional = false)
    private String engine;

    /**
     * Create a new SpeechCreate object.
     * 
     * @param engine the name of the speech engine to use for subsequent 
     * Speech AGI commands.
     */
    public SpeechCreate(String engine) {
        this.engine = engine;
    }

    /**
     * Get engine name.
     * 
     * @return engine name.
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Set engine name.
     * 
     * @param engine engine name.
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }
}
