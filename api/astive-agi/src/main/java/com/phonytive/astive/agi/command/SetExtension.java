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
 * Changes the extension for continuation upon exiting the application.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET EXTENSION")
public class SetExtension implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -7607143769226787251L;
    
    /**
     * New extension.
     */    
    @Parameter(optional = false)
    private String extension;

    /**
     * Create a new SetExtension object.
     * 
     * @param extension new extension for channel.
     */
    public SetExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get extension.
     * 
     * @return extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Set new extension.
     * 
     * @param extension new extension.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
}
