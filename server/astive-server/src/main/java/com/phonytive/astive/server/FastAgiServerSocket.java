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

import com.phonytive.astive.api.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see Service
 */
public class FastAgiServerSocket extends ServerSocket implements Service {
    private static final Logger logger = Logger.getLogger(FastAgiServerSocket.class);
    private InetAddress bindAddr;
    private int port;
    private int backlog;

    public FastAgiServerSocket(int port, int backlog, InetAddress bindAddr)
        throws IOException {
        super();
        logger.debug("port = " + port);
        logger.debug("backlog = " + backlog);
        logger.debug("bindAddr = " + bindAddr);
        this.port = port;
        this.backlog = backlog;
        this.bindAddr = bindAddr;
    }

    public FastAgiConnection acceptConnection() throws IOException {
        return new FastAgiConnection(accept());
    }

    @Override
    public void start() throws SystemException {
        logger.debug(AppLocale.getI18n("startingFastAgiServerSocket"));

        try {
            InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
            bind(inet, backlog);
        } catch (IOException ex) {
            throw new SystemException(AppLocale.getI18n(
                    "cantStartFastAgiServerSocket",
                    new Object[] { bindAddr.getHostAddress(), port }));
        }
    }

    @Override
    public void stop() throws SystemException {
        try {
            close();
        } catch (IOException ex) {
            throw new SystemException(AppLocale.getI18n(
                    "cantStopFastAgiServerSocket",
                    new Object[] { ex.getMessage() }));
        }
    }

    @Override
    public boolean isRunning() {
        return !isClosed();
    }
}
