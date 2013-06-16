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
package org.astivetoolkit.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.astivetoolkit.agi.DefaultAgiServerSettings;
import org.astivetoolkit.agi.fastagi.FastAgiConnection;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.0.0
 * @see Service
 */
public class FastAgiServerSocket extends ServerSocket implements Service, DefaultAgiServerSettings {
  private static final Logger LOG = Logger.getLogger(FastAgiServerSocket.class);
  private InetAddress bindAddr;
  private int backlog;
  private int port;

  {
    DOMConfigurator.configure("conf/log4j.xml");
  }

  /**
   * Creates a new FastAgiServerSocket object.
   *
   * @param port 
   * @param backlog 
   * @param bindAddr
   *
   * @throws IOException 
   */
  public FastAgiServerSocket(int port, int backlog, InetAddress bindAddr)
                      throws IOException {
    super();

    if (LOG.isDebugEnabled()) {
      LOG.debug("port = " + port);
      LOG.debug("backlog = " + backlog);
      LOG.debug("bindAddr = " + bindAddr);
    }

    this.port = port;
    this.backlog = backlog;
    this.bindAddr = bindAddr;
  }

  public FastAgiConnection acceptConnection() throws IOException {
    return new FastAgiConnection(accept());
  }

  /**
   * {@inheritDoc}   
   */
  @Override
  public boolean isRunning() {
    return !isClosed();
  }

  /**
   * {@inheritDoc}   
   */
  @Override
  public void start() throws SystemException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("startingFastAgiServerSocket"));
    }

    try {
      InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
      bind(inet, backlog);
    } catch (IOException ex) {
      throw new SystemException(AppLocale.getI18n("cantStartFastAgiServerSocket",
                                                  new Object[] { bindAddr.getHostAddress(), port }));
    }

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
    }
  }

  /**
   * {@inheritDoc}   
   */
  @Override
  public void stop() throws SystemException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("stoppingFastAgiServerSocket"));
    }

    try {
      close();
    } catch (IOException ex) {
      throw new SystemException(AppLocale.getI18n("cantStopFastAgiServerSocket",
                                                  new Object[] { ex.getMessage() }));
    }

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
    }
  }
}
