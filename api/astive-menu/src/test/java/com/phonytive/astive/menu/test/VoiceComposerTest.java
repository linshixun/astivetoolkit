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

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.CommandProcessor;
import com.phonytive.astive.menu.VoiceComposer;
import com.phonytive.astive.menu.VoiceComposition;
import java.util.Date;
import java.util.TimeZone;
import junit.framework.TestCase;

/**
 *
 * @since 1.0.0
 */
public class VoiceComposerTest extends TestCase {
    public VoiceComposerTest(String testName) {
        super(testName);
    }

    public void testVoiceComposer() throws AgiException {
        Date date = new Date();
        VoiceComposition vc = VoiceComposer.withEscapeDigits("12345")
                                           .withFormat("")
                                           .withTimeZone(TimeZone.getDefault())
                                           .streamFile("file1").addSilence(1)
                                           .withEscapeDigits("").sayAlpha("abcd")
                                           .create();
        
        assert ("STREAM FILE \"file1\" \"12345\" 0".equals(CommandProcessor.buildCommand(
                vc.getCommands().get(0))));
        assert ("STREAM FILE \"silence/1\" \"12345\" 0".equals(CommandProcessor.buildCommand(
                vc.getCommands().get(1))));
        assert ("SAY ALPHA \"abcd\" \"\"".equals(CommandProcessor.buildCommand(
                vc.getCommands().get(2))));

        for (Object o : vc.getCommands()) {            
            String cp = CommandProcessor.buildCommand(o);            
            System.out.print("class = ");
            System.out.println(o.getClass());
            System.out.println(cp);
        }
    }
}
