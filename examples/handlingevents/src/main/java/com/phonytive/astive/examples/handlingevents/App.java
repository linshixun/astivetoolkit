package com.phonytive.astive.examples.handlingevents;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.menu.Engine;
import com.phonytive.astive.menu.Menu;
import com.phonytive.astive.menu.exception.MenuException;
import com.phonytive.astive.menu.MenuItem;
import com.phonytive.astive.menu.event.ActionEvent;
import com.phonytive.astive.menu.event.ActionListener;
import com.phonytive.astive.menu.event.KeyEvent;
import com.phonytive.astive.menu.event.KeyListener;
import com.phonytive.astive.menu.event.PositionChangeEvent;
import com.phonytive.astive.menu.event.PositionChangeListener;

/**
 * <p>Handling events sample</p>
 *
 */
public class App implements Astivlet {

    @Override
    public void onModuleLoad(AstivletRequest request, AstivletResponse response) {

        MenuItem menuItemA = new MenuItem("1", "menu-item-a-sound");
        menuItemA.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                System.out.println("menuItem A selected");
            }
        });

        MenuItem menuItemB = new MenuItem("2", "menu-item-b-sound");
        menuItemB.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                System.out.println("menuItem B selected");
            }
        });

        MenuItem menuItemC = new MenuItem("3", "menu-item-c-sound");
        menuItemC.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                System.out.println("menuItem C selected");
            }
        });

        Menu root = new Menu();
        root.setMaxFailures(10);
        root.addPositionChangeListener(new PositionChangeListener() {

            public void positionChange(PositionChangeEvent pce) {
                System.out.println("old obj digits = "
                        + ((MenuItem) pce.getSource()).getDigits());
                System.out.println("cur obj digits = "
                        + ((MenuItem) pce.getNewObject()).getDigits());
                System.out.println("cur pos = " + pce.getPosition());
            }
        });
        root.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent evt) {
                System.out.println("keyTyped = " + evt.getKey().name());
            }
        });
        root.addChild(menuItemA);
        root.addChild(menuItemB);
        root.addChild(menuItemC);

        Engine e = new Engine(response);
        try {
            e.run(root);
        } catch (MenuException ex) {
        } catch (AgiException ex) {
        }
    }
}
