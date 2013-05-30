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

import java.util.ArrayList;
import org.astivetoolkit.menu.action.Action;
import org.astivetoolkit.menu.event.FailEvent;
import org.astivetoolkit.menu.event.InterDigitsTimeoutListener;
import org.astivetoolkit.menu.event.FailListener;
import org.astivetoolkit.menu.event.PositionChangeListener;
import org.astivetoolkit.menu.event.MaxTimeoutEvent;
import org.astivetoolkit.menu.event.MaxFailureListener;
import org.astivetoolkit.menu.event.MaxFailureEvent;
import org.astivetoolkit.menu.event.TimeoutEvent;
import org.astivetoolkit.menu.event.InterDigitsTimeoutEvent;
import org.astivetoolkit.menu.event.PositionChangeEvent;
import org.astivetoolkit.menu.event.MaxTimeoutListener;
import org.astivetoolkit.menu.event.TimeoutListener;

/**
 *
 * @since 1.0.0
 * @see MenuItem
 */
public class Menu extends MenuItem {
  private ArrayList<MenuItem> childs = new ArrayList<>();
  private ArrayList<FailListener> failListenerList = new ArrayList<>();
  private ArrayList<InterDigitsTimeoutListener> interDigitsTimeoutListenerList = new ArrayList<>();
  private ArrayList<MaxFailureListener> maxFailureListenerList = new ArrayList<>();
  private ArrayList<MaxTimeoutListener> maxTimeoutListenerList = new ArrayList<>();
  private ArrayList<PositionChangeListener> positionChangeListenerList = new ArrayList<>();
  private ArrayList<TimeoutListener> timeoutListenerList = new ArrayList<>();
  private String exitFile;
  private String greetingsFile;
  private String invalidDigitFile;
  private boolean canInterruptGreetings = true;
  private boolean greetingsPlayed = false;
  private boolean playGreetingsAllways = false;
  private boolean sortChildsByDigits;
  private int failuresCount;
  private int interDigitsTimeout = 500;
  private int lastDigitsTimeout = 1500;
  private int maxDigits = 1;
  private int maxFailures = 3;
  private int maxTimeouts = 3;

  //private int timeout;
  private int timeoutCount;

    public Menu() {
    super();
    }

  public Menu(final String digits, final String file) {
    super(digits, file);
  }

  public Menu(final String digits, final String file, final Action action) {
    super(digits, file, action);
  }
  
  public Menu(String digits, String file, Action action, int priority) {
    super(digits, file, action, priority);
  }

  public void addChild(MenuItem item) {
    item.parent = this;
    childs.add(item);
  }

  public void addFailListener(FailListener listener) {
    failListenerList.add(listener);
  }

  public void addInterDigitTimeoutListener(InterDigitsTimeoutListener listener) {
    interDigitsTimeoutListenerList.add(listener);
  }

  public void addMaxFailureListener(MaxFailureListener listener) {
    maxFailureListenerList.add(listener);
  }

  public void addMaxTimeoutListener(MaxTimeoutListener listener) {
    maxTimeoutListenerList.add(listener);
  }

  public void addPositionChangeListener(PositionChangeListener listener) {
    positionChangeListenerList.add(listener);
  }

  public void addTimeoutListener(TimeoutListener listener) {
    timeoutListenerList.add(listener);
  }

  protected void checkDigits(String digits) {
    for (MenuItem m : getChilds()) {
      if (m.getDigits().equals(digits)) {
        throw new DuplicatedDigitsException();
      }
    }
  }

  protected void fireFailListenerFailurePerform(FailEvent evt) {
    for (FailListener listener : failListenerList) {
      listener.failurePerform(evt);
    }
  }

  protected void fireInterDigitsTimeoutListener_timeoutPerform(InterDigitsTimeoutEvent evt) {
    for (InterDigitsTimeoutListener listener : interDigitsTimeoutListenerList) {
      listener.timeoutPerform(evt);
    }
  }

  protected void fireMaxFailureEvent_maxFailurePerform(MaxFailureEvent evt) {
    for (MaxFailureListener listener : maxFailureListenerList) {
      listener.maxFailurePerform(evt);
    }
  }

  protected void fireMaxTimeoutEventMaxTimeoutPerform(MaxTimeoutEvent evt) {
    for (MaxTimeoutListener listener : maxTimeoutListenerList) {
      listener.maxTimeoutPerform(evt);
    }
  }
 
  protected void firePositionChangeEventPositionChange(PositionChangeEvent evt) {
    for (PositionChangeListener listener : positionChangeListenerList) {
      listener.positionChange(evt);
    }
  }

  protected void fireTimeoutListenerTimeoutPerform(TimeoutEvent evt) {
    for (TimeoutListener listener : timeoutListenerList) {
      listener.timeoutPerform(evt);
    }
  }

  public ArrayList<MenuItem> getChilds() {
    return childs;
  }

  public String getExitFile() {
    return exitFile;
  }

  protected int getFailuresCount() {
    return failuresCount;
  }

  public String getGreetingsFile() {
    return greetingsFile;
  }

  public int getInterDigitsTimeout() {
    return interDigitsTimeout;
  }

  public String getInvalidDigitFile() {
    return invalidDigitFile;
  }

  public int getLastDigitsTimeout() {
    return lastDigitsTimeout;
  }
 
  public int getMaxDigits() {
    return maxDigits;
  }

  public int getMaxFailures() {
    return maxFailures;
  }

  protected int getMaxTimeouts() {
    return maxTimeouts;
  }

  protected int getTimeoutCount() {
    return timeoutCount;
  }

  protected void incremenTimeoutCount() {
    setTimeoutCount(getTimeoutCount() + 1);
  }
  
  protected void incrementFailuresCount() {
    setFailuresCount(getFailuresCount() + 1);
  }

  public boolean isCanInterruptGreetings() {
    return canInterruptGreetings;
  }
  
  public boolean isGreetingsPlayed() {
    return greetingsPlayed;
  }
 
  public boolean isPlayGreetingsAllways() {
    return playGreetingsAllways;
  }
 
  public boolean isSortChildsByDigits() {
    return sortChildsByDigits;
  }

  public void removeInterDigitsTimeoutListener(InterDigitsTimeoutListener listener) {
    interDigitsTimeoutListenerList.remove(listener);
  }

  public void removeMaxFailureListener(MaxFailureListener listener) {
    maxFailureListenerList.remove(listener);
  }

  public void removeMaxTimeoutListener(MaxTimeoutListener listener) {
    maxTimeoutListenerList.remove(listener);
  }

  public void removePositionChangeListener(PositionChangeListener listener) {
    positionChangeListenerList.remove(listener);
  }

  public void removeTimeoutListener(TimeoutListener listener) {
    timeoutListenerList.remove(listener);
  }

  public void removeTimeoutListener(FailListener listener) {
    failListenerList.remove(listener);
  }

  public void resetFailuresCount() {
    setFailuresCount(0);
  }

  public void resetTimeoutCount() {
    setTimeoutCount(0);
  }

  public void setCanInterruptGreetings(boolean canInterruptGreetings) {
    this.canInterruptGreetings = canInterruptGreetings;
  }

  public void setChilds(ArrayList<MenuItem> childs) {
    this.childs = childs;
  }

  public void setExitFile(String exitFile) {
    this.exitFile = exitFile;
  }

  public void setFailuresCount(int failuresCount) {
    this.failuresCount = failuresCount;
  }

  public void setGreetingsFile(String greetingsFile) {
    this.greetingsFile = greetingsFile;
  }

  protected void setGreetingsPlayed(boolean greetingsPlayed) {
    this.greetingsPlayed = greetingsPlayed;
  }

  public void setInterDigitsTimeout(int interDigitsTimeout) {
    this.interDigitsTimeout = interDigitsTimeout;
  }

  public void setInvalidDigitFile(String invalidDigitFile) {
    this.invalidDigitFile = invalidDigitFile;
  }

  public void setLastDigitsTimeout(int lastDigitsTimeout) {
    this.lastDigitsTimeout = lastDigitsTimeout;
  }

  public void setMaxDigits(int maxDigits) {
    this.maxDigits = maxDigits;
  }

  public void setMaxFailures(int maxFailures) {
    this.maxFailures = maxFailures;
  }

  public void setMaxTimeouts(int maxTimeouts) {
    this.maxTimeouts = maxTimeouts;
  }

  public void setPlayGreetingsAllways(boolean playGreetingsAllways) {
    this.playGreetingsAllways = playGreetingsAllways;
  }

  public void setSortChildsByDigits(boolean sortChildsByDigits) {
    this.sortChildsByDigits = sortChildsByDigits;
  }

  protected void setTimeoutCount(int timeoutCount) {
    this.timeoutCount = timeoutCount;
  }
}
