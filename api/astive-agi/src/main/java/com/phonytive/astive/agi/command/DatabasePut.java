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
 * Adds or updates an entry in the Asterisk database for a given <code>family></code>,
 * <code>key</code>, <code>value</code>
 *
 * <p>Returns 1 if successful, 0 otherwise.
 *
 * @since 1.0.0
 * @see DatabaseDel
 */
@AgiCommand(command = "DATABASE PUT")
public class DatabasePut implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -8536786322579439275L;

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
     * Family element value.
     */
    @Parameter(position = 2, optional = false)
    private String value;

    /**
     * Create a new DatabasePut object with family, key and value as parameters.
     *
     * @param family database family.
     * @param key family element.
     * @param value family element value.
     */
    public DatabasePut(String family, String key, String value) {
        this.family = family;
        this.key = key;
        this.value = value;
    }

    /**
     * Database family.
     *
     * @return database family.
     */
    public String getFamily() {
        return family;
    }

    /**
     * Set database family.
     *
     * @param family database family.
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
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get family element value.
     *
     * @return family element value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set family element value.
     *
     * @param value family element value.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
