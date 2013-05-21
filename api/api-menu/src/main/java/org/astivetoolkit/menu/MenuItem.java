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
  private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
  private ArrayList<AuthenticationListener> authenticationListenerList = new ArrayList<AuthenticationListener>();
  private ArrayList<DigitsListener> digitsListenerList = new ArrayList<DigitsListener>();
  private ArrayList<KeyListener> keyListenerList = new ArrayList<KeyListener>();
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
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addKeyListener(KeyListener listener) {
    keyListenerList.add(listener);
  }

  /**
   *
   * @param voiceComposition
   */
  public void addVoiceComposition(VoiceComposition voiceComposition) {
    voiceCompositionList.add(voiceComposition);
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireActionEventActionPerformed(ActionEvent evt) {
    for (ActionListener listener : actionListenerList) {
      listener.processAction(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireAuthenticationEventAuthenticationFail(AuthenticationEvent evt) {
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
   * @return DOCUMENT ME!
   */
  public List<VoiceComposition> getVoiceCompositions() {
    return Collections.unmodifiableList(voiceCompositionList);
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
   * @param voiceComposition DOCUMENT ME!
   */
  public void removeVoiceComposition(VoiceComposition voiceComposition) {
    voiceCompositionList.remove(voiceComposition);
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
   * @param parent DOCUMENT ME!
   */
  public void setParent(MenuItem parent) {
    this.parent = parent;
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
