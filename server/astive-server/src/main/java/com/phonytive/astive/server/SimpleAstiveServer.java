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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.monitor.SimpleConnectionMonitor;

/**
 *
 * @since 1.0.0
 * @see Service
 * @see AbstractAstiveServer
 * @see AstiveServer
 */
public class SimpleAstiveServer extends AbstractAstiveServer {
  private Astivlet astivlet;
  private ExecutorService executorService;
  private int port;

  /**
   * Creates a new SimpleAstiveServer object.
   *
   * @param astivlet DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   * @throws IOException DOCUMENT ME!
   */
  public SimpleAstiveServer(Astivlet astivlet) throws SystemException, IOException {
    super();
    this.port = DEFAULT_AGI_SERVER_PORT;
    this.astivlet = astivlet;
  }

  /**
   * Creates a new SimpleAstiveServer object.
   *
   * @param astivlet DOCUMENT ME!
   * @param port DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   * @throws IOException DOCUMENT ME!
   */
  public SimpleAstiveServer(Astivlet astivlet, int port)
                     throws SystemException, IOException {
    super(port);
    this.port = port;
    this.astivlet = astivlet;
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
   * {@inheritDoc}
   */
  @Override
  public int getPort() {
    return port;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void launchConnectionMonitor() {
    SimpleConnectionMonitor monitor = new SimpleConnectionMonitor(this, astivlet);
    monitor.run();

    //executorService.execute(monitor);
  }

  /**
   * DOCUMENT ME!
   *
   * @param astivlet DOCUMENT ME!
   */
  public void setAstivlet(Astivlet astivlet) {
    this.astivlet = astivlet;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start() throws SystemException {
    super.start();
    executorService = Executors.newSingleThreadExecutor();
    launchConnectionMonitor();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop() throws SystemException {
    executorService.shutdown();
    super.stop();
  }
}
