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
package com.phonytive.astive.server.monitor;

import com.phonytive.astive.AstiveException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
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
  private int maxThreads = 0xa;

  /**
   * Creates a new SimpleConnectionMonitor object.
   *
   * @param server DOCUMENT ME!
   * @param astivlet DOCUMENT ME!
   */
  public SimpleConnectionMonitor(FastAgiServerSocket server, Astivlet astivlet) {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("startingConnectionMonitor"));
    }

    this.server = server;
    this.astivlet = astivlet;
    manager = new FastAgiConnectionManager();
    executorService = Executors.newFixedThreadPool(maxThreads);
  }

  // TODO: This should be generalized. For example, I can create an interface ConectionMonitorMappStrategy
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
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("processingCall"));
    }

    try {
      FastAgiConnection fastConn = (FastAgiConnection) conn;
      AgiCommandHandler cHandler = new AgiCommandHandler(fastConn);
      FastAgiResponse response = new FastAgiResponse(cHandler);
      AstivletRequest aRequest = new AstivletRequest(cHandler.getAgiRequest().getLines(), fastConn);
      AstivletResponse aResponse = new AstivletResponse((AgiResponse) response);
      String requestAppName = aRequest.getRequestURL();

      if (LOG.isDebugEnabled()) {
        LOG.debug("exec app = " + requestAppName);
      }

      AstivletProcessor.invokeAstivlet(getAstivlet(), aRequest, aResponse);

      if (LOG.isDebugEnabled()) {
        LOG.debug("done.");
      }
    } catch (AgiException ex) {
      LOG.error(AppLocale.getI18n("unexpectedError", new Object[] { ex.getMessage() }));
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
                LOG.warn(ex.getMessage());
              }

              try {
                manager.remove(conn);
              } catch (IOException ex) {
                LOG.error(AppLocale.getI18n("unableToPerformIOOperations",
                                            new Object[] { ex.getMessage() }));
              }
            }
          });
      } catch (IOException ex) {
        LOG.error(AppLocale.getI18n("unableToPerformIOOperations", new Object[] { ex.getMessage() }));
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
