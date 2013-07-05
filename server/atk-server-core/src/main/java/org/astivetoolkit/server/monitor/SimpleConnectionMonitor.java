/*
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.server.monitor;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.astivetoolkit.AstiveException;
import org.astivetoolkit.agi.AgiCommandHandler;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.AgiResponse;
import org.astivetoolkit.agi.Connection;
import org.astivetoolkit.agi.fastagi.FastAgiConnection;
import org.astivetoolkit.agi.fastagi.FastAgiResponse;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.astivlet.AstivletRequest;
import org.astivetoolkit.astivlet.AstivletResponse;
import org.astivetoolkit.server.AstivletProcessor;
import org.astivetoolkit.server.ConnectionManager;
import org.astivetoolkit.server.FastAgiConnectionManager;
import org.astivetoolkit.server.FastAgiServerSocket;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.0.0
 * @see ConnectionMonitor
 */
public class SimpleConnectionMonitor implements ConnectionMonitor {
    // A usual logging class

    private static final Logger LOG = Logger.getLogger(SimpleConnectionMonitor.class);
    private Astivlet astivlet;
    private ConnectionManager manager;
    private ExecutorService executorService;
    private FastAgiServerSocket server;
    private int maxThreads = 10;

    /**
     * Creates a new SimpleConnectionMonitor object.
     *
     * @param server the server.
     * @param astivlet the application.
     */
    public SimpleConnectionMonitor(FastAgiServerSocket server, Astivlet astivlet) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("messageStartingConnectionMonitor"));
        }

        this.server = server;
        this.astivlet = astivlet;
        manager = new FastAgiConnectionManager();
        executorService = Executors.newFixedThreadPool(maxThreads);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processConnection(final Connection conn)
            throws AstiveException {
        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("messageProcessingCall"));
        }

        try {
            FastAgiConnection fastConn = (FastAgiConnection) conn;
            AgiCommandHandler cHandler = new AgiCommandHandler(fastConn);
            FastAgiResponse response = new FastAgiResponse(cHandler);
            AstivletRequest aRequest = new AstivletRequest(cHandler.getAgiRequest().getLines(), fastConn);
            AstivletResponse aResponse = new AstivletResponse((AgiResponse) response);
            String requestAppName = aRequest.getRequestURL();

            if (LOG.isDebugEnabled()) {
                LOG.debug(AppLocale.getI18n("messageExecApp", new Object[]{requestAppName}));
            }

            AstivletProcessor.invokeAstivlet(getAstivlet(), aRequest, aResponse);

            if (LOG.isDebugEnabled()) {
                LOG.debug(AppLocale.getI18n("messageDone"));
            }
        } catch (AgiException ex) {
            LOG.error(AppLocale.getI18n("errorUnexpectedFailure", new Object[]{ex.getMessage()}));
        }
    }

    /**
     * {@inheritDoc}
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
                            LOG.warn(ex.getMessage());
                        }

                        try {
                            manager.remove(conn);
                        } catch (IOException ex) {
                            LOG.error(AppLocale.getI18n("errorConnectionClosed",
                                    new Object[]{ex.getMessage()}));
                        }
                    }
                });
            } catch (IOException ex) {
                LOG.error(AppLocale.getI18n("errorConnectionClosed", new Object[]{ex.getMessage()}));
            }
        }
    }

    /**
     * Set the {@link org.astivetoolkit.astivlet.Astivlet} that will be
     * performed.
     *
     * @param astivlet the astivlet to perform.
     */
    public void setAstivlet(Astivlet astivlet) {
        this.astivlet = astivlet;
    }

    /**
     * Returns the {@link org.astivetoolkit.astivlet.Astivlet} that will be
     * performed.
     *
     * @returns the astivlet to perform.
     */
    public Astivlet getAstivlet() {
        return astivlet;
    }

    // TODO: This should be generalized. For instance, creating an interface
    // ConectionMonitorMappStrategy indicating how to mapp the apps for this
    // server. Then create a SimpleMappingStrategy or some like that
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
}