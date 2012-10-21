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
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.phonytive.astive.agi.Connection;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import com.phonytive.astive.util.AppLocale;

/**
 *
 * @since 1.0.0
 * @see ConnectionManager
 */
public class FastAgiConnectionManager implements ConnectionManager {
  // A usual logging class
  private static final Logger LOG = Logger.getLogger(FastAgiConnectionManager.class);
  private ArrayList<Connection> conns;

  /**
   * Creates a new FastAgiConnectionManager object.
   */
  public FastAgiConnectionManager() {
    conns = new ArrayList<Connection>();
  }

  /**
   * DOCUMENT ME!
   *
   * @param conn DOCUMENT ME!
   */
  @Override
  public void add(Connection conn) {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("newConnectionAdded", new String[] { conn.toString() }));
    }

    conns.add(conn);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  @Override
  public ArrayList<Connection> connections() {
    return conns;
  }

  /**
   * DOCUMENT ME!
   *
   * @param conn DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  @Override
  public void remove(Connection conn) throws IOException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("removingConnection", new String[] { conn.toString() }));
    }

    if (!conn.isClosed()) {
      ((FastAgiConnection) conn).close();
    }

    conns.remove(conn);

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  @Override
  public void removeAll() throws IOException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("removingAllConnection"));
    }

    for (Connection conn : conns) {
      if (!conn.isClosed()) {
        ((FastAgiConnection) conn).close();
      }
    }

    conns.clear();

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
    }
  }
}
