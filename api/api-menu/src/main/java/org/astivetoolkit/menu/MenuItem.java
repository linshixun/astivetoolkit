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
package org.astivetoolkit.menu;

import org.astivetoolkit.menu.event.AuthenticationListener;
import org.astivetoolkit.menu.event.KeyListener;
import org.astivetoolkit.menu.event.ActionListener;
import org.astivetoolkit.menu.event.DigitsListener;
import org.astivetoolkit.menu.event.AuthenticationEvent;
import org.astivetoolkit.menu.event.KeyEvent;
import org.astivetoolkit.menu.event.ActionEvent;
import org.astivetoolkit.menu.event.DigitsEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.astivetoolkit.menu.action.Action;

/**
 *
 * @since 1.0.0
 * @see Menu
 */
public class MenuItem {
  private Action action;
  private ArrayList<ActionListener> actionListenerList = new ArrayList<>();
  private ArrayList<AuthenticationListener> authenticationListenerList = new ArrayList<>();
  private ArrayList<DigitsListener> digitsListenerList = new ArrayList<>();
  private ArrayList<KeyListener> keyListenerList = new ArrayList<>();
  private Authenticator authenticator;
  private List<VoiceComposition> voiceCompositionList;

  /**
   * DOCUMENT ME!
   */
  protected MenuItem parent;
  private String digits;
  private String file;
  private boolean forgetAuthOnLeave = false;
  private boolean mustAuthenticate;
  private int priority;

  public MenuItem() {
    voiceCompositionList = new ArrayList<VoiceComposition>();
  }

  public MenuItem(String digits, String file) {
    this.digits = digits;
    this.file = file;
    voiceCompositionList = new ArrayList<VoiceComposition>();
  }
  
  public MenuItem(String digits, String file, Action action) {
    this.digits = digits;
    this.file = file;
    this.action = action;
    voiceCompositionList = new ArrayList<VoiceComposition>();
  }
  
  public MenuItem(String digits, String file, Action action, int priority) {
    this.digits = digits;
    this.file = file;
    this.action = action;
    this.priority = priority;
    voiceCompositionList = new ArrayList<VoiceComposition>();
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

  public void addVoiceComposition(VoiceComposition voiceComposition) {
    voiceCompositionList.add(voiceComposition);
  }

  protected void fireActionEventActionPerformed(ActionEvent evt) {
    for (ActionListener listener : actionListenerList) {
      listener.processAction(evt);
    }
  }

  protected void fireAuthenticationEventAuthenticationFail(AuthenticationEvent evt) {
    for (AuthenticationListener listener : authenticationListenerList) {
      listener.authenticationFail(evt);
    }
  }

  protected void fireAuthenticationEvent_authenticationSuccess(AuthenticationEvent evt) {
    for (AuthenticationListener listener : authenticationListenerList) {
      listener.authenticationSuccess(evt);
    }
  }

  protected void fireAuthenticationEvent_tryingToAuthenticate(AuthenticationEvent evt) {
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

  public List<VoiceComposition> getVoiceCompositions() {
    return Collections.unmodifiableList(voiceCompositionList);
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

  public void removeVoiceComposition(VoiceComposition voiceComposition) {
    voiceCompositionList.remove(voiceComposition);
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

  public void setFile(String file) {
    this.file = file;
  }

  public void setForgetAuthOnLeave(boolean forgetAuthOnLeave) {
    this.forgetAuthOnLeave = forgetAuthOnLeave;
  }

  public void setMustAuthenticate(boolean mustAuthenticate) {
    this.mustAuthenticate = mustAuthenticate;
  }

  public void setParent(MenuItem parent) {
    this.parent = parent;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }
}
