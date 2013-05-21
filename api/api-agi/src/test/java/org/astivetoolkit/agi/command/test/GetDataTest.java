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

import org.astivetoolkit.agi.command.GetData;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME
 */
public class GetDataTest extends TestCase {
  /**
   * Creates a new GetDataTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public GetDataTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    String file = "tt-monkeys";
    int timeout = 0x0;
    int maxDigits = 0x400;

    // Test first constructor
    StringBuilder b = new StringBuilder("GET DATA");
    b.append(" ");
    b.append("\"");
    b.append(file);
    b.append("\"");
    b.append(" ");
    b.append(timeout);
    b.append(" ");
    b.append(maxDigits);

    GetData command = new GetData(file);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing the second constructor
    command = new GetData(file, timeout);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing the third and last constructor
    command = new GetData(file, timeout, maxDigits);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
