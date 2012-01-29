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
package com.phonytive.astive.server.utils;

import java.util.ArrayList;

import com.phonytive.astive.util.AppLocale;

/**
 *
 * @since 1.0.0
 */
public class InitOutput {
  /**
   * DOCUMENT ME!
   *
   * @param properties DOCUMENT ME!
   */
  public static void printInit(ArrayList<ServiceProperties> properties) {
    // TODO: Programmatically include the build and the version
    String output = AppLocale.getI18n("init.header");

    for (ServiceProperties param : properties) {
      // TODO: This is not elegant but work !
      if (param.getServiceName().length() > 7) {
        output += (param.getServiceName() + "\t");
      } else {
        output += (param.getServiceName() + "\t\t");
      }

      output += (param.getBindAddr().getHostAddress() + "\t");
      output += (param.getPort() + "\n");
    }

    output += AppLocale.getI18n("init.footer");
    System.out.println(output);
  }
}
