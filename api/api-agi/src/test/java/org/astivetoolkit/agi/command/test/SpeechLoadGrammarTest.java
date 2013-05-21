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

import org.astivetoolkit.agi.command.SpeechLoadGrammar;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class SpeechLoadGrammarTest extends TestCase {
  /**
   * Creates a new SpeechLoadGrammarTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public SpeechLoadGrammarTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    String name = "myGrammar";
    String path = "path-to-grammar";
    StringBuilder b = new StringBuilder("SPEECH LOAD GRAMMAR");
    b.append(" ");
    b.append("\"");
    b.append(name);
    b.append("\"");
    b.append(" ");
    b.append("\"");
    b.append(path);
    b.append("\"");

    SpeechLoadGrammar command = new SpeechLoadGrammar(name, path);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
