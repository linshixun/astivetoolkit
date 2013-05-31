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

import org.astivetoolkit.agi.command.DatabaseGet;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME
 */
public class DatabaseGetTest extends TestCase {
  /**
   * Creates a new DatabaseGetTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public DatabaseGetTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    String family = "familyDb";
    String key = "keyDb";

    StringBuilder b = new StringBuilder("DATABASE GET");
    b.append(" ");
    b.append("\"");
    b.append(family);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(key);
    b.append("\"");

    DatabaseGet command = new DatabaseGet(family, key);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
