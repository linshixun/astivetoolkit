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

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;
import com.phonytive.astive.agi.Connection;
import com.phonytive.astive.agi.command.AgiCommandHandler;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.agi.fastagi.FastAgiResponse;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.AstiveException;
import com.phonytive.astive.server.FastAgiServerSocket;
import com.phonytive.astive.server.appmanager.ApplicationManager;
import com.phonytive.astive.server.appmanager.ConnectionManager;
import com.phonytive.astive.server.appmanager.FastAgiConnectionManager;
import com.phonytive.astive.server.utils.AstivletRunner;
import com.phonytive.astive.server.utils.Utils;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see ConnectionMonitor
 */
public final class SimpleConnectionMonitor implements ConnectionMonitor {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(SimpleConnectionMonitor.class);
    private FastAgiServerSocket server;
    private ConnectionManager manager;
    private ExecutorService executorService;
    private int maxThreads = 10;
    private Astivlet astivlet;

    public SimpleConnectionMonitor(FastAgiServerSocket server, Astivlet astivlet) {
        logger.debug(AppLocale.getI18n("startingConnectionMonitor"));
        this.server = server;
        this.astivlet = astivlet;
        manager = new FastAgiConnectionManager();
        executorService = Executors.newFixedThreadPool(maxThreads);
    }

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
                                // XXX:
                            }
                        }
                    });
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void processConnection(final Connection conn)
        throws AstiveException {
        logger.debug(AppLocale.getI18n("processingCall"));

        try {
            FastAgiConnection fastConn = (FastAgiConnection) conn;
            AgiCommandHandler cHandler = new AgiCommandHandler(fastConn);
            FastAgiResponse response = new FastAgiResponse(cHandler);
            AstivletRequest aRequest = new AstivletRequest(cHandler.getAgiRequest()
                                                                   .getLines(),
                    fastConn);
            AstivletResponse aResponse = new AstivletResponse((AgiResponse) response);
            String requestAppName = aRequest.getNetworkScript();
            logger.debug("exec app = " + requestAppName);

            String appName = getAppName(getAstivlet());

            System.out.println(aRequest);            
            
            if (!requestAppName.equals(appName)) {
                logger.error(AppLocale.getI18n("resourceNotExist",
                        new Object[] { requestAppName }));
                throw new AstiveException(AppLocale.getI18n(
                        "resourceNotExist", new Object[] { appName }));
            }

            AstivletRunner.invokeAstivlet(getAstivlet(), aRequest, aResponse);
            logger.debug("done.");
        } catch (AgiException ex) {
            ex.printStackTrace();
        }
    }

    public Astivlet getAstivlet() {
        return astivlet;
    }

    public void setAstivlet(Astivlet astivlet) {
        this.astivlet = astivlet;
    }

    // TODO: This should generalized. For example, I can create an interface ConectionMonitorMappStrategy
    // indicating how to mapp the apps for this server. Then create a SimpleMappingStrategy or some like that
    private static String getAppName(Astivlet astivlet) {
        try {
            InputStream is = astivlet.getClass()
                                     .getResourceAsStream("/" +
                    ApplicationManager.ASTIVE_MAPPING_FILE);
            int c = -1;
            StringBuilder sBuilder = new StringBuilder();

            while ((c = is.read()) != -1) {
                sBuilder.append((char) c);
            }

            return Utils.getAppName(sBuilder.toString());
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return null;
    }
}
