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
package com.phonytive.astive.server.monitor;

import com.phonytive.astive.api.agi.AgiException;
import com.phonytive.astive.api.agi.AgiResponse;
import com.phonytive.astive.api.agi.Connection;
import com.phonytive.astive.api.agi.command.AgiCommandHandler;
import com.phonytive.astive.api.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.api.agi.fastagi.FastAgiResponse;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.AstiveException;
import com.phonytive.astive.server.FastAgiServerSocket;
import com.phonytive.astive.server.appmanager.ConnectionManager;
import com.phonytive.astive.server.appmanager.FastAgiConnectionManager;
import com.phonytive.astive.server.utils.AstivletRunner;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see ConnectionMonitor
 */
public final class FastAgiConnectionMonitor implements ConnectionMonitor {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(FastAgiConnectionMonitor.class);
    private FastAgiServerSocket server;
    private ConnectionManager manager;
    private ThreadPoolExecutor threadPoolExecutor;

    public FastAgiConnectionMonitor(FastAgiServerSocket server, int threads) {
        logger.debug(AppLocale.getI18n("startingConnectionMonitor"));
        this.server = server;
        manager = new FastAgiConnectionManager();

        // TODO: This show be a parameter
        int corePoolSize = threads;
        int maxPoolSize = threads;
        long keepAliveTime = 5000;

        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    @Override
    public void run() {
        while (true) {
            final FastAgiConnection conn;

            try {
                conn = server.acceptConnection();

                // TODO: This should be configurable.
                if (threadPoolExecutor.getMaximumPoolSize() == threadPoolExecutor.getTaskCount()) {
                    conn.close();

                    continue;
                }

                threadPoolExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            manager.add(conn);

                            try {
                                processConnection(conn);
                            } catch (AstiveException ex) {
                                logger.warn(ex.getMessage());
                            }

                            try {
                                manager.remove(conn);
                            } catch (IOException ex) {
                                // XXX:
                            }
                        }
                    });
            } catch (IOException ex) {
                // XXX
            }
        }
    }

    @Override
    public void processConnection(final Connection conn)
        throws AstiveException {
        try {
            logger.debug(AppLocale.getI18n("processingCall"));

            FastAgiConnection fastConn = (FastAgiConnection) conn;
            AgiCommandHandler cHandler = new AgiCommandHandler(fastConn);
            FastAgiResponse response = new FastAgiResponse(cHandler);
            AstivletRequest aRequest = new AstivletRequest(cHandler.getAgiRequest()
                                                                   .getLines(),
                    fastConn);
            AstivletResponse aResponse = new AstivletResponse((AgiResponse) response);
            String appName = aRequest.getNetworkScript();
            logger.debug("exec app = " + appName);
            AstivletRunner.invokeAstivlet(appName, aRequest, aResponse);
            logger.debug("done.");
        } catch (AgiException ex) {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[] { ex.getMessage() }));
        }
    }
}
