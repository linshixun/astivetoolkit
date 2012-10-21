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
package com.phonytive.astive.server.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import org.apache.log4j.Logger;
import com.phonytive.astive.AstiveException;
import com.phonytive.astive.server.AbstractAstiveServer;
import com.phonytive.astive.server.SystemException;
import com.phonytive.astive.server.appmanager.Deployer;
import com.phonytive.astive.server.appmanager.DeployerManager;
import com.phonytive.astive.server.monitor.ConnectionMonitor;
import com.phonytive.astive.server.security.AstPolicy;
import com.phonytive.astive.server.security.AstPolicyUtil;
import com.phonytive.astive.util.AppLocale;
import com.phonytive.astive.util.NetUtil;

/**
 * Provide remote access to the (@link DeployerManager) functionalities.
 *
 * @since 1.0.0
 * @see ConnectionMonitor
 * @see DeployerManager
 */
public class AdminDaemon extends ServerSocket implements Deployer, Runnable {
  private static final Logger LOG = Logger.getLogger(AdminDaemon.class);
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
  public AdminDaemon(int port, int backlog, InetAddress bindAddr, AbstractAstiveServer server)
              throws IOException {
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
  public void run() {
    try {
      if (!NetUtil.isPortAvailable(port)) {
        throw new RuntimeException(AppLocale.getI18n("unableToOpenPort", new Object[] { port }));
      }

      InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
      bind(inet, backlog);

      while (true) {
        Socket client = accept();

        StringBuilder sbr = new StringBuilder();
        sbr.append(client.getInetAddress().getHostAddress());
        sbr.append(":");
        sbr.append(port);

        SocketPermission sp = new SocketPermission(sbr.toString(), AstPolicy.DEFAULT_ACTION);

        if (!AstPolicyUtil.hasPermission(sp)) {
          client.close();

          continue;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String commandStr = reader.readLine();

        AdminCommand command = AdminCommand.valueOf(commandStr);
        String arg = null;

        if (command.equals(AdminCommand.DEPLOY) || command.equals(AdminCommand.UNDEPLOY)) {
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
            LOG.error(AppLocale.getI18n("unexpectedError", new Object[] { ex.getMessage() }));
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
      LOG.error(AppLocale.getI18n("unableToPerformIOWithAdminDaemon",
                                  new Object[] { ex.getMessage() }));
    } catch (AstiveException ex) {
      LOG.error(AppLocale.getI18n("unexpectedError", new Object[] { ex.getMessage() }));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void undeploy(String app) throws AstiveException {
    DeployerManager.getInstance().undeploy(app);
  }
}
