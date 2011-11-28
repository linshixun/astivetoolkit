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
package com.phonytive.astive.server;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.monitor.ConnectionMonitor;
import com.phonytive.astive.server.monitor.SimpleConnectionMonitor;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see Service
 * @see AbstractAstiveServer
 * @see AstiveServer
 */
public class SimpleAstiveServer extends AbstractAstiveServer {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(SimpleAstiveServer.class);
    private Astivlet astivlet;
    private int port;
    private ExecutorService executorService;

    public SimpleAstiveServer(Astivlet astivlet)
        throws SystemException, IOException {
        super();
        this.port = DEFAULT_PORT;
        this.astivlet = astivlet;
    }

    public SimpleAstiveServer(Astivlet astivlet, int port)
        throws SystemException, IOException {
        super(port);
        this.port = port;
        this.astivlet = astivlet;
    }

    @Override
    public void start() throws SystemException {
        super.start();
        executorService = Executors.newSingleThreadExecutor();
        launchConnectionMonitor();
    }

    @Override
    public void stop() throws SystemException {
        executorService.shutdown();
        super.stop();
    }

    @Override
    protected void launchConnectionMonitor() {
        SimpleConnectionMonitor monitor = new SimpleConnectionMonitor(this,
                astivlet);
        monitor.run();

        //executorService.execute(monitor);
    }

    public Astivlet getAstivlet() {
        return astivlet;
    }

    public void setAstivlet(Astivlet astivlet) {
        this.astivlet = astivlet;
    }

    public int getPort() {
        return port;
    }
}
