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

import org.astivetoolkit.menu.Digit;

/**
 *
 * @since 1.0.0
 * @see KeyListener
 */
public class KeyEvent extends Event {
  /**
   * DOCUMENT ME!
   */
  protected Digit key;

  /**
   * Creates a new KeyEvent object.
   *
   * @param source DOCUMENT ME!
   * @param key DOCUMENT ME!
   */
  public KeyEvent(Object source, Digit key) {
    super(source);
    this.source = source;
    this.key = key;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Digit getKey() {
    return key;
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   */
  public void setKey(Digit key) {
    this.key = key;
  }
}
