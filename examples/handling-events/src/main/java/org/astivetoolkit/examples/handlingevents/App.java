/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.examples.handlingevents;

import static java.lang.System.out;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.astivlet.AstivletRequest;
import org.astivetoolkit.astivlet.AstivletResponse;
import org.astivetoolkit.menu.Menu;
import org.astivetoolkit.menu.MenuItem;
import org.astivetoolkit.menu.MenuNavigator;
import org.astivetoolkit.menu.event.*;

/**
 * Handling events example.
 *
 * @since 1.0
 */
public class App extends Astivlet {

    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        
        MenuItem menuItemA = new MenuItem("1", "menu-item-a-sound");
        menuItemA.addActionListener(new ActionListener() {

            @Override
            public void processAction(ActionEvent ae) {
                out.println("menuItem A selected");
            }
        });

        MenuItem menuItemB = new MenuItem("2", "menu-item-b-sound");
        menuItemB.addActionListener(new ActionListener() {

            @Override
            public void processAction(ActionEvent ae) {
                out.println("menuItem B selected");
            }
        });

        MenuItem menuItemC = new MenuItem("3", "menu-item-c-sound");
        menuItemC.addActionListener(new ActionListener() {

            @Override
            public void processAction(ActionEvent ae) {
                out.println("menuItem C selected");
            }
        });

        Menu root = new Menu();
        root.setMaxFailures(10);
        root.addPositionChangeListener(new PositionChangeListener() {

            @Override
            public void positionChange(PositionChangeEvent pce) {
                out.println("old obj digits = "
                        + ((MenuItem) pce.getSource()).getDigits());
                out.println("cur obj digits = "
                        + ((MenuItem) pce.getNewObject()).getDigits());
                out.println("cur pos = " + pce.getPosition());
            }
        });
        root.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent evt) {
                out.println("keyTyped = " + evt.getKey().name());
            }
        });
        root.addChild(menuItemA);
        root.addChild(menuItemB);
        root.addChild(menuItemC);

        out.print("response = ");
        out.println(response);

        MenuNavigator e = new MenuNavigator(response);

        try {
            e.run(root);
        } catch (AgiException ex) {
            out.println(ex.getMessage());
        }
    }
}
