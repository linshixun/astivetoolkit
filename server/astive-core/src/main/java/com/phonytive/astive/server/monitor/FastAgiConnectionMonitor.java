/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
 * http://astive.phonytive.com
 *
 * This file is part of Astive Toolkit
 *
 * Astive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Astive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Astive.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.phonytive.astive.server.monitor;

import com.phonytive.astive.agi.AgiCommandHandler;
import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;
import com.phonytive.astive.agi.Connection;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.agi.fastagi.FastAgiResponse;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.*;
import com.phonytive.astive.util.AppLocale;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 * @see ConnectionMonitor
 */
public final class FastAgiConnectionMonitor implements ConnectionMonitor {
    // A usual logging class

    private static final Logger logger = Logger.getLogger(FastAgiConnectionMonitor.class);
    private ConnectionManager manager;
    private FastAgiServerSocket server;
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * Creates a new FastAgiConnectionMonitor object.
     *
     * @param server DOCUMENT ME!
     * @param threads DOCUMENT ME!
     */
    public FastAgiConnectionMonitor(FastAgiServerSocket server, int threads) {
        if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("startingConnectionMonitor"));
        }

        this.server = server;
        manager = new FastAgiConnectionManager();

        // TODO: This should be a parameter
        int corePoolSize = threads;
        int maxPoolSize = threads;        
        long keepAliveTime = 5000;

        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    /**
     * DOCUMENT ME!
     *
     * @param conn DOCUMENT ME!
     *
     * @throws AstiveException DOCUMENT ME!
     */
    @Override
    public void processConnection(final Connection conn)
            throws AstiveException {
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(AppLocale.getI18n("processingCall"));
            }

            FastAgiConnection fastConn = (FastAgiConnection) conn;
            AgiCommandHandler cHandler = new AgiCommandHandler(conn);
            FastAgiResponse response = new FastAgiResponse(cHandler);
            AstivletRequest aRequest = new AstivletRequest(cHandler.getAgiRequest().getLines(), fastConn);
            AstivletResponse aResponse = new AstivletResponse((AgiResponse) response);

            AstivletProcessor.invokeAstivlet(aRequest, aResponse);

            if (logger.isDebugEnabled()) {
                logger.debug("done.");
            }

        } catch (AgiException ex) {
            logger.error(AppLocale.getI18n("unexpectedError", new Object[]{ex.getMessage()}));
        }
    }

    /**
     * DOCUMENT ME!
     */
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
                            logger.error(AppLocale.getI18n("unableToPerformIOOperations",
                                    new Object[]{ex.getMessage()}));
                        }
                    }
                });
            } catch (IOException ex) {
                logger.error(AppLocale.getI18n("unableToPerformIOOperations",
                        new Object[]{ex.getMessage()}));
            }
        }
    }
}
