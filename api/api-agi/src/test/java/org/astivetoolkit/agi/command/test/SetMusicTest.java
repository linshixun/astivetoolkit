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

import org.astivetoolkit.agi.command.SetMusic;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME
 */
public class SetMusicTest extends TestCase {
  /**
   * Creates a new SetMusicTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public SetMusicTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    Boolean on = true;
    String musicOn = "ON";
    String classStr = "my-class";

    // Testing first constructor
    StringBuilder b = new StringBuilder("SET MUSIC");
    b.append(" ");
    b.append("\"");
    b.append(musicOn);
    b.append("\"");

    SetMusic command = new SetMusic(on);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing second constructor                
    b.append(" ");
    b.append("\"");
    b.append(classStr);
    b.append("\"");
    command = new SetMusic(on, classStr);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
