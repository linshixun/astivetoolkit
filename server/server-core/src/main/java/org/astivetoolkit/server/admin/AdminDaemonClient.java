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
package org.astivetoolkit.server.admin;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.log4j.Logger;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.0.0
 */
public class AdminDaemonClient extends Socket {
  private static final Logger LOG = Logger.getLogger(AdminDaemonClient.class);
  private BufferedReader reader;
  private PrintWriter writer;

  /**
   * Creates a new AdminDaemonClient object.
   *
   * @param addr DOCUMENT ME!
   * @param port DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public AdminDaemonClient(InetAddress addr, int port)
                    throws IOException {
    super(addr, port);
    reader = new BufferedReader(new InputStreamReader(getInputStream()));
    writer = new PrintWriter(new OutputStreamWriter(getOutputStream()));
  }

  /**
   * DOCUMENT ME!
   *
   * @param app DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public void deploy(String app) throws IOException {
    send(AdminCommand.DEPLOY, app);
  }

  private BufferedReader getReader() throws IOException {
    return reader;
  }

  private PrintWriter getWriter() throws IOException {
    return writer;
  }

  private void send(AdminCommand cmd, String arg) throws IOException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("sendingCmd", new Object[] { cmd, arg }));
    }

    getWriter().println(cmd.toString());

    if ((arg != null) && !arg.isEmpty()) {
      getWriter().println(arg);
    }

    getWriter().flush();

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public void stop() throws IOException {
    send(AdminCommand.STOP, null);
  }

  /**
   * DOCUMENT ME!
   *
   * @param app DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public void undeploy(String app) throws IOException {
    send(AdminCommand.UNDEPLOY, app);
  }
}
