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
package com.phonytive.astive.server.admin;

import com.phonytive.astive.server.AbstractAstiveServer;
import com.phonytive.astive.server.AstiveException;
import com.phonytive.astive.server.SystemException;
import com.phonytive.astive.server.appmanager.Deployer;
import com.phonytive.astive.server.appmanager.DeployerManager;
import com.phonytive.astive.server.monitor.ConnectionMonitor;
import com.phonytive.astive.util.AppLocale;
import com.phonytive.astive.util.NetUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 * Provide remote access to the (@link DeployerManager) functionalities.
 *
 * @since 1.0.0
 * @see ConnectionMonitor
 * @see DeployerManager
 */
public final class AdminDaemon extends ServerSocket
        implements Deployer, Runnable {

    private static final Logger logger = Logger.getLogger(AdminDaemon.class);
    private AbstractAstiveServer server;
    private InetAddress bindAddr;
    private int backlog;
    private int port;

    /**
     * Creates a new AdminDaemon object.
     *
     * @param port DOCUMENT ME!
     * @param backlog DOCUMENT ME!
     * @param bindAddr DOCUMENT ME!
     * @param server DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     */
    public AdminDaemon(int port, int backlog, InetAddress bindAddr,
            AbstractAstiveServer server) throws IOException {
        super();
        this.port = port;
        this.backlog = backlog;
        this.bindAddr = bindAddr;
        this.server = server;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deploy(String app) throws AstiveException {
        DeployerManager.getInstance().deploy(app);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void undeploy(String app) throws AstiveException {
        DeployerManager.getInstance().undeploy(app);
    }

    @Override
    public void run() {
        try {
            
            if (!NetUtil.available(port)) {
                throw new RuntimeException(AppLocale.getI18n("unableToOpenPort", new Object[]{port}));
            }
            
            InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
            bind(inet, backlog);

            while (true) {
                Socket client = accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        client.getInputStream()));
                String commandStr = reader.readLine();

                AdminCommand command = AdminCommand.valueOf(commandStr);
                String arg = null;

                if (command.equals(AdminCommand.DEPLOY)
                        || command.equals(AdminCommand.UNDEPLOY)) {
                    arg = reader.readLine();
                }

                if (command.equals(AdminCommand.DEPLOY)) {
                    deploy(arg);

                    continue;
                }

                if (command.equals(AdminCommand.UNDEPLOY)) {
                    undeploy(arg);

                    continue;
                }

                if (command.equals(AdminCommand.STOP)) {
                    try {
                        server.stop();
                    } catch (SystemException ex) {
                        logger.error(AppLocale.getI18n("unexpectedError",
                                new Object[]{ex.getMessage()}));
                    }

                    break;
                }

                if (command.equals(AdminCommand.HELP)) {
                    // XXX: no-yet-implemented
                    break;
                }

                if (command.equals(AdminCommand.VERSION)) {
                    // XXX: no-yet-implemented
                    break;
                }

                client.close();
            }
        } catch (IOException ex) {
            logger.error(AppLocale.getI18n("unableToPerformIOWithAdminDaemon",
                    new Object[]{ex.getMessage()}));
        } catch (AstiveException ex) {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[]{ex.getMessage()}));
        }
    }
}
