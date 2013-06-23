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
import org.astivetoolkit.menu.event.FailureListener;
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
  private ArrayList<FailureListener> failListenerList = new ArrayList<>();
  private ArrayList<InterDigitsTimeoutListener> interDigitsTimeoutListenerList = new ArrayList<>();
  private ArrayList<MaxFailureListener> maxFailureListenerList = new ArrayList<>();
  private ArrayList<MaxTimeoutListener> maxTimeoutListenerList = new ArrayList<>();
  private ArrayList<PositionChangeListener> positionChangeListenerList = new ArrayList<>();
  private ArrayList<TimeoutListener> timeoutListenerList = new ArrayList<>();
  private String exitFile;
  private String greetingsFile;
  private String invalidDigitsFile;
  private boolean canInterruptGreetings = true;
  private boolean greetingsPlayed = false;
  private boolean playGreetingsAllways = false;
  private boolean sortChildsByDigits = true;
  private int failuresCount;
  private int interDigitsTimeout = 500;
  private int lastDigitsTimeout = 1500;
  private int maxDigits = 1;
  private int maxFailures = 3;
  private int maxTimeouts = 3;  
  private int timeoutCount;

  /**
   * {@inheritDoc}
   */
  public Menu() {
    super();
  }

  /**
   * {@inheritDoc}
   */  
  public Menu(final String digits, final String file) {
    super(digits, file);
  }

  /**
   * {@inheritDoc}
   */  
  public Menu(final String digits, final String file, final Action action) {
    super(digits, file, action);
  }
  
  /**
   * {@inheritDoc}
   */  
  public Menu(final String digits, final String file, final Action action,
          final int priority) {
    super(digits, file, action, priority);
  }

  /**
   * Registers a new menu item to this menu.
   * 
   * @param item the new menu item.
   */
  public void addChild(MenuItem item) {
    item.parent = this;
    childs.add(item);
  }

  /**
   * Registers the specified fail listener to receive fail events from this 
   * <code>menu</code>.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */
  public void addFailListener(FailureListener listener) {
    failListenerList.add(listener);
  }

  /**
   * Registers the specified integer digit timeout listener to receive inter 
   * digits events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void addInterDigitsTimeoutListener(InterDigitsTimeoutListener listener) {
    interDigitsTimeoutListenerList.add(listener);
  }

  /**
   * Registers the specified max failure listener to receive max failure events 
   * from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */    
  public void addMaxFailureListener(MaxFailureListener listener) {
    maxFailureListenerList.add(listener);
  }

  /**
   * Registers the specified max timeout listener to receive max timeout events 
   * from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void addMaxTimeoutListener(MaxTimeoutListener listener) {
    maxTimeoutListenerList.add(listener);
  }

  /**
   * Registers the specified position change listener to receive position change
   * events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */
  public void addPositionChangeListener(PositionChangeListener listener) {
    positionChangeListenerList.add(listener);
  }

  /**
   * Registers the specified timeout listener to receive position timeout
   * events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void addTimeoutListener(TimeoutListener listener) {
    timeoutListenerList.add(listener);
  }

  /**
   * Returns an array of all the child's registered on this menu.
   * 
   * @return all of this menu child's or an empty array if no voice compositions 
   * are currently registered.
   */  
  public ArrayList<MenuItem> getChilds() {
    return childs;
  }

  /**
   * Returns the goodbye file.
   * 
   * @return the <code>file</code> to be stream, without extension.
   */
  public String getExitFile() {
    return exitFile;
  }
 
  /**
   * Returns the greetings file.
   * 
   * @return the <code>file</code> to be streamed, without extension.
   */
  public String getGreetingsFile() {
    return greetingsFile;
  }

  /**
   * Returns the maximum time in between digits.
   * 
   * @return the maximum time allow in between digits.
   */
  public int getInterDigitsTimeout() {
    return interDigitsTimeout;
  }

  /**
   * Returns the file the system stream if an invalid digits is typed.
   * 
   * @return the <code>file</code> to be streamed, without extension.
   */
  public String getInvalidDigitsFile() {
    return invalidDigitsFile;
  }

  /**
   * Returns the maximum timeout for the last menu item in the menu.
   * 
   * @return the maximum time that a <code>Subject</code> have to press the
   * digits, before the file for the last menu item finish.
   */
  public int getLastDigitsTimeout() {
    return lastDigitsTimeout;
  }
 
  /**
   * Returns the maximum digits allow for menu items in this menu.
   * 
   * @return maximum digits for menu items.
   */
  public int getMaxDigits() {
    return maxDigits;
  }

  /**
   * Returns the maximum failure that a <code>Subject</code> is allow to.
   * 
   * @return the maximum time that a <code>Subject</code>(user) is allow to
   * introduce wrong digits.
   */
  public int getMaxFailures() {
    return maxFailures;
  }

  /**
   * Returns whether or not the greetings can be interrupted by user iteration.
   * 
   * @return true if the greetings can be skipped.
   */
  public boolean isCanInterruptGreetings() {
    return canInterruptGreetings;
  }
  
  /**
   * Whether or not the greetings has been played.
   * 
   * @return true if greetings was played already.
   */
  public boolean isGreetingsPlayed() {
    return greetingsPlayed;
  }
 
  /**
   * Whether or not greetings will be played every time.
   * 
   * @return true if greetings will be played every time.
   */
  public boolean isPlayGreetingsAllways() {
    return playGreetingsAllways;
  }
 
  /**
   * Indicates if child will be sort using the digits as criteria.
   * 
   * @return true if menu items will be sorted.
   */
  public boolean isSortChildsByDigits() {
    return sortChildsByDigits;
  }

  /**
   * Removes the specified inter digits listener so it no longer receives 
   * inter digits events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */
  public void removeInterDigitsTimeoutListener(InterDigitsTimeoutListener listener) {
    interDigitsTimeoutListenerList.remove(listener);
  }

  /**
   * Removes the specified max failure listener so it no longer receives 
   * max failure events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */
  public void removeMaxFailureListener(MaxFailureListener listener) {
    maxFailureListenerList.remove(listener);
  }

  /**
   * Removes the specified max timeout listener so it no longer receives 
   * max timeout events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void removeMaxTimeoutListener(MaxTimeoutListener listener) {
    maxTimeoutListenerList.remove(listener);
  }

  /**
   * Removes the specified max failure listener so it no longer receives 
   * max failure events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void removePositionChangeListener(PositionChangeListener listener) {
    positionChangeListenerList.remove(listener);
  }

  /**
   * Removes the specified timeout listener so it no longer receives timeout 
   * events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void removeTimeoutListener(TimeoutListener listener) {
    timeoutListenerList.remove(listener);
  }

  /**
   * Removes the specified failure listener so it no longer receives failure 
   * events from this menu.
   * 
   * @param listener the object that receives a notification when an event of 
   * the specified type occurs.
   */  
  public void removeFailureListener(FailureListener listener) {
    failListenerList.remove(listener);
  }

  /**
   * Restarts the the failures count, to prevent {@link MaxFailureEvent}.
   */
  public void resetFailuresCount() {
    setFailuresCount(0);
  }

  /**
   * Restarts the timeout count, to prevent {@link MaxTimeoutEvent}.
   */
  public void resetTimeoutCount() {
    setTimeoutCount(0);
  }

  /**
   * Establish whether or not the greetings maybe interrupt by user iteration.
   * 
   * @param canInterruptGreetings 'true' will allow users to skip the greetings.
   */
  public void setCanInterruptGreetings(boolean canInterruptGreetings) {
    this.canInterruptGreetings = canInterruptGreetings;
  }
 
  /**
   * Register multiple menu items into a menu at the same time.
   * 
   * @param childs all of this menu child's or an empty array if no voice 
   * compositions are currently registered.
   */
  public void setChilds(ArrayList<MenuItem> childs) {
    this.childs = childs;
  }

  /**
   * Establish the goodbye sound.
   * 
   * @param exitFile the file extension must not be included in the filename.
   */
  public void setExitFile(String exitFile) {
    this.exitFile = exitFile;
  }

  /**
   * Establish the greetings sound.
   * 
   * @param greetingsFile the file extension must not be included in the filename.
   */  
  public void setGreetingsFile(String greetingsFile) {
    this.greetingsFile = greetingsFile;
  }

  /**
   * Establish the maximum time allow in between digits.
   * 
   * @param interDigitsTimeout the maximum time allow in between digits.
   */
  public void setInterDigitsTimeout(int interDigitsTimeout) {
    this.interDigitsTimeout = interDigitsTimeout;
  }

  /**
   * Establish the file to stream if invalid digits are introduce by a 
   * <code>Subject</code>.
   * 
   * @param greetingsFile the file extension must not be included in the filename.
   */    
  public void setInvalidDigitFile(String invalidDigitFile) {
    this.invalidDigitsFile = invalidDigitFile;
  }

  /**
   * Establish maximum time waiting for user interaction.
   * 
   * @param lastDigitsTimeout the maximum time waiting for user interaction 
   * after the audio of last menu item finish.
   */
  public void setLastDigitsTimeout(int lastDigitsTimeout) {
    this.lastDigitsTimeout = lastDigitsTimeout;
  }

  /**
   * Maximum digits length for menu items.
   * 
   * @param maxDigits maximum length.
   */
  public void setMaxDigits(int maxDigits) {
    this.maxDigits = maxDigits;
  }

  /**
   * Defines the maximum amount failures that a <code>Subject</code> is allow.
   * 
   * @param maxFailures the maximum amount of time that user is allow to select 
   * an option that is not part of this menu.
   */
  public void setMaxFailures(int maxFailures) {
    this.maxFailures = maxFailures;
  }

  /**
   * Defines the maximum amount timeouts that a <code>Subject</code> is allow.
   * 
   * @param maxFailures the maximum amount of time that user is allow to skip
   * menu item selection.
   */  
  public void setMaxTimeouts(int maxTimeouts) {
    this.maxTimeouts = maxTimeouts;
  }

  /**
   * Whether or not greetings will be played every time.
   * 
   * @param playGreetingsAllways by default is set to false.
   */
  public void setPlayGreetingsAllways(boolean playGreetingsAllways) {
    this.playGreetingsAllways = playGreetingsAllways;
  }

  /**
   * Whether or not will sort menu items by its digits.
   * 
   * @param sortChildsByDigits is true by default.
   */
  public void setSortChildsByDigits(boolean sortChildsByDigits) {
    this.sortChildsByDigits = sortChildsByDigits;
  }

  /**
   * Returns the maximum timeout
   * 
   * @return the maximum consecutive timeouts that a <code>Subject</code> is
   * allow.
   */
  public int getMaxTimeouts() {
    return maxTimeouts;
  }

  /**
   * Returns the current timeout count.
   * 
   * @return the number of consecutive timeouts.
   */
  protected int getTimeoutCount() {
    return timeoutCount;
  }

  /**
   * Use by {@link MenuNavigator} to increment the consecutive timeout count.
   */
  protected void incremenTimeoutCount() {
    setTimeoutCount(getTimeoutCount() + 1);
  }

  /**
   * Use by {@link MenuNavigator} to increment the consecutive failures count.
   */  
  protected void incrementFailuresCount() {
    setFailuresCount(getFailuresCount() + 1);
  }  
  
  private void setTimeoutCount(int timeoutCount) {
    this.timeoutCount = timeoutCount;
  }
  
  /**
   * Checks for duplicate digits in menu items.
   * 
   * @param digits if there is any digit duplicated, the exception 
   * {@link DuplicateDigitException} is thrown.
   */
  protected void checkDigits(String digits) {
    for (MenuItem m : getChilds()) {
      if (m.getDigits().equals(digits)) {
        throw new DuplicatedDigitException();
      }
    }
  }

  /**
   * Notifies failure listeners about a failure event.
   * 
   * @param evt the event.
   */ 
  protected void fireFailureListener_failurePerform(FailEvent evt) {
    for (FailureListener listener : failListenerList) {
      listener.failurePerform(evt);
    }
  }

  /**
   * Notifies inter digits timeout listeners about an inter digits timeout event.
   * 
   * @param evt the event.
   */   
  protected void fireInterDigitsTimeoutListener_timeoutPerform(InterDigitsTimeoutEvent evt) {
    for (InterDigitsTimeoutListener listener : interDigitsTimeoutListenerList) {
      listener.timeoutPerform(evt);
    }
  }

  /**
   * Notifies inter digits timeout listeners about an inter digits timeout event.
   * 
   * @param evt the event.
   */  
  protected void fireMaxFailureEvent_maxFailurePerform(MaxFailureEvent evt) {
    for (MaxFailureListener listener : maxFailureListenerList) {
      listener.maxFailurePerform(evt);
    }
  }

  /**
   * Notifies max timeout listeners about a max timeout event.
   * 
   * @param evt the event.
   */
  protected void fireMaxTimeoutEvent_maxTimeoutPerform(MaxTimeoutEvent evt) {
    for (MaxTimeoutListener listener : maxTimeoutListenerList) {
      listener.maxTimeoutPerform(evt);
    }
  }

  /**
   * Notifies position change listeners about a position change event.
   * 
   * @param evt the event.
   */  
  protected void firePositionChangeEvent_positionChange(PositionChangeEvent evt) {
    for (PositionChangeListener listener : positionChangeListenerList) {
      listener.positionChange(evt);
    }
  }

  /**
   * Notifies timeout listeners about a timeout event.
   * 
   * @param evt the event.
   */  
  protected void fireTimeoutListener_timeoutPerform(TimeoutEvent evt) {
    for (TimeoutListener listener : timeoutListenerList) {
      listener.timeoutPerform(evt);
    }
  }  

  /**
   * Returns the current failures count.
   * 
   * @return use by {@link MenuNavigator} to perform {@link MaxFailuresEvent}.
   */
  protected int getFailuresCount() {
    return failuresCount;
  }  
  
  private void setFailuresCount(int failuresCount) {
    this.failuresCount = failuresCount;
  }  

  /**
   * Sets the greetings played.
   * 
   * @param greetingsPlayed use by {@link MenuNavigator} to avoid greetings 
   * repetition unless is the desire behavior.
   */
  protected void setGreetingsPlayed(boolean greetingsPlayed) {
    this.greetingsPlayed = greetingsPlayed;
  }  
}
