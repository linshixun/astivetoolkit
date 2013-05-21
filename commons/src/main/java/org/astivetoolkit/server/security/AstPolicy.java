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
package org.astivetoolkit.server.security;

import java.net.InetAddress;
import java.net.SocketPermission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.Iterator;
import java.util.List;
import org.astivetoolkit.server.ServiceProperties;

/**
 * AstPolicy provide a security mechanism to protect {@link AstiveServer}. This
 * is class is mean to be use in combination with {@link AstPolicyUtil}.
 *
 * @see AstPolicyUtil
 * @since 1.0.0
 */
public final class AstPolicy extends Policy {
  private static PermissionCollection perms;
  private static final AstPolicy INSTANCE = new AstPolicy();

  /**
   * Default action for SocketPermissions.
   */
  public final static String DEFAULT_ACTION = "accept";

  // Private constructor prevents instantiation from other classes     
  private AstPolicy() {
    super();

    if (perms == null) {
      perms = (new SocketPermission("127.0.0.1", "accept")).newPermissionCollection();
    }
  }

  /**
   * Add a new entry to the permission collection.
   *
   * @param permission to be added. WARNING.: this implementation provides
   * support only for SocketPermission.
   */
  public void addPermission(final SocketPermission permission) {
    perms.add(permission);
  }

  /**
   * Use to add permission for a particular <code>service</code>(ex.:Telnet).
   *
   * @param servicesProperties the service to be protected.
   */
  public void addPermissions(ServiceProperties servicesProperties) {
    List<InetAddress> onlyFromList = servicesProperties.getOnlyFrom();
    Iterator<InetAddress> onlyFromIterator = onlyFromList.iterator();

    while (onlyFromIterator.hasNext()) {
      InetAddress currentInetAddress = onlyFromIterator.next();
      StringBuilder sb = new StringBuilder();
      sb.append(currentInetAddress.getHostAddress());
      sb.append(":");

      // WARN: Hardcode !
      if (servicesProperties.getServiceName().equals("astived")) {
        sb.append("*");
      } else {
        sb.append(servicesProperties.getPort());
      }

      perms.add(new SocketPermission(sb.toString(), DEFAULT_ACTION));
    }
  }

  /**
   * Empties the permission collection.
   */
  public void clear() {
    perms = null;
    this.refresh();
  }

  /**
   * Return the only instance of AstPolicy.
   *
   * @return the only instance of AstPolicy.
   */
  public static AstPolicy getInstance() {
    return INSTANCE;
  }

  /**
   * Return the collection of permissions to be applied by the
   * Security Manager.
   *
   * @return all permissions previously added.
   */
  public PermissionCollection getPermissions() {
    return perms;
  }
}
