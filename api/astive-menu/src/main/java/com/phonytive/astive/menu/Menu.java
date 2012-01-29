/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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

import java.util.ArrayList;

import com.phonytive.astive.menu.action.Action;
import com.phonytive.astive.menu.event.FailEvent;
import com.phonytive.astive.menu.event.FailListener;
import com.phonytive.astive.menu.event.InterDigitsTimeoutEvent;
import com.phonytive.astive.menu.event.InterDigitsTimeoutListener;
import com.phonytive.astive.menu.event.MaxFailureEvent;
import com.phonytive.astive.menu.event.MaxFailureListener;
import com.phonytive.astive.menu.event.MaxTimeoutEvent;
import com.phonytive.astive.menu.event.MaxTimeoutListener;
import com.phonytive.astive.menu.event.PositionChangeEvent;
import com.phonytive.astive.menu.event.PositionChangeListener;
import com.phonytive.astive.menu.event.TimeoutEvent;
import com.phonytive.astive.menu.event.TimeoutListener;

/**
 *
 * @since 1.0.0
 * @see MenuItem
 */
public class Menu extends MenuItem {
  private ArrayList<MenuItem> childs = new ArrayList();
  private ArrayList<FailListener> failListenerList = new ArrayList();
  private ArrayList<InterDigitsTimeoutListener> interDigitsTimeoutListenerList = new ArrayList();
  private ArrayList<MaxFailureListener> maxFailureListenerList = new ArrayList();
  private ArrayList<MaxTimeoutListener> maxTimeoutListenerList = new ArrayList();
  private ArrayList<PositionChangeListener> positionChangeListenerList = new ArrayList();
  private ArrayList<TimeoutListener> timeoutListenerList = new ArrayList();
  private String exitFile;
  private String greetingsFile;
  private String invalidDigitFile;
  private boolean canInterruptGreetings = true;
  private boolean greetingsPlayed = false;
  private boolean playGreetingsAllways = false;
  private int failuresCount;
  private int interDigitsTimeout = 500;
  private int lastDigitsTimeout = 1500;
  private int maxDigits = 1;
  private int maxFailures = 3;
  private int maxTimeouts = 3;

  //private int timeout;
  private int timeoutCount;

  /** <p>Creates a new instance of Menu</p> */
  public Menu() {
  }

  /** <p>Creates a new instance of Menu</p> */
  public Menu(String digits, String file) {
    super(digits, file);
  }

  /** <p>Creates a new instance of Menu</p> */
  public Menu(String digits, String file, Action action) {
    super(digits, file, action);
  }

  /**
   * Creates a new Menu object.
   *
   * @param digit DOCUMENT ME!
   * @param file DOCUMENT ME!
   * @param action DOCUMENT ME!
   * @param priority DOCUMENT ME!
   */
  public Menu(String digits, String file, Action action, int priority) {
    super(digits, file, action, priority);
  }

  /**
   * DOCUMENT ME!
   *
   * @param item DOCUMENT ME!
   */
  public void addChild(MenuItem item) {
    item.parent = this;
    childs.add(item);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addFailListener(FailListener listener) {
    failListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addInterDigitTimeoutListener(InterDigitsTimeoutListener listener) {
    interDigitsTimeoutListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addMaxFailureListener(MaxFailureListener listener) {
    maxFailureListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addMaxTimeoutListener(MaxTimeoutListener listener) {
    maxTimeoutListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addPositionChangeListener(PositionChangeListener listener) {
    positionChangeListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addTimeoutListener(TimeoutListener listener) {
    timeoutListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param digits DOCUMENT ME!
   */
  public void checkDigits(String digits) {
    for (MenuItem m : getChilds()) {
      if (m.getDigits().equals(digits)) {
        throw new DuplicatedDigitsException();
      }
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireFailListener_failurePerform(FailEvent evt) {
    for (FailListener listener : failListenerList) {
      listener.failurePerform(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireInterDigitsTimeoutListener_timeoutPerform(InterDigitsTimeoutEvent evt) {
    for (InterDigitsTimeoutListener listener : interDigitsTimeoutListenerList) {
      listener.timeoutPerform(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireMaxFailureEvent_maxFailurePerform(MaxFailureEvent evt) {
    for (MaxFailureListener listener : maxFailureListenerList) {
      listener.maxFailurePerform(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireMaxTimeoutEvent_maxTimeoutPerform(MaxTimeoutEvent evt) {
    for (MaxTimeoutListener listener : maxTimeoutListenerList) {
      listener.maxTimeoutPerform(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void firePositionChangeEvent_positionChange(PositionChangeEvent evt) {
    for (PositionChangeListener listener : positionChangeListenerList) {
      listener.positionChange(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireTimeoutListener_timeoutPerform(TimeoutEvent evt) {
    for (TimeoutListener listener : timeoutListenerList) {
      listener.timeoutPerform(evt);
    }
  }

  /**
   * @return the childs
   */
  public ArrayList<MenuItem> getChilds() {
    return childs;
  }

  /**
   * @return the exitFile
   */
  public String getExitFile() {
    return exitFile;
  }

  /**
   * @return the failuresCount
   */
  public int getFailuresCount() {
    return failuresCount;
  }

  /**
   * @return the greetingsFile
   */
  public String getGreetingsFile() {
    return greetingsFile;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getInterDigitsTimeout() {
    return interDigitsTimeout;
  }

  /**
   * @return the invalidDigitFile
   */
  public String getInvalidDigitFile() {
    return invalidDigitFile;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getLastDigitsTimeout() {
    return lastDigitsTimeout;
  }

  /**
   * @return the maxDigits
   */
  public int getMaxDigits() {
    return maxDigits;
  }

  /**
   * @return the maxFailures
   */
  public int getMaxFailures() {
    return maxFailures;
  }

  /**
   * @return the maxTimeouts
   */
  public int getMaxTimeouts() {
    return maxTimeouts;
  }

  /**
   * @return the timeout
   */

  //public int getTimeout() {
  //  return timeout;
  //}

  /**
   * @return the timeoutCount
   */
  public int getTimeoutCount() {
    return timeoutCount;
  }

  /**
   * DOCUMENT ME!
   */
  public void incremenTimeoutCount() {
    setTimeoutCount(getTimeoutCount() + 1);
  }

  /**
   * DOCUMENT ME!
   */
  public void incrementFailuresCount() {
    setFailuresCount(getFailuresCount() + 1);
  }

  /**
   * @return the canInterruptGreetings
   */
  public boolean isCanInterruptGreetings() {
    return canInterruptGreetings;
  }

  /**
   * @return the greetingsPlayed
   */
  public boolean isGreetingsPlayed() {
    return greetingsPlayed;
  }

  /**
   * @return the playGreetingsAllways
   */
  public boolean isPlayGreetingsAllways() {
    return playGreetingsAllways;
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removeInterDigitsTimeoutListener(InterDigitsTimeoutListener listener) {
    interDigitsTimeoutListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removeMaxFailureListener(MaxFailureListener listener) {
    maxFailureListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removeMaxTimeoutListener(MaxTimeoutListener listener) {
    maxTimeoutListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removePositionChangeListener(PositionChangeListener listener) {
    positionChangeListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removeTimeoutListener(TimeoutListener listener) {
    timeoutListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removeTimeoutListener(FailListener listener) {
    failListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   */
  public void resetFailuresCount() {
    setFailuresCount(0);
  }

  /**
   * DOCUMENT ME!
   */
  public void resetTimeoutCount() {
    setTimeoutCount(0);
  }

  /**
   * @param canInterruptGreetings the canInterruptGreetings to set
   */
  public void setCanInterruptGreetings(boolean canInterruptGreetings) {
    this.canInterruptGreetings = canInterruptGreetings;
  }

  /**
   * @param childs the childs to set
   */
  public void setChilds(ArrayList<MenuItem> childs) {
    this.childs = childs;
  }

  /**
   * @param exitFile the exitFile to set
   */
  public void setExitFile(String exitFile) {
    this.exitFile = exitFile;
  }

  /**
   * @param failuresCount the failuresCount to set
   */
  public void setFailuresCount(int failuresCount) {
    this.failuresCount = failuresCount;
  }

  /**
   * @param greetingsFile the greetingsFile to set
   */
  public void setGreetingsFile(String greetingsFile) {
    this.greetingsFile = greetingsFile;
  }

  /**
   * @param greetingsPlayed the greetingsPlayed to set
   */
  public void setGreetingsPlayed(boolean greetingsPlayed) {
    this.greetingsPlayed = greetingsPlayed;
  }

  /**
   * DOCUMENT ME!
   *
   * @param interDigitsTimeout DOCUMENT ME!
   */
  public void setInterDigitsTimeout(int interDigitsTimeout) {
    this.interDigitsTimeout = interDigitsTimeout;
  }

  /**
   * @param invalidDigitFile the invalidDigitFile to set
   */
  public void setInvalidDigitFile(String invalidDigitFile) {
    this.invalidDigitFile = invalidDigitFile;
  }

  /**
   * DOCUMENT ME!
   *
   * @param lastDigitsTimeout DOCUMENT ME!
   */
  public void setLastDigitsTimeout(int lastDigitsTimeout) {
    this.lastDigitsTimeout = lastDigitsTimeout;
  }

  /**
   * @param maxDigits the maxDigits to set
   */
  public void setMaxDigits(int maxDigits) {
    this.maxDigits = maxDigits;
  }

  /**
   * @param maxFailures the maxFailures to set
   */
  public void setMaxFailures(int maxFailures) {
    this.maxFailures = maxFailures;
  }

  /**
   * @param maxTimeouts the maxTimeouts to set
   */
  public void setMaxTimeouts(int maxTimeouts) {
    this.maxTimeouts = maxTimeouts;
  }

  /**
   * @param playGreetingsAllways the playGreetingsAllways to set
   */
  public void setPlayGreetingsAllways(boolean playGreetingsAllways) {
    this.playGreetingsAllways = playGreetingsAllways;
  }

  /**
   * @param timeout the timeout to set
   */

  //public void setTimeout(int timeout) {
  //  this.timeout = timeout;
  //}
  public void setTimeoutCount(int timeoutCount) {
    this.timeoutCount = timeoutCount;
  }
}
