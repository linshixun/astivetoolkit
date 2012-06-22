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

import java.io.IOException;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

import com.phonytive.astive.agi.DefaultAgiServerSettings;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.util.AppLocale;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @since 1.0.0
 * @see Service
 */
public class FastAgiServerSocket extends ServerSocket implements Service, DefaultAgiServerSettings {
  private static final Logger logger = Logger.getLogger(FastAgiServerSocket.class);
  {DOMConfigurator.configure("conf/log4j.xml");}
  private InetAddress bindAddr;
  private int backlog;
  private int port;

  /**
   * Creates a new FastAgiServerSocket object.
   *
   * @param port DOCUMENT ME!
   * @param backlog DOCUMENT ME!
   * @param bindAddr DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public FastAgiServerSocket(int port, int backlog, InetAddress bindAddr)
                      throws IOException {
    super();
    if (logger.isDebugEnabled()) {
      logger.debug("port = " + port);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("backlog = " + backlog);
    }

    if (logger.isDebugEnabled()){
      logger.debug("bindAddr = " + bindAddr);
    }

    this.port = port;
    this.backlog = backlog;
    this.bindAddr = bindAddr;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public FastAgiConnection acceptConnection() throws IOException {
    return new FastAgiConnection(accept());
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  @Override
  public boolean isRunning() {
    return !isClosed();
  }

  /**
   * DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   */
  @Override
  public void start() throws SystemException {
    if (logger.isDebugEnabled())
      logger.debug(AppLocale.getI18n("startingFastAgiServerSocket"));

    try {
      InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
      bind(inet, backlog);
    } catch (IOException ex) {
      throw new SystemException(AppLocale.getI18n("cantStartFastAgiServerSocket",
                                                  new Object[] { bindAddr.getHostAddress(), port }));
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   */
  @Override
  public void stop() throws SystemException {
    try {
      close();
    } catch (IOException ex) {
      throw new SystemException(AppLocale.getI18n("cantStopFastAgiServerSocket",
                                                  new Object[] { ex.getMessage() }));
    }
  }
}
