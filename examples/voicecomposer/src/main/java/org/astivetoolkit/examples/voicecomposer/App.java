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
package org.astivetoolkit.examples.voicecomposer;

import static java.lang.System.out;
import java.util.Date;
import java.util.TimeZone;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.astivlet.AstivletRequest;
import org.astivetoolkit.astivlet.AstivletResponse;
import org.astivetoolkit.menu.*;
import org.astivetoolkit.menu.event.DigitsEvent;
import org.astivetoolkit.menu.event.DigitsListener;
import org.astivetoolkit.menu.event.KeyEvent;
import org.astivetoolkit.menu.event.KeyListener;

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
        m.setInterDigitsTimeout(1000);
        m.addVoiceComposition(vc);
        m.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent evt) {
                out.print("Key: ");
                out.println(evt.getKey());
            }
        });
        
        m.addDigitsListener(new DigitsListener() {

            @Override
            public void digitsEnter(DigitsEvent evt) {
                out.print("Digits: ");
                out.println(evt.getDigits());                
            }
        });
                
        MenuNavigator mn = new MenuNavigator(response);
        
        try {
            mn.run(m);
        } catch (AgiException ex) {
            out.println(ex.getMessage());
        }
    }
}
