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
package com.phonytive.astive.menu.test;

import java.util.TimeZone;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import org.astivetoolkit.menu.VoiceComposer;
import org.astivetoolkit.menu.VoiceComposition;
import junit.framework.TestCase;

/**
 *
 * @since 1.0.0
 */
public class VoiceComposerTest extends TestCase {
  /**
   * Creates a new VoiceComposerTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public VoiceComposerTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testVoiceComposer() throws AgiException {
    VoiceComposition vc =
      VoiceComposer.withEscapeDigits("12345").withFormat("").withTimeZone(TimeZone.getDefault())
       .streamFile("file1").addSilence(0x1).withEscapeDigits("").sayAlpha("abcd").create();
    assertEquals("STREAM FILE \"file1\" \"12345\" 0",
                 CommandProcessor.buildCommand(vc.getCommands().get(0x0)));
    assertEquals("STREAM FILE \"silence/1\" \"12345\" 0",
                 CommandProcessor.buildCommand(vc.getCommands().get(0x1)));
    assertEquals("SAY ALPHA \"abcd\" \"\"", CommandProcessor.buildCommand(vc.getCommands().get(0x2)));
  }
}
