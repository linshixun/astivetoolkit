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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME 
 */
public class StreamFileTest extends TestCase {
  /**
   * Creates a new StreamFileTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public StreamFileTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    String filename = "file";
    String escapeDigits = "";
    Integer offset = 0x0;

    // Testing first constructor 
    StringBuilder b = new StringBuilder("STREAM FILE");
    b.append(" ");
    b.append("\"");
    b.append(filename);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");
    b.append(" ");
    b.append(offset);

    StreamFile command = new StreamFile(filename);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing second constructor
    b = new StringBuilder("STREAM FILE");
    b.append(" ");
    b.append("\"");
    b.append(filename);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");
    b.append(" ");
    b.append(offset);
    command = new StreamFile(filename, escapeDigits);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing second constructor
    b = new StringBuilder("STREAM FILE");
    b.append(" ");
    b.append("\"");
    b.append(filename);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");
    b.append(" ");
    b.append(offset);
    command = new StreamFile(filename, escapeDigits, offset);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
