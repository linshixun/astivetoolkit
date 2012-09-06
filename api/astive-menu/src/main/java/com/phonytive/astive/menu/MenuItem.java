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

import com.phonytive.astive.menu.action.Action;
import com.phonytive.astive.menu.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @since 1.0.0
 * @see Menu
 */
public class MenuItem {

    private Action action;
    private ArrayList<ActionListener> actionListenerList = new ArrayList();
    private ArrayList<AuthenticationListener> authenticationListenerList = new ArrayList();
    private ArrayList<DigitsListener> digitsListenerList = new ArrayList();
    private ArrayList<KeyListener> keyListenerList = new ArrayList();
    private Authenticator authenticator;
    /**
     * DOCUMENT ME!
     */
    protected MenuItem parent;
    private String digits;
    private String file;
    private boolean forgetAuthOnLeave = false;
    private boolean mustAuthenticate;
    private int priority;
    private List<VoiceComposition> voiceCompositionList;

    /**
     * <p>Creates a new instance of MenuItem</p>
     */
    public MenuItem() {
        voiceCompositionList = new ArrayList<VoiceComposition>();
    }

    /**
     * <p>Creates a new instance of MenuItem</p>
     */
    public MenuItem(String digits, String file) {        
        this.digits = digits;
        this.file = file;
        voiceCompositionList = new ArrayList<VoiceComposition>();
    }

    /**
     * <p>Creates a new instance of MenuItem</p>
     */
    public MenuItem(String digits, String file, Action action) {
        this.digits = digits;
        this.file = file;
        this.action = action;
        voiceCompositionList = new ArrayList<VoiceComposition>();
    }

    /**
     * <p>Creates a new instance of MenuItem</p>
     */
    public MenuItem(String digits, String file, Action action, int priority) {
        //this.parent = parent;
        this.digits = digits;
        this.file = file;
        this.action = action;
        this.priority = priority;
        voiceCompositionList = new ArrayList<VoiceComposition>();
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void addActionListener(ActionListener listener) {
        actionListenerList.add(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void addAuthenticationListener(AuthenticationListener listener) {
        authenticationListenerList.add(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void addDigitsListener(DigitsListener listener) {
        digitsListenerList.add(listener);
    }

    /**
     * 
     * @param voiceComposition 
     */
    public void addVoiceComposition(VoiceComposition voiceComposition) {
        voiceCompositionList.add(voiceComposition);        
    }
    
    public List<VoiceComposition> getVoiceCompositions() {
        return voiceCompositionList;
    }
    
    public void removeVoiceComposition(VoiceComposition voiceComposition) {
        voiceCompositionList.remove(voiceComposition);
    }
    
    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void addKeyListener(KeyListener listener) {
        keyListenerList.add(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    protected void fireActionEvent_actionPerformed(ActionEvent evt) {
        for (ActionListener listener : actionListenerList) {
            listener.processAction(evt);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    protected void fireAuthenticationEvent_authenticationFail(AuthenticationEvent evt) {
        for (AuthenticationListener listener : authenticationListenerList) {
            listener.authenticationFail(evt);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    protected void fireAuthenticationEvent_authenticationSuccess(AuthenticationEvent evt) {
        for (AuthenticationListener listener : authenticationListenerList) {
            listener.authenticationSuccess(evt);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    protected void fireAuthenticationEvent_tryingToAuthenticate(AuthenticationEvent evt) {
        for (AuthenticationListener listener : authenticationListenerList) {
            listener.tryingToAuthenticate(evt);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    protected void fireDigitsEvent_digitsEnter(DigitsEvent evt) {
        for (DigitsListener listener : digitsListenerList) {
            listener.digitsEnter(evt);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    protected void fireKeyEvent_keyTyped(KeyEvent evt) {
        for (KeyListener listener : keyListenerList) {
            listener.keyTyped(evt);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Action getAction() {
        return action;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getDigits() {
        return digits;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getFile() {
        return file;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean getForgetAuthOnLeave() {
        return forgetAuthOnLeave;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean getMustAuthenticate() {
        return mustAuthenticate;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent; 
    }
    
    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getPriority() {
        return priority;
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void removeActionListener(ActionListener listener) {
        actionListenerList.remove(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void removeAuthenticationListener(AuthenticationListener listener) {
        authenticationListenerList.remove(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void removeDigitListener(DigitsListener listener) {
        digitsListenerList.remove(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void removeKeyListener(KeyListener listener) {
        keyListenerList.remove(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param action DOCUMENT ME!
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * DOCUMENT ME!
     *
     * @param authenticator DOCUMENT ME!
     */
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    /**
     * DOCUMENT ME!
     *
     * @param digits DOCUMENT ME!
     */
    public void setDigits(String digits) {
        this.digits = digits;
    }

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * DOCUMENT ME!
     *
     * @param forgetAuthOnLeave DOCUMENT ME!
     */
    public void setForgetAuthOnLeave(boolean forgetAuthOnLeave) {
        this.forgetAuthOnLeave = forgetAuthOnLeave;
    }

    /**
     * DOCUMENT ME!
     *
     * @param mustAuthenticate DOCUMENT ME!
     */
    public void setMustAuthenticate(boolean mustAuthenticate) {
        this.mustAuthenticate = mustAuthenticate;
    }

    /**
     * DOCUMENT ME!
     *
     * @param priority DOCUMENT ME!
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
