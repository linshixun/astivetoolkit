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
package com.phonytive.astive.menu;

import com.phonytive.astive.agi.command.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @since 1.0.0
 */
public class VoiceComposer {

    private static ArrayList<Object> commands;
    private static String escapeDigits;
    private static String format;
    private static TimeZone timeZone;
    private static VoiceComposer instance = new VoiceComposer();
    private static int offset;
        
    private static void reset() {
        VoiceComposer.escapeDigits = "";
        VoiceComposer.commands = new ArrayList();
        VoiceComposer.format = "";
        VoiceComposer.timeZone = null;
        VoiceComposer.offset = 0x0;
    }

    // hide the constructor
    private VoiceComposer() {
        commands = new ArrayList();
    }

    public static VoiceComposer withEscapeDigits(String escapeDigits) {
        VoiceComposer.escapeDigits = escapeDigits;
        return instance;
    }

    public static VoiceComposer withFormat(String format) {
        VoiceComposer.format = format;
        return instance;
    }

    public static VoiceComposer withTimeZone(TimeZone timeZone) {
        VoiceComposer.timeZone = timeZone;
        return instance;
    }
    
    public static VoiceComposer withOffset(int offset) {
        VoiceComposer.offset = offset;
        return instance;
    }

    public static VoiceComposer streamFile(String file) {
        if (hasEscapeDigits()) {
            commands.add(new StreamFile(file, VoiceComposer.escapeDigits));
        } else {
            commands.add(new StreamFile(file));
        }
        return instance;
    }

    public static VoiceComposer sayAlpha(String text) {
        if (hasEscapeDigits()) {
            commands.add(new SayAlpha(text, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayAlpha(text));
        }
        return instance;
    }

    public static VoiceComposer sayDate(Date date) {
        if (hasEscapeDigits()) {
            commands.add(new SayDate(date, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayDate(date));
        }
        return instance;
    }

    public static VoiceComposer sayDatetime(Date datetime) {
        if (hasEscapeDigits()) {
            commands.add(new SayDatetime(datetime, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayDatetime(datetime));
        }
        return instance;
    }

    public static VoiceComposer sayDigits(String digits) {
        if (hasEscapeDigits()) {
            commands.add(new SayDigits(digits, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayDigits(digits));
        }
        return instance;
    }

    public static VoiceComposer sayNumber(int number) {
        if (hasEscapeDigits()) {
            commands.add(new SayNumber(number, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayNumber(number));
        }
        return instance;
    }

    public static VoiceComposer sayPhonetic(String text) {
        if (hasEscapeDigits()) {
            commands.add(new SayPhonetic(text, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayPhonetic(text));
        }
        return instance;
    }

    public static VoiceComposer sayTime(Date time) {
        if (hasEscapeDigits()) {
            commands.add(new SayTime(time, VoiceComposer.escapeDigits));
        } else {
            commands.add(new SayTime(time));
        }
        return instance;
    }

    public static VoiceComposer addSilence(int silence) {
        if (hasEscapeDigits()) {
            commands.add(new StreamFile("silence/" + silence, VoiceComposer.escapeDigits));
        } else {
            commands.add(new StreamFile("silence/" + silence));
        }
        return instance;
    }

    private static boolean hasEscapeDigits() {
        if (escapeDigits != null && escapeDigits.length() != 0x0) {
            return true;
        }
        return false;
    }

    private static boolean hasFormat() {
        if (VoiceComposer.format != null) {
            return true;
        }
        return false;
    }

    private static boolean hasTimeZone() {
        if (VoiceComposer.timeZone != null) {
            return true;
        }
        return false;
    }

    private static boolean hasOffset() {
        if (VoiceComposer.offset == 0x0 ) {
            return true;
        }
        return false;
    }
    
    public static VoiceComposition create() {
        VoiceComposition vc = new VoiceComposition(VoiceComposer.commands);
        VoiceComposer.reset();
        return vc;
    }
}
