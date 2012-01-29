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
 * Set an engine-specific setting in a key/value format.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SPEECH SET")
public class SpeechSet implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -1479993108651095058L;
    
    /**
     * Property name(key).
     */
    @Parameter(optional = false)
    private String name;
    
    /**
     * Property value.
     */
    @Parameter(position = 1, optional = false)
    private String value;

    /**
     * Create a new SpeechSet object.
     * 
     * @param name property name.
     * @param value propert value.
     */
    public SpeechSet(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Get property name.
     * 
     * @return property name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set property name.
     * 
     * @param name property name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get property value.
     * 
     * @return property value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set property value.
     * 
     * @param value property value.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
