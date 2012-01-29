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
 * Retrieves an entry in the Asterisk database for a given <code>family</code>
 * <code>and key</code>
 * <p>Returns 0 if key is not set. Returns 1 if key is set and returns
 * the variable in parenthesis.
 *
 * Eg.: return code: 200 result=1 (testvariable)
 *
 * @since 1.0.0
 * @see DatabasePut
 */
@AgiCommand(command = "DATABASE GET")
public class DatabaseGet implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 5937402997584970009L;

    /**
     * Database family.
     */
    @Parameter(optional = false)
    private String family;

    /**
     * Family element.
     */
    @Parameter(position = 1, optional = false)
    private String key;

    /**
     * Create a new DatabaseGet object with family and key as parameter.
     *
     * @param family database family.
     * @param key family element.
     */
    public DatabaseGet(String family, String key) {
        this.family = family;
        this.key = key;
    }

    /**
     * Get database family.
     *
     * @return database family.
     */
    public String getFamily() {
        return family;
    }

    /**
     * Set database family.
     *
     * @param family database family
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * Get family element.
     *
     * @return family element.
     */
    public String getKey() {
        return key;
    }

    /**
     * Set family element.
     *
     * @param key family element.
     */
    public void setKey(String key) {
        this.key = key;
    }
}
