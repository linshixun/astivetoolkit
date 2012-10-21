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

import java.util.Date;
import java.util.TimeZone;
import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME 
 */
public class SayDatetimeTest extends TestCase {
  /**
   * Creates a new SayDatetimeTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public SayDatetimeTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    Date date = new Date();
    long seconds = (date).getTime() / 0x3e8;
    String escapeDigits;
    String format = SayDatetime.DEFAULT_FORMAT;
    TimeZone tz = TimeZone.getDefault();

    // Testing first constructor
    StringBuilder b = new StringBuilder("SAY DATETIME");
    b.append(" ");
    b.append("\"");
    b.append(seconds);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append("\"");

    SayDatetime command = new SayDatetime(date);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing second constructor
    escapeDigits = "123";
    b = new StringBuilder("SAY DATETIME");
    b.append(" ");
    b.append("\"");
    b.append(seconds);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");

    command = new SayDatetime(date, escapeDigits);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing third constructor
    b.append(" ");
    b.append("\"");
    b.append(format);
    b.append("\"");

    command = new SayDatetime(date, escapeDigits, format);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing last constructor
    b.append(" ");
    b.append("\"");
    b.append(tz.getID());
    b.append("\"");

    command = new SayDatetime(date, escapeDigits, format, tz);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
