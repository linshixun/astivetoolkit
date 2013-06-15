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
package org.astivetoolkit.menu.event;


/**
 * A TimeoutEvent is triggered when the maximum time(as define in {@link Menu}) 
 * waiting for user iteration is reached.
 * 
 * @since 1.0.0
 * @see TimeoutListener
 */
public class TimeoutEvent extends DigitsEvent {
  private int timeout;

  /**
   * Create a new TimeoutEvent object.
   * 
   * @param source the object that originated the event.
   * @param digits the digits pressed.
   * @param maxTimeout maximum time waiting for user iteration.
   */
  public TimeoutEvent(final Object source, final String digit, final int timeout) {
    super(source, digit);
    this.timeout = timeout;
  }
  
  /**
   * Returns maximum time waiting for user iteration.
   * 
   * @return maximum time (as define in the {@link Menu}) waiting for user
   * iteration.
   */  
  public int getTimeout() {
    return timeout;
  }
}
