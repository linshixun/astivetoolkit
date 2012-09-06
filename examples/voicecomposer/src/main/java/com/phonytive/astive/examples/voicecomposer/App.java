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
package com.phonytive.astive.examples.voicecomposer;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.menu.*;
import com.phonytive.astive.menu.event.DigitsEvent;
import com.phonytive.astive.menu.event.DigitsListener;
import com.phonytive.astive.menu.event.KeyEvent;
import com.phonytive.astive.menu.event.KeyListener;
import static java.lang.System.out;
import java.util.Date;
import java.util.TimeZone;

/**
 * VoiceComposer example.
 *
 * @since 1.0.0
 */
public class App extends Astivlet {

    @Override
    public void service(AstivletRequest request, AstivletResponse response) {

        Date today = new Date();
        VoiceComposition vc = VoiceComposer
                .withEscapeDigits("12345")                
                .withTimeZone(TimeZone.getDefault())
                .streamFile("date")
                .streamFile("is")                                
                .addSilence(1)
                .sayDate(today)
                .addSilence(1)
                .withEscapeDigits("")
                .streamFile("new-york")
                .sayAlpha("newyork").create();
        
        Menu m = new Menu();
        m.setGreetingsFile("welcome");
        m.setMaxDigits(3);
        m.addVoiceComposition(vc);
        m.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent evt) {
                out.print("Key: ");
                out.println(evt.getKey());
            }
        });
                
        MenuNavigator mn = new MenuNavigator(response);
        
        try {
            mn.run(m);
        } catch (MenuException ex) {            
        } catch (AgiException ex) {
        }
    }
}
