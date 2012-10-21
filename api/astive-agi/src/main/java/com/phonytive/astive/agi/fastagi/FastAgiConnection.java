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
package com.phonytive.astive.agi.fastagi;

import java.io.*;
import java.net.Socket;
import com.phonytive.astive.agi.Connection;

/**
 * Create a communication channel from Asterisk to the Fastagi server.
 *
 * @since 1.0.0
 * @see Connection
 */
public class FastAgiConnection implements Connection {
  private BufferedReader reader;
  private PrintWriter writer;
  private Socket socket;

  /**
   * Create a new FastAgiConnection object with host and port as parameters.
   *
   * @param host to connect.
   * @param port to connect.
   * @throws IOException if socket is not open.
   */
  public FastAgiConnection(String host, int port) throws IOException {
    socket = new Socket(host, port);
    setIO();
  }

  /**
   * Create a new FastAgiConnection object with a socket as parameter.
   *
   * @param socket create by other class.
   * @throws IOException if socket is not open.
   */
  public FastAgiConnection(Socket socket) throws IOException {
    this.socket = socket;
    setIO();
  }

  /**
   * Close the current connection.
   *
   * @throws IOException if socket was closed already.
   */
  public void close() throws IOException {
    socket.close();
  }

  /**
   * Get socket object for this connection.
   *
   * @return socket for this connection.
   */
  public Socket getSocket() {
    return socket;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isClosed() {
    return socket.isClosed();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String readLine() throws IOException {
    return reader.readLine();
  }

  /**
   * Sets the variables reader and writer.
   *
   * @throws IOException if socket is not open.
   */
  private void setIO() throws IOException {
    reader = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
    writer = new PrintWriter(new OutputStreamWriter(getSocket().getOutputStream()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void write(String str) throws IOException {
    writer.println(str);
    writer.flush();
  }
}
