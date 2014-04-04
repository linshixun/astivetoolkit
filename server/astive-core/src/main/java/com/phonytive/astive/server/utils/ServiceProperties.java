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
package com.phonytive.astive.server.utils;

import java.net.InetAddress;

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
  InetAddress getOnlyFrom();

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
  void setOnlyFrom(InetAddress onlyFrom);

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
