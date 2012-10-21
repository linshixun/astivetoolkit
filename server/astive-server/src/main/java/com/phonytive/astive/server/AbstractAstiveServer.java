/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
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
package com.phonytive.astive.server;

import com.phonytive.astive.Version;
import com.phonytive.astive.util.AppLocale;
import java.io.IOException;
import java.net.InetAddress;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 * @see Service
 * @see FastAgiServerSocket
 * @see AstiveServer
 * @see SimpleAstiveServer
 */
public abstract class AbstractAstiveServer extends FastAgiServerSocket
        implements Service {

    /**
     *
     */
    private static final Logger LOG = Logger.getLogger(AbstractAstiveServer.class);
    public static final String ASTIVE_HOME = System.getenv("ASTIVE_HOME");
    public static final String ASTIVE_APPS = System.getenv("ASTIVE_HOME")
            + "/apps/";
    /**
     *
     */
    private InetAddress bindAddr;
    /**
     *
     */
    private int backlog;
    /**
     *
     */
    private int port;

    /**
     * Creates a new AbstractAstiveServer object.
     *
     * @throws SystemException DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    public AbstractAstiveServer() throws SystemException, IOException {
        // Using the default agi asterisk port
        super(DEFAULT_AGI_SERVER_PORT, DEFAULT_AGI_SERVER_BACKLOG,
                InetAddress.getByName(DEFAULT_AGI_SERVER_BIND_ADDR));
        this.port = DEFAULT_AGI_SERVER_PORT;
        this.backlog = DEFAULT_AGI_SERVER_BACKLOG;
    }

    /**
     * Creates a new AbstractAstiveServer object.
     *
     * @param port DOCUMENT ME!
     *
     * @throws SystemException DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    public AbstractAstiveServer(int port) throws SystemException, IOException {
        super(port, DEFAULT_AGI_SERVER_BACKLOG,
                InetAddress.getByName(DEFAULT_AGI_SERVER_BIND_ADDR));
    }

    /**
     * Creates a new AbstractAstiveServer object.
     *
     * @param port DOCUMENT ME!
     * @param backlog DOCUMENT ME!
     *
     * @throws SystemException DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    public AbstractAstiveServer(int port, int backlog)
            throws SystemException, IOException {
        super(port, backlog, InetAddress.getLocalHost());
    }

    /**
     * Creates a new AbstractAstiveServer object.
     *
     * @param port DOCUMENT ME!
     * @param backlog DOCUMENT ME!
     * @param bindAddr DOCUMENT ME!
     *
     * @throws SystemException DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    public AbstractAstiveServer(int port, int backlog, InetAddress bindAddr)
            throws SystemException, IOException {
        super(port, backlog, bindAddr);
        this.bindAddr = bindAddr;
        this.port = port;
        this.backlog = backlog;
    }

    /**
     * DOCUMENT ME!
     */
    protected abstract void launchConnectionMonitor();

    /**
     * DOCUMENT ME!
     *
     * @throws SystemException DOCUMENT ME!
     */
    @Override
    public void start() throws SystemException {
        if(LOG.isInfoEnabled()) {
            LOG.info(AppLocale.getI18n("starting"));
        }
        super.start();
    }

    /**
     * DOCUMENT ME!
     *
     * @throws SystemException DOCUMENT ME!
     */
    @Override
    public void stop() throws SystemException {
        if(LOG.isInfoEnabled()) {
            LOG.info(AppLocale.getI18n("stopping"));
        }

        try {
            super.stop();
            System.exit(0x0);
        } catch (Exception ex) {
            LOG.error(AppLocale.getI18n("unexpectedError",
                    new Object[]{ex.getMessage()}));
            System.exit(0x1);
        }
    }

    /**
     *
     * @return App version.
     */
    public String getVersion() {
        StringBuilder sb = new StringBuilder(
                AppLocale.getI18n("appVersion", new String[]{Version.VERSION, Version.BUILD_TIME}));
        return sb.toString();
    }

    /**
     * @return the bindAddr
     */
    public InetAddress getBindAddr() {
        return bindAddr;
    }

    /**
     * @return the backlog
     */
    public int getBacklog() {
        return backlog;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }
}
