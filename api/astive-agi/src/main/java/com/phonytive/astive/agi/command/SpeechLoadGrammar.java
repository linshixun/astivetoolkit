/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
 * Unloads the specified grammar.
 * 
 * @since 1.0.0
 * @see SpeechUnloadGrammar
 */
@AgiCommand(command = "SPEECH LOAD GRAMMAR")
public class SpeechLoadGrammar implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 8635683833403820211L;
    /**
     * Grammar name.
     */
    @Parameter(optional = false)
    private String name;
    
    /**
     * Path to grammar.
     */
    @Parameter(position = 1, optional = false)
    private String path;

    /**
     * Create a new SpeechLoadGrammar object.
     * 
     * @param name grammar name.
     * @param path path to grammar.
     */
    public SpeechLoadGrammar(String name, String path) {
        this.name = name;
        this.path = path;
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

    /**
     * Get path to grammar.
     * 
     * @return path to grammar.
     */
    public String getPath() {
        return path;
    }

    /**
     * Set path to grammar.
     * 
     * @param path path to grammar.
     */
    public void setPath(String path) {
        this.path = path;
    }
}
