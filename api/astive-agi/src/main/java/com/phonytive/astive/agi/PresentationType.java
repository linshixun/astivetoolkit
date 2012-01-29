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
package com.phonytive.astive.agi;


/**
 * Enum that map the presentation type for the callerId (@link AgiRequest).
 *
 * @since 1.0.0
 */
public enum PresentationType {ALLOWED(0, "allowed", "allowed"),
    ALLOWED_NOT_SCREENED(1, "allowed_not_screened", "allowed not screened"),
    ALLOWED_PASSED_SCREEN(2, "allowed_passed_screen", "allowed passed screen"),
    ALLOWED_FAILED_SCREEN(3, "allowed_failed_screen", "allowed failed screen"),
    PROHIB_NOT_SCREENED(4, "prohib_not_screened", "prohib not screened"),
    PROHIB_PASSED_SCREEN(5, "prohib_passed_screen", "prohib passed screen"),
    PROHIB_FAILED_SCREEN(6, "prohib_failed_screen", "prohib failed screen"),
    PROHIB(7, "prohib", "prohib"),
    UNAVAILABLE(8, "unavailable", "unavailable");

    /**
     * PresentationType value.
     */
    private int value;

    /**
     * PresentationType name
     */
    private String name;

    /**
     * PresentationType description.
     */
    private String literal;

    /**
     * Create a new PresentationType object with value, name an description. 
     * This class is an enum, therefore can't be instantiated directly.
     */
    private PresentationType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }
    
    public static PresentationType get(int value){
        return null;
    }

    public static PresentationType get(String name) {
        return null;
    }
    
    public String getLiteral() {
        return literal;
    }

    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
}
