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

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;
import com.phonytive.astive.agi.CommandProcessor;
import com.phonytive.astive.menu.action.Action;
import com.phonytive.astive.menu.event.*;
import java.util.*;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 */
public class MenuNavigator {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(MenuNavigator.class);
    private AgiResponse agiResponse;
    private Menu currentMenu;
    private boolean autoAnswer;
    private boolean answered;

    /**
     * Creates a new instance of MenuNavigator
     */
    public MenuNavigator(AgiResponse agiResponse) {
        this.agiResponse = agiResponse;
        autoAnswer = true;
        answered = false;
    }

    public MenuNavigator(AgiResponse agiResponse, boolean autoAnswer) {
        this.agiResponse = agiResponse;
        this.autoAnswer = autoAnswer;
        answered = false;
    }

    private void authenticate(MenuItem item) {
        if (item.getMustAuthenticate()) {
            if (!item.getAuthenticator().isAuthenticated()) {
                AuthenticationEvent evt = new AuthenticationEvent(item, item.getAuthenticator());
                item.fireAuthenticationEvent_tryingToAuthenticate(evt);
                item.getAuthenticator().signIn();

                if (item.getAuthenticator().isAuthenticated()) {
                    item.fireAuthenticationEvent_authenticationSuccess(null);
                } else {
                    item.fireAuthenticationEvent_authenticationFail(evt);
                }
            }
        }
    }

    private boolean checkMaxFailure(Menu menu, String opt) {
        if (menu.getFailuresCount() >= menu.getMaxFailures()) {
            MaxFailureEvent event = new MaxFailureEvent(menu, opt, menu.getMaxFailures());
            menu.fireMaxFailureEvent_maxFailurePerform(event);

            // do break the flow
            return true;
        }

        return false;
    }

    private boolean checkMaxTimeout(Menu menu, String opt) {
        if (menu.getTimeoutCount() >= menu.getMaxTimeouts()) {
            MaxTimeoutEvent event = new MaxTimeoutEvent(menu, opt, menu.getMaxTimeouts());
            menu.fireMaxTimeoutEvent_maxTimeoutPerform(event);

            // do break the flow
            return true;
        }

        return false;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    private Menu getCurrentMenu() {
        return currentMenu;
    }

    private String getData(String file, int milliSecondsWatting, int maxDigits,
            AgiResponse agiResponse, MenuItem item, char c)
            throws MenuException, AgiException {
        
        Menu menu;
        
        System.out.println("DBG 1");
        
        if(item.getParent() != null) {
            System.out.println("DBG 2");
            menu = ((Menu) item.getParent());
        } else {
            System.out.println("DBG 3");
            menu = getCurrentMenu();
        }

        // Has not press any key
        if(c == 0x0) {
            System.out.println("DBG 4");
            c = agiResponse.streamFile(file, "0123456789*#");

            if (c == 0x0 /*
                    * && milliSecondsWatting == 0
                    */) {
                System.out.println("DBG 6");
                try {
                    Thread.sleep(milliSecondsWatting);
                } catch (InterruptedException ex) {
                    logger.warn(ex.getMessage());
                }
                return "(timeout)";
            }
        
        } else {
            System.out.println("DBG 5");
            System.out.println("menu.getInterDigitsTimeout() = " 
                    + menu.getInterDigitsTimeout());
            c = agiResponse.waitForDigit(menu.getInterDigitsTimeout());
        }
        
        KeyEvent evt = new KeyEvent(item, Digit.getDigit(c));
        item.fireKeyEvent_keyTyped(evt);

        System.out.println("DBG 7");
        
        String result = "" + c;

        while (true) {
            if ((result.length() == maxDigits) || (c == '#')) {
                System.out.println("DBG 8");
                return result;
            }

            c = agiResponse.waitForDigit(menu.getInterDigitsTimeout());

            if (c != 0x0) {
                System.out.println("DBG 9");
                result += ("" + c);
                evt = new KeyEvent(item, Digit.getDigit(c));
                item.fireKeyEvent_keyTyped(evt);
            } else {
                System.out.println("DBG 10");
                InterDigitsTimeoutEvent event =
                        new InterDigitsTimeoutEvent(item, result, menu.getInterDigitsTimeout());
                menu.fireInterDigitsTimeoutListener_timeoutPerform(event);

                break;
            }
        }
        System.out.println("DBG 11");

        return result;
    }

    private MenuItem getMenuItem(Menu menu, String digits) {
        for (MenuItem item : menu.getChilds()) {
            if (item.getDigits().equals(digits)) {
                return item;
            }
        }
        return null;
    }

    // XXX: Im not sure about this criteria
    private ArrayList<String> getSortedChildsKeys(ArrayList<MenuItem> menuChilds) {
        ArrayList result = new ArrayList();
        Comparator comparator =
                new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        int c1 = ((MenuItem) o1).getPriority();
                        int c2 = ((MenuItem) o2).getPriority();

                        return (new Integer(c1)).compareTo(new Integer(c2));
                    }
                ;
        };

        Object[] opts = new Object[menuChilds.size()];
        int cnt = 0;

        for (MenuItem child : menuChilds) {
            opts[cnt++] = child;
        }

        // Sorting the items
        Arrays.sort(opts, comparator);

        for (int i = 0; i < opts.length; i++) {
            String digits = ((MenuItem) opts[i]).getDigits();
            result.add(digits);
        }

        return result;
    }

    private ArrayList<String> getChildsKeys(ArrayList<MenuItem> menuChilds) {
        ArrayList result = new ArrayList();
        for (MenuItem child : menuChilds) {
            String digits = ((MenuItem) child).getDigits();
            result.add(digits);
        }                        
        return result;
    }
    
    /**
     * <p>Start the menu execution.</p>
     *
     * @param menu and object containing all menu and menu items.
     */
    public void run(Menu menu) throws MenuException, AgiException {
        String digits = null;
        setCurrentMenu(menu);
        
        // For example if channel is closed by customer the player must be auto-halt.    
        if (agiResponse.getChannelStatus().getCode() == -1) {
            return;
        }

        if (answered == false && isAutoAnswer() == true) {
            agiResponse.answer();
            answered = true;
        }
        
        ArrayList<String> childsKeys;
                
        // Sort elements
        if(!menu.isSortChildsByDigits()) {
            childsKeys = getChildsKeys(menu.getChilds());
        } else {
            childsKeys = getSortedChildsKeys(menu.getChilds());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Total menu options: " + menu.getChilds().size());
        }

        if (((menu.isGreetingsPlayed() == false) || menu.isPlayGreetingsAllways())
                && (menu.getGreetingsFile() != null) && !menu.getGreetingsFile().isEmpty()) {
            if (logger.isDebugEnabled()) {
                logger.debug("Playing menu intro: " + menu.getGreetingsFile());
            }
            char c = 0x0;
            digits = getData(menu.getGreetingsFile(), 0, menu.getMaxDigits(), agiResponse, menu, c);
            menu.setGreetingsPlayed(true);
        }

        if ((digits == null) || digits.equals("(timeout)")) {
            List<VoiceComposition> voiceCompositions = menu.getVoiceCompositions();
            Iterator<VoiceComposition> vcIterator = voiceCompositions.iterator();
            char c = 0;
            while(vcIterator.hasNext()) {
                VoiceComposition cVc = vcIterator.next();
                Iterator<Object> commands = cVc.getCommands().iterator();                
                while(commands.hasNext()) {
                    Object o = commands.next();                                        
                    String cmd = CommandProcessor.buildCommand(o);
                    c = agiResponse.sendAgiCommand(cmd).getResultCodeAsChar();
                    if(c != 0x0) {
                        KeyEvent evt = new KeyEvent(menu, Digit.getDigit(c));
                        menu.fireKeyEvent_keyTyped(evt);
                        
                        digits = getData(menu.getFile(), 0, 
                                menu.getMaxDigits(), agiResponse, menu, c);
                        break;
                    }
                }                
                if (c != 0x0) {
                    break;
                }
            }
        }

        if ((digits == null) || digits.equals("(timeout)")) {
            if (logger.isDebugEnabled()) {
                logger.debug("Playing menu options");
            }

            int pos = 0;            
            
            for (String opts : childsKeys) {
                MenuItem option = getMenuItem(menu, opts);
                int millisecondsWatting = menu.getInterDigitsTimeout();

                if (((menu.getChilds().size() - 1) >= 0)
                        && menu.getChilds().get(menu.getChilds().size() - 1).equals(option)) {
                    millisecondsWatting = menu.getLastDigitsTimeout();
                }

                if ((digits == null) || digits.equals("(timeout)")) {
                    // Waiting time in between the item file and digits item file.
                    int msw;

                    msw = millisecondsWatting;
                    
                    if(!option.getFile().isEmpty()) {
                        char c = 0x0;
                        digits = getData(option.getFile(), msw, menu.getMaxDigits(), agiResponse,
                            menu, c);
                    }                                    
                }

                if ((digits != null) && !digits.equals("(timeout)")) {
                    // Do break menu            
                    if (logger.isDebugEnabled()) {
                        logger.debug("Enter digits is: " + digits);
                    }

                    DigitsEvent evt = new DigitsEvent((Object) option, digits);
                    option.fireDigitsEvent_digitsEnter(evt);
                }

                MenuItem oldOption = option;

                if (pos > 0) {
                    oldOption = getMenuItem(menu, childsKeys.get(pos - 1));
                }

                PositionChangeEvent evt = new PositionChangeEvent(oldOption, option, pos - 1);
                menu.firePositionChangeEvent_positionChange(evt);
                pos++;

                if (logger.isDebugEnabled()) {
                    logger.debug("pos = " + pos);
                }
            }
        }

        // Selected none option
        if ((digits == null) || digits.equals("(timeout)")) {
            // XXX: No necesariamente timeout, puede ser tambien que ingreso
            // ???
            // signo de número.            
            if (digits == null) {
                FailEvent evt = new FailEvent(menu, digits, menu.getFailuresCount());
                menu.fireFailListener_failurePerform(evt);
            } else if (digits.equals("(timeout)")) {
                // WARNNING:
                //menu.fireTimeoutListener_timeoutPerform(null);
            }

            // Try again
            if (logger.isDebugEnabled()) {
                logger.debug("Unregistered option");
            }

            menu.incrementFailuresCount();

            if (!checkMaxFailure(menu, digits) && !checkMaxTimeout(menu, digits)) {
                run(menu);                
                return;
            }

            if(menu.getExitFile() != null && !menu.getExitFile().isEmpty()) {
                agiResponse.streamFile(menu.getExitFile());
            }

            return;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Getting Menu/MenuItem for digits: " + digits);
        }

        MenuItem selectedOption = getMenuItem(menu, digits);

        if (selectedOption != null) {
            menu.resetFailuresCount();
            menu.resetTimeoutCount();

            Action action = selectedOption.getAction();

            if (action != null) {
                authenticate(selectedOption);
                selectedOption.getAction().doAction();
            }

            ActionEvent evt = new ActionEvent(selectedOption, digits);
            selectedOption.fireActionEvent_actionPerformed(evt);

            if (selectedOption instanceof Menu) {
                run((Menu) selectedOption);
            } else {
                run(menu);
            }

            return;
        } else {            
            // Invalid option
            agiResponse.streamFile(menu.getInvalidDigitFile());
            menu.incrementFailuresCount();

            if (!checkMaxFailure(menu, digits) && !checkMaxTimeout(menu, digits)) {
                run(menu);
                return;
            }

            agiResponse.streamFile(menu.getExitFile());
            return;
        }        
    }

    private void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void setAutoAnswer(boolean autoAnswer) {
        this.autoAnswer = autoAnswer;
    }

    private Boolean isAutoAnswer() {
        return autoAnswer;
    }    
}
