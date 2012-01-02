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
package com.phonytive.astive.astivlet;

import com.phonytive.astive.agi.AgiRequest;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import java.net.InetAddress;
import java.util.ArrayList;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see AstivletResponse
 */
public class AstivletRequest extends AgiRequest {
    private InetAddress localAddress;
    private int localPort;
    private InetAddress remoteAddress;
    private int remotePort;

    public AstivletRequest(ArrayList<String> lines, FastAgiConnection client) {
        super(lines);
        localAddress = client.getSocket().getLocalAddress();
        remoteAddress = client.getSocket().getLocalAddress();
        localPort = client.getSocket().getLocalPort();
        remotePort = client.getSocket().getPort();
    }

    public InetAddress getLocalAddress() {
        return localAddress;
    }

    public int getLocalPort() {
        return localPort;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public int getRemotePort() {
        return remotePort;
    }
}
