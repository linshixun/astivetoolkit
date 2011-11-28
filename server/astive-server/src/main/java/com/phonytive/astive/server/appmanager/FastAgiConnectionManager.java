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
package com.phonytive.astive.server.appmanager;

import com.phonytive.astive.api.agi.Connection;
import com.phonytive.astive.api.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.ArrayList;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see ConnectionManager
 */
public class FastAgiConnectionManager implements ConnectionManager {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(FastAgiConnectionManager.class);
    private ArrayList<Connection> conns;

    public FastAgiConnectionManager() {
        conns = new ArrayList<Connection>();
    }

    @Override
    public ArrayList<Connection> connections() {
        return conns;
    }

    @Override
    public void removeAll() throws IOException {
        for (Connection conn : conns) {
            if (!conn.isClosed()) {
                ((FastAgiConnection) conn).close();
            }
        }

        conns.clear();
    }

    @Override
    public void add(Connection conn) {
        conns.add(conn);
    }

    @Override
    public void remove(Connection conn) throws IOException {
        if (!conn.isClosed()) {
            ((FastAgiConnection) conn).close();
        }

        conns.remove(conn);
    }
}
