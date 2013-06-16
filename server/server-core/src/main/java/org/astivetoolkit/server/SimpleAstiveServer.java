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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.server.monitor.SimpleConnectionMonitor;

/**
 * Simple and convenient {@link AstiveServer}, useful for testing.
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

  public SimpleAstiveServer(Astivlet astivlet) throws SystemException, IOException {
    super();
    this.port = DEFAULT_AGI_SERVER_PORT;
    this.astivlet = astivlet;
  }

  public SimpleAstiveServer(Astivlet astivlet, int port)
                     throws SystemException, IOException {
    super(port);
    this.port = port;
    this.astivlet = astivlet;
  }

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
  }

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
