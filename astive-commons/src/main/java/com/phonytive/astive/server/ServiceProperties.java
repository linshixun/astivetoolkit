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

import java.net.InetAddress;
import java.util.List;

/**
 *
 * @since 1.0.0
 */
public interface ServiceProperties {
  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  int getBacklog();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  InetAddress getBindAddr();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  List<InetAddress> getOnlyFrom();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  int getPort();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  String getServer();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  String getServiceName();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  boolean isDisabled();

  /**
   * 
   * @return 
   */
  boolean isUnableToOpen();
  
  /**
   * 
   */
  void setUnableToOpen(boolean unableToOpen);
  
  /**
   * DOCUMENT ME!
   *
   * @param backlog DOCUMENT ME!
   */
  void setBacklog(int backlog);

  /**
   * DOCUMENT ME!
   *
   * @param bindAddr DOCUMENT ME!
   */
  void setBindAddr(InetAddress bindAddr);

  /**
   * DOCUMENT ME!
   *
   * @param disabled DOCUMENT ME!
   */
  void setDisabled(boolean disabled);

  /**
   * DOCUMENT ME!
   *
   * @param onlyFrom DOCUMENT ME!
   */
  void setOnlyFrom(List<InetAddress> onlyFrom);

  /**
   * DOCUMENT ME!
   *
   * @param port DOCUMENT ME!
   */
  void setPort(int port);

  /**
   * DOCUMENT ME!
   *
   * @param server DOCUMENT ME!
   */
  void setServer(String server);

  /**
   * DOCUMENT ME!
   *
   * @param serviceName DOCUMENT ME!
   */
  void setServiceName(String serviceName);
  
  /**
   * 
   */
  String getPameter(String parameter);
}
