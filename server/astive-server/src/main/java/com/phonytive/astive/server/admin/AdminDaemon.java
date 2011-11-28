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

import com.phonytive.astive.server.AbstractAstiveServer;
import com.phonytive.astive.server.App;
import com.phonytive.astive.server.AstiveException;
import com.phonytive.astive.server.SystemException;
import com.phonytive.astive.server.appmanager.ApplicationManager;
import com.phonytive.astive.server.appmanager.ApplicationManagerImpl;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.logging.Level;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see ConnectionMonitor
 */
public final class AdminDaemon extends ServerSocket
    implements ApplicationManager, Runnable {
    private static final Logger logger = Logger.getLogger(AdminDaemon.class);
    private InetAddress bindAddr;
    private int port;
    private int backlog;
    private AbstractAstiveServer server;

    public AdminDaemon(int port, int backlog, InetAddress bindAddr,
        AbstractAstiveServer server) throws IOException {
        super();
        this.port = port;
        this.backlog = backlog;
        this.bindAddr = bindAddr;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
            bind(inet, backlog);

            while (true) {
                Socket client = accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(
                            client.getInputStream()));
                String commandStr = reader.readLine();

                AdminCommand command = AdminCommand.valueOf(commandStr);
                String arg = null;

                if (command.equals(AdminCommand.deploy) ||
                        command.equals(AdminCommand.undeploy)) {
                    arg = reader.readLine();
                }

                if (command.equals(AdminCommand.deploy)) {
                    deploy(arg);

                    continue;
                }

                if (command.equals(AdminCommand.undeploy)) {
                    undeploy(arg);

                    continue;
                }

                if (command.equals(AdminCommand.stop)) {
                    try {
                        server.stop();
                    } catch (SystemException ex) {
                        // XXX:
                    }

                    break;
                }

                client.close();
            }
        } catch (IOException ex) {
            logger.error(AppLocale.getI18n("unableToPerformIOWithAdminDaemon",
                    new Object[] { ex.getMessage() }));
        } catch (AstiveException ex) {
            //
        }
    }

    @Override
    public void deploy(String app) throws AstiveException {
        ApplicationManagerImpl.getInstance().deploy(app);
    }

    @Override
    public void undeploy(String app) throws AstiveException {
        ApplicationManagerImpl.getInstance().undeploy(app);
    }

    @Override
    public ArrayList apps() {
        return ApplicationManagerImpl.getInstance().apps();
    }

    @Override
    public boolean appExist(String app) {
        return ApplicationManagerImpl.getInstance().appExist(app);
    }

    @Override
    public App getApp(String app) throws AstiveException {
        return ApplicationManagerImpl.getInstance().getApp(app);
    }
}
