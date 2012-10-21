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
public class RecordFileTest extends TestCase {
  /**
   * Creates a new RecordFileTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public RecordFileTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    String filename = "abc";
    String format = "mp3";
    String escapeDigits = "";
    int timeout = 0xffffffff;
    int offset = 0x0;
    String beep = "BEEP";
    int silence = 0x0;

    // Testing first constructor
    StringBuilder b = new StringBuilder("RECORD FILE");
    b.append(" ");
    b.append("\"");
    b.append(filename);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(format);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");
    b.append(" ");
    b.append(timeout);

    RecordFile command = new RecordFile(filename, format);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing 3th constructor
    b.append(" ");
    b.append(offset);
    b.append(" ");
    b.append("\"");
    b.append(beep);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append("s=");
    b.append(silence);
    b.append("\"");
    command = new RecordFile(filename, format, escapeDigits, timeout, offset, true, silence);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
