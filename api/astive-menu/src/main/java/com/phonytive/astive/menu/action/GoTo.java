// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
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
package com.phonytive.astive.menu.action;

import com.phonytive.astive.api.agi.AgiException;
import com.phonytive.astive.api.agi.AgiResponse;
import com.phonytive.astive.menu.core.Engine;
import com.phonytive.astive.menu.core.Menu;
import com.phonytive.astive.menu.core.MenuException;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version 0.1
 * @see GoExt
 */
public class GoTo implements Action {
    private AgiResponse agiResponse;
    private Menu menu;

    /** <p>Creates a new instance of GoTo</p> */
    public GoTo(AgiResponse agiResponse, Menu menu) {
        this.agiResponse = agiResponse;
        this.menu = menu;
    }

    @Override
    public void doAction() {
        try {
            Engine e = new Engine(agiResponse);

            try {
                e.run(menu);
            } catch (AgiException ex) {
            }
        } catch (MenuException ex) {
            // Manage this exception
        }
    }
}
