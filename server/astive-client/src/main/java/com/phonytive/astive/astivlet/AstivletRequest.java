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
package com.phonytive.astive.astivlet;

import com.phonytive.astive.agi.AgiRequest;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Extends the {@link AgiRequest} object to provide request information 
 * for network(FastAgi) request.
 * 
 * @see AstivletResponse
 * @since 1.0.0
 */
public class AstivletRequest extends AgiRequest {
  private InetAddress localAddress;
  private InetAddress remoteAddress;
  private int localPort;
  private int remotePort;

  /**
   * Creates a new AstivletRequest object.
   *
   * @param lines use to construct client request.
   * @param client object representing client connection.
   */
  public AstivletRequest(ArrayList<String> lines, FastAgiConnection client) {
    super(lines);    
    localAddress = client.getSocket().getLocalAddress();
    remoteAddress = client.getSocket().getLocalAddress();
    localPort = client.getSocket().getLocalPort();
    remotePort = client.getSocket().getPort();
  }

  /**
   * Returns the Internet Protocol (IP) address of the interface on which the 
   * request was received.
   *
   * @return a <code>InetAddress</code> containing the IP address on which the 
   * request was received.
   */
  public InetAddress getLocalAddress() {
    return localAddress;
  }

  /**
   * Returns the Internet Protocol (IP) port number of the interface on which 
   * the request was received.
   *
   * @return an integer specifying the port number.
   */
  public int getLocalPort() {
    return localPort;
  }

  /**
   * Returns the Internet Protocol (IP) address of the client or last proxy 
   * that sent the request.
   *
   * @return a <code>InetAddress</code> containing the IP address of the client 
   * that sent the request
   */
  public InetAddress getRemoteAddress() {
    return remoteAddress;
  }

  /**
   * Returns the Internet Protocol (IP) source port of the client or last proxy 
   * that sent the request.
   *
   * @return an integer specifying the port number
   */
  public int getRemotePort() {
    return remotePort;
  }
}
