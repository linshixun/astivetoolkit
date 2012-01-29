/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
package com.phonytive.astive.astivlet;

import java.net.InetAddress;

import java.util.ArrayList;

import com.phonytive.astive.agi.AgiRequest;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;

/**
 * Extends the {@link AgiRequest} object to provide request information 
 * for network(FastAgi) request.
 *
 * @since 1.0.0
 * @see AstivletResponse
 */
public class AstivletRequest extends AgiRequest {
  private InetAddress localAddress;
  private InetAddress remoteAddress;
  private int localPort;
  private int remotePort;

  /**
   * Creates a new AstivletRequest object.
   *
   * @param lines DOCUMENT ME!
   * @param client DOCUMENT ME!
   */
  public AstivletRequest(ArrayList<String> lines, FastAgiConnection client) {
    super(lines);
    localAddress = client.getSocket().getLocalAddress();
    remoteAddress = client.getSocket().getLocalAddress();
    localPort = client.getSocket().getLocalPort();
    remotePort = client.getSocket().getPort();
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public InetAddress getLocalAddress() {
    return localAddress;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getLocalPort() {
    return localPort;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public InetAddress getRemoteAddress() {
    return remoteAddress;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getRemotePort() {
    return remotePort;
  }
}
