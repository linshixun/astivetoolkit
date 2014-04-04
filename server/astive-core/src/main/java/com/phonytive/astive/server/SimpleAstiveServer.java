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
package com.phonytive.astive.server;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.monitor.SimpleConnectionMonitor;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 * @see Service
 * @see AbstractAstiveServer
 * @see AstiveServer
 */
public class SimpleAstiveServer extends AbstractAstiveServer {
  // A usual logging class
  private static final Logger logger = Logger.getLogger(SimpleAstiveServer.class);
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
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getPort() {
    return port;
  }

  /**
   * DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   */
  @Override
  public void start() throws SystemException {
    super.start();
    executorService = Executors.newSingleThreadExecutor();
    launchConnectionMonitor();
  }

  /**
   * DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   */
  @Override
  public void stop() throws SystemException {
    executorService.shutdown();
    super.stop();
  }
}
