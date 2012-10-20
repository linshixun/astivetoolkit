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
package com.phonytive.astive.agi;


/**
 * Enum that map the ton type for an incoming call.
 *
 * @since 1.0.0
 */
public enum TonType {UNKNOWN(0x0, "Unknown", "Unknown"),
    INTERNATIONAL(0x1, "International", "International"),
    NATIONAL(0x2, "National", "National"),
    NETWORK_SPECIFIC(0x3, "NetworkSpecific", "Network specific"),
    SUBSCRIBER_NUMBER(0x4, "SubscriberNumber", "Subscriber number"),
    ALPHA_NUMERIC(0x5, "AlphaNumberic", "Alpha numeric"),
    ABBREVIATED(0x6, "Abbreviated", "Abbreviated");    

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
    private TonType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }
    
    public static TonType get(int value){
        return null;
    }
        
    public static TonType getByName(String name) {
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
