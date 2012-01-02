// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//w
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.menu;

import com.phonytive.astive.menu.action.Action;
import com.phonytive.astive.menu.core.Authenticator;
import com.phonytive.astive.menu.event.ActionEvent;
import com.phonytive.astive.menu.event.ActionListener;
import com.phonytive.astive.menu.event.AuthenticationEvent;
import com.phonytive.astive.menu.event.AuthenticationListener;
import com.phonytive.astive.menu.event.DigitsEvent;
import com.phonytive.astive.menu.event.DigitsListener;
import com.phonytive.astive.menu.event.KeyEvent;
import com.phonytive.astive.menu.event.KeyListener;

import java.util.ArrayList;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $id$
 * @see Menu
 */
public class MenuItem {
    private Action action;
    private ArrayList<ActionListener> actionListenerList = new ArrayList();
    private ArrayList<AuthenticationListener> authenticationListenerList = new ArrayList();
    private ArrayList<DigitsListener> digitsListenerList = new ArrayList();
    private ArrayList<KeyListener> keyListenerList = new ArrayList();
    private Authenticator authenticator;
    protected MenuItem parent;
    private String digits;
    private String digitsFile;
    private String file;
    private boolean forgetAuthOnLeave = false;
    private boolean mustAuthenticate;
    private int priority;

    /** <p>Creates a new instance of MenuItem</p> */
    public MenuItem() {
    }

    /** <p>Creates a new instance of MenuItem</p> */
    public MenuItem(String digits, String file) {
        //this.parent = parent;
        this.digits = digits;
        this.file = file;
    }

    /** <p>Creates a new instance of MenuItem</p> */
    public MenuItem(String digits, String file, Action action) {
        //this.parent = parent;
        this.digits = digits;
        this.file = file;
        this.action = action;
    }

    /** <p>Creates a new instance of MenuItem</p> */
    public MenuItem(String digits, String file, Action action, int priority) {
        //this.parent = parent;
        this.digits = digits;
        this.file = file;
        this.action = action;
        this.priority = priority;
    }

    public void addActionListener(ActionListener listener) {
        actionListenerList.add(listener);
    }

    public void addAuthenticationListener(AuthenticationListener listener) {
        authenticationListenerList.add(listener);
    }

    public void addDigitsListener(DigitsListener listener) {
        digitsListenerList.add(listener);
    }

    public void addKeyListener(KeyListener listener) {
        keyListenerList.add(listener);
    }

    protected void fireActionEvent_actionPerformed(ActionEvent evt) {
        for (ActionListener listener : actionListenerList) {
            listener.processAction(evt);
        }
    }

    protected void fireAuthenticationEvent_authenticationFail(
        AuthenticationEvent evt) {
        for (AuthenticationListener listener : authenticationListenerList) {
            listener.authenticationFail(evt);
        }
    }

    protected void fireAuthenticationEvent_authenticationSuccess(
        AuthenticationEvent evt) {
        for (AuthenticationListener listener : authenticationListenerList) {
            listener.authenticationSuccess(evt);
        }
    }

    protected void fireAuthenticationEvent_tryingToAuthenticate(
        AuthenticationEvent evt) {
        for (AuthenticationListener listener : authenticationListenerList) {
            listener.tryingToAuthenticate(evt);
        }
    }

    protected void fireDigitsEvent_digitsEnter(DigitsEvent evt) {
        for (DigitsListener listener : digitsListenerList) {
            listener.digitsEnter(evt);
        }
    }

    protected void fireKeyEvent_keyTyped(KeyEvent evt) {
        for (KeyListener listener : keyListenerList) {
            listener.keyTyped(evt);
        }
    }

    public Action getAction() {
        return action;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public String getDigits() {
        return digits;
    }

    public String getDigitsFile() {
        return digitsFile;
    }

    public String getFile() {
        return file;
    }

    public boolean getForgetAuthOnLeave() {
        return forgetAuthOnLeave;
    }

    public boolean getMustAuthenticate() {
        return mustAuthenticate;
    }

    public MenuItem getParent() {
        return parent;
    }

    public int getPriority() {
        return priority;
    }

    public void removeActionListener(ActionListener listener) {
        actionListenerList.remove(listener);
    }

    public void removeAuthenticationListener(AuthenticationListener listener) {
        authenticationListenerList.remove(listener);
    }

    public void removeDigitListener(DigitsListener listener) {
        digitsListenerList.remove(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListenerList.remove(listener);
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public void setDigitsFile(String digitsFile) {
        this.digitsFile = digitsFile;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setForgetAuthOnLeave(boolean forgetAuthOnLeave) {
        this.forgetAuthOnLeave = forgetAuthOnLeave;
    }

    public void setMustAuthenticate(boolean mustAuthenticate) {
        this.mustAuthenticate = mustAuthenticate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
