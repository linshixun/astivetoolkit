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
package org.astivetoolkit.server.appmanager;

import org.astivetoolkit.AstiveException;

/**
 *
 * @since 1.0.0
 */
public interface Deployer {
  /**
   * Adds app to the server index.
   *
   * @param file app path
   * @throws AstiveException
   */
  void deploy(String file) throws AstiveException;

  /**
   * Discharge app from the server.
   *
   * @param deploymentId app to undeployed.
   * @throws AstiveException if app don't exist.
   */
  void undeploy(String deploymentId) throws AstiveException;
}
