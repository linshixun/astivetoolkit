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
 * Deactivates the specified grammar on the speech object.
 * 
 * @since 1.0.0
 */
@AgiCommand(command = "SPEECH DEACTIVATE GRAMMAR")
public class SpeechDeactivateGrammar implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 0x5f9ff66f11de4626L;
    
    /**
     * Grammar name.
     */
    @Parameter
    private String name;

    /**
     * Create a new SpeechDeactivateGrammar object.
     * 
     * @param name grammar name.
     */
    public SpeechDeactivateGrammar(String name) {
        this.name = name;
    }

    /**
     * Get grammar name.
     * 
     * @return grammar name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set grammar name.
     * 
     * @param name grammar name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
