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
 * Sets a variable to the current channel.
 * 
 * @since 1.0.0
 */
@AgiCommand(command = "SET VARIABLE")
public class SetVariable implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -6634799740139058533L;
    
    /**
     * Variable name.
     */
    @Parameter(optional = false)
    private String variable;
    
    /**
     * Variable value.
     */
    @Parameter(position = 1, optional = false)
    private String value;

    /**
     * Create a new SetVariable object with key/value.
     * 
     * @param variable variable name.
     * @param value variable value.
     */
    public SetVariable(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    /**
     * Get variable name.
     * 
     * @return variable name.
     */
    public String getVariable() {
        return variable;
    }

    /**
     * Set variable name.
     * 
     * @param variable variable name.
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }    
    
    /**
     * Get variable value.
     * 
     * @return variable value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set variable value.
     * 
     * @param value variable value.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
