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

import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.net.InetAddress;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see Service
 * @see FastAgiServerSocket
 * @see AstiveServer
 * @see SimpleAstiveServer
 */
public abstract class AbstractAstiveServer extends FastAgiServerSocket
    implements Service {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(AbstractAstiveServer.class);
    private InetAddress bindAddr;
    private int port;
    private int backlog;

    public AbstractAstiveServer() throws SystemException, IOException {
        // Using the default agi asterisk port
        super(DEFAULT_AGI_SERVER_PORT, DEFAULT_AGI_SERVER_BACKLOG,
            InetAddress.getByName(DEFAULT_AGI_SERVER_BIND_ADDR));
        this.port = DEFAULT_AGI_SERVER_PORT;
        this.backlog = DEFAULT_AGI_SERVER_BACKLOG;
    }

    public AbstractAstiveServer(int port) throws SystemException, IOException {
        super(port, DEFAULT_AGI_SERVER_BACKLOG, InetAddress.getByName(DEFAULT_AGI_SERVER_BIND_ADDR));
    }

    public AbstractAstiveServer(int port, int backlog)
        throws SystemException, IOException {
        super(port, backlog, InetAddress.getLocalHost());
    }

    public AbstractAstiveServer(int port, int backlog, InetAddress bindAddr)
        throws SystemException, IOException {
        super(port, backlog, bindAddr);
        this.bindAddr = bindAddr;
        this.port = port;
        this.backlog = backlog;
    }

    @Override
    public void start() throws SystemException {
        logger.info(AppLocale.getI18n("starting"));
        super.start();
    }

    @Override
    public void stop() throws SystemException {
        logger.info(AppLocale.getI18n("stopping"));

        try {
            super.stop();
            System.exit(0);
        } catch (Exception ex) {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[] { ex.getLocalizedMessage() }));
            System.exit(1);
        }
    }

    protected abstract void launchConnectionMonitor();
}
