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

import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.command.SayDate;
import com.phonytive.astive.agi.command.StreamFile;
import java.util.Date;

/**
 *
 * @since 1.0.0
 * @see MenuItem
 */
public class VoiceComposer {

    private static Object command;
    private static String escapeDigits;
    
    private VoiceComposer() {
        // Hide the constructor.
    }
    
    public static VoiceComposer withEscapeDigits(String escapeDigits) {
        VoiceComposer.escapeDigits = escapeDigits;
        return instance;
    }
    
    private static boolean hasEscapeDigits() {
        if(escapeDigits.length() == 0) {
            return false;
        } 
        return true;
    }

    public static VoiceComposer getInstance() {
        return instance;
    }

    public static void setInstance(VoiceComposer instance) {
        VoiceComposer.instance = instance;
    }
    
    private static VoiceComposer instance = new VoiceComposer();    
    
    public static VoiceComposer streamFile(String file) {
        if(hasEscapeDigits()) {
            VoiceComposer.command = new StreamFile(file, VoiceComposer.escapeDigits);
        }
        VoiceComposer.command = new StreamFile(file);
        return instance;
    }
    
    public static VoiceComposer addSilence(int seconds) {
        return null;
    }
    
    public static VoiceComposer sayAlpha(String text) {
        
        return null;
    }
    
    public static VoiceComposer sayDigits(String digits) {        
        return null;
    }
    
    public static VoiceComposer sayNumber(Integer number) {
        
        return null;
    }
    
    public static VoiceComposer sayPhonetic(String text) {
        
        return null;
    }
    
    public static VoiceComposer sayDate(Date date) {
        
        command = new SayDate(date).getClass().getAnnotation(AgiCommand.class);
        
        return instance;
    }
 
    public static VoiceComposer sayTime(Date time) {
        
        return null;
    }
    
    public static VoiceComposer sayDatetime(Date datetime) {
        
        return null;
    }

    
    static public void main(String... args) {
        
        VoiceComposer vc = VoiceComposer
                .withEscapeDigits("1234")
                .streamFile("hello-world")
                .addSilence(1)
                .sayDate(new Date());
        
        
    }
}
