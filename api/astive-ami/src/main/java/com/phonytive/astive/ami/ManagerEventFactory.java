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
package com.phonytive.astive.ami;

import com.phonytive.astive.ami.event.EventType;
import com.phonytive.astive.ami.event.ManagerEvent;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class ManagerEventFactory {
    private static final Logger logger = Logger.getLogger(MessageHandler.class);
    private static ManagerEventFactory INSTANCE = new ManagerEventFactory();

    private ManagerEventFactory() {
    }

    public static ManagerEventFactory getInstance() {
        return INSTANCE;
    }

    public ManagerEvent getEvent(Object source, Message msg) {
        logger.warn(AppLocale.getI18n("unknownEvent",
                new Object[] { msg.getMessageLines().get(0), msg.toString() }));

        return new ManagerEvent(source, EventType.UNKNOWN, msg.getParams());
    }
    
    // TODO: Implemente a "create" method for each event type
 
}
