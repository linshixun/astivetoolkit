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
package com.phonytive.astive.server.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class AdminDaemonClient extends Socket {
    private PrintWriter writer;
    private BufferedReader reader;

    public AdminDaemonClient(InetAddress addr, int port)
        throws IOException {
        super(addr, port);
        reader = new BufferedReader(new InputStreamReader(getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(getOutputStream()));
    }

    private BufferedReader getReader() throws IOException {
        return reader;
    }

    private PrintWriter getWriter() throws IOException {
        return writer;
    }

    public void stop() throws IOException {
        send(AdminCommand.stop, null);
    }

    public void deploy(String app) throws IOException {
        send(AdminCommand.deploy, app);
    }

    public void undeploy(String app) throws IOException {
        send(AdminCommand.undeploy, app);
    }

    private void send(AdminCommand cmd, String arg) throws IOException {
        getWriter().println(cmd.toString());

        if ((arg != null) && !arg.equals("")) {
            getWriter().println(arg);
        }

        getWriter().flush();
    }
}
