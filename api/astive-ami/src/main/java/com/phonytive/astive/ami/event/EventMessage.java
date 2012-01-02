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
package com.phonytive.astive.ami.event;

import com.phonytive.astive.ami.Message;
import com.phonytive.astive.ami.MessageType;
import com.phonytive.astive.ami.Privilege;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class EventMessage extends Message {
    private EventType event;
    private ArrayList<Privilege> privilege;

    public EventMessage(EventType event) {
        super(MessageType.EVENT, event);
        this.event = event;
    }

    public EventMessage(EventType event, HashMap parameters) {
        super(MessageType.EVENT, event, parameters);
        this.event = event;
    }

    public EventType getEventType() {
        return event;
    }

    public ArrayList<Privilege> getPrivilege() {
        String p = (String) getParams().get("Privilege");
        String[] parray = p.split(",");
        privilege = new ArrayList();

        for (int i = 0; i < parray.length; i++) {
            privilege.add(Privilege.valueOf(parray[i].toUpperCase()));
        }

        return privilege;
    }
}
