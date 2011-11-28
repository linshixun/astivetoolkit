// Astive Toolkit is a set of tools for developers on Asterisk® PBX to
// create applications in concise and easy way.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.menu.event;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $id$
 * @see Action
 * @see ActionListener
 */
public class ActionEvent {
    private Object source;
    private String digits;

    /** <p>Creates a new instance of ActionEvent</p> */
    public ActionEvent(Object source, String digits) {
        this.source = source;
        this.digits = digits;
    }

    /**
     * @return the digits
     */
    public String getDigits() {
        return digits;
    }

    /**
     * @return the source
     */
    public Object getSource() {
        return source;
    }

    /**
     * @param digits the digits to set
     */
    public void setDigits(String digits) {
        this.digits = digits;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Object source) {
        this.source = source;
    }
}
