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
package org.astivetoolkit.agi.command.test;

import java.util.Date;
import junit.framework.TestCase;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import org.astivetoolkit.agi.command.SayTime;

/**
 * Test case for command {@link org.astivetoolkit.agi.command.SayTime}.
 * 
 * @since 1.0.0
 */
public class SayTimeTest extends TestCase {
  /**
   * Creates a new SayTimeTest object.
   *
   * @param testName {@inheritDoc}.
   */
  public SayTimeTest(String testName) {
    super(testName);
  }

  /**
   * Test method.
   *
   * @throws AgiException if command is malformed.
   */
  public void testCommand() throws AgiException {
    Date date = new Date();
    long seconds = (date).getTime() / 1000;
    String escapeDigits = "";

    // Testing first constructor
    StringBuilder b = new StringBuilder("SAY TIME");
    b.append(" ");
    b.append("\"");
    b.append(seconds);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");

    SayTime command = new SayTime(date);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing second constructor
    escapeDigits = "123";
    b = new StringBuilder("SAY TIME");
    b.append(" ");
    b.append("\"");
    b.append(seconds);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(escapeDigits);
    b.append("\"");

    command = new SayTime(date, escapeDigits);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
