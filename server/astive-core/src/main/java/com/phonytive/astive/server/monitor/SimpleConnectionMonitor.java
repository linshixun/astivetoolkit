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
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.*;
import com.phonytive.astive.util.AppLocale;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 * @see ConnectionMonitor
 */
public final class SimpleConnectionMonitor implements ConnectionMonitor {
    // A usual logging class

    private static final Logger logger = Logger.getLogger(SimpleConnectionMonitor.class);
    private Astivlet astivlet;
    private ConnectionManager manager;
    private ExecutorService executorService;
    private FastAgiServerSocket server;
    private int maxThreads = 10;

    /**
     * Creates a new SimpleConnectionMonitor object.
     *
     * @param server DOCUMENT ME!
     * @param astivlet DOCUMENT ME!
     */
    public SimpleConnectionMonitor(FastAgiServerSocket server, Astivlet astivlet) {
        if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("startingConnectionMonitor"));
        }

        this.server = server;
        this.astivlet = astivlet;
        manager = new FastAgiConnectionManager();
        executorService = Executors.newFixedThreadPool(maxThreads);
    }

    // TODO: This should generalized. For example, I can create an interface ConectionMonitorMappStrategy
    // indicating how to mapp the apps for this server. Then create a SimpleMappingStrategy or some like that
    @Deprecated
    private static String getAppName(Astivlet astivlet) {
        /*
         * try { InputStream is = astivlet.getClass().getResourceAsStream("/" +
         * AbstractAstiveServer.ASTIVE_DEPLOYMENT_DESCRIPTOR); int c = -1;
         * StringBuilder sBuilder = new StringBuilder();
         *
         * while ((c = is.read()) != -1) { sBuilder.append((char) c); }
         *
         * // WARNING: Uncomment this //return
         * Utils.getAppName(sBuilder.toString()); } catch (FileNotFoundException
         * ex) { } catch (IOException ex) { }
         */

        return null;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Astivlet getAstivlet() {
        return astivlet;
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
        if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("processingCall"));
        }

        try {
            FastAgiConnection fastConn = (FastAgiConnection) conn;
            AgiCommandHandler cHandler = new AgiCommandHandler(fastConn);
            FastAgiResponse response = new FastAgiResponse(cHandler);
            AstivletRequest aRequest = new AstivletRequest(cHandler.getAgiRequest().getLines(), fastConn);
            AstivletResponse aResponse = new AstivletResponse((AgiResponse) response);
            String requestAppName = aRequest.getRequestURL();

            if (logger.isDebugEnabled()) {
                logger.debug("exec app = " + requestAppName);
            }

            AstivletProcessor.invokeAstivlet(getAstivlet(), aRequest, aResponse);

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
            try {
                final FastAgiConnection conn = server.acceptConnection();
                executorService.execute(new Runnable() {

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

    /**
     * DOCUMENT ME!
     *
     * @param astivlet DOCUMENT ME!
     */
    public void setAstivlet(Astivlet astivlet) {
        this.astivlet = astivlet;
    }
}
