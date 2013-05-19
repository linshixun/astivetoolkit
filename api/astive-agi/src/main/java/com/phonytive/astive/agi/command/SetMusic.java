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
import com.phonytive.astive.agi.annotation.BooleanChoose;
import com.phonytive.astive.agi.annotation.ParamConverter;
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Enables/Disables the music on hold generator. If <code>class</code> is
 * not specified, then the <code>default</code> music on hold class will be used.
 * Always returns 0.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET MUSIC")
public class SetMusic implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -5450998646107584670L;

    /**
     * Set musiconhold on or off.
     */
    @Parameter(optional = false)
    @ParamConverter
    @BooleanChoose
    private Boolean on;

    /**
     * MusicOnHold class, or null for default.
     */
    @Parameter(position = 1)
    private String classStr;

    /**
     * Create a new SetMusic object.
     *
     * @param on <code>true</code> to turn music on hold on, or <code>false</code>
     * to turn music on hold off.
     */
    public SetMusic(Boolean on) {
        this.on = on;
    }

    /**
     * Create a new SetMusic object.
     * 
     * @param on <code>true</code> to turn music on hold on, or <code>false</code>
     * to turn musicOnHold off.
     * @param classStr class to use as musicOnHold
     */
    public SetMusic(Boolean on, String classStr) {
        this.on = on;
        this.classStr = classStr;
    }

    /**
     * Get class for music on hold, or null for default.
     *
     * @return class for music on hold.
     */
    public String getClassStr() {
        return classStr;
    }

    /**
     * Set class for music on hold, or null for default.
     *
     * @param classStr class for music on hold.
     */
    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }

    /**
     * Return whether music on hold is enable or disable.
     *
     * @return <code>true</code> if music on hold is on, or <code>false</code>
     * if is off.
     */
    public Boolean isOn() {
        return on;
    }

    /**
     * Enables/Disables the music on hold.
     *
     * @param on <code>true</code> to enable music on hold, or <code>false</code>
     * to disable it.
     */
    public void setOn(Boolean on) {
        this.on = on;
    }
}
