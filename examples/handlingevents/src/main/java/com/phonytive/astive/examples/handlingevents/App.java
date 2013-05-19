/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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
package com.phonytive.astive.examples.handlingevents;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.menu.Engine;
import com.phonytive.astive.menu.Menu;
import com.phonytive.astive.menu.MenuItem;
import com.phonytive.astive.menu.event.*;
import com.phonytive.astive.menu.exception.MenuException;
import static java.lang.System.out;

/**
 * Handling events sample.
 *
 * @since 1.0.0
 */
public class App extends Astivlet {

    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        
        @Say(function=SayFunction.DATE, gender=Gender.FEMALE)
        MenuItem menuItemA = new MenuItem("1", "menu-item-b-sound");
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

        Engine e = new Engine(response);

        try {
            e.run(root);
        } catch (MenuException ex) {
            out.println(ex.getMessage());
        } catch (AgiException ex) {
            out.println(ex.getMessage());
        }
    }
}
