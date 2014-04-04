/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
