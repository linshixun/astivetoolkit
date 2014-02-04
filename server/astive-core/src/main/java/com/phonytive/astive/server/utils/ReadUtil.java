/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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
package com.phonytive.astive.server.utils;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;

/**
 *
 * @since 1.0.0
 */
public class ReadUtil {
  ArrayList<String> lines = new ArrayList<String>();

  /**
   * Creates a new ReadUtil object.
   *
   * @param reader DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public ReadUtil(BufferedReader reader) throws IOException {
    String s = null;
    lines.add(reader.readLine());

    while (true) {
      if ((s = reader.readLine()).equals("")) {
        break;
      }

      lines.add(s);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public ArrayList<String> getLines() {
    return lines;
  }
}
