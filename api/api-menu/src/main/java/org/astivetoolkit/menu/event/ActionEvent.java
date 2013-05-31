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
 *
 * @since 1.0.0
 * @see Action
 * @see ActionListener
 */
public class ActionEvent {
  private Object source;
  private String digits;

  /**
   * Creates a new ActionEvent object.
   */
  public ActionEvent(Object source, String digits) {
    this.source = source;
    this.digits = digits;
  }

  /**
   * @return the digits
   */
  public String getDigits() {
    return digits;
  }

  /**
   * @return the source
   */
  public Object getSource() {
    return source;
  }

  /**
   * @param digits the digits to set
   */
  public void setDigits(String digits) {
    this.digits = digits;
  }

  /**
   * @param source the source to set
   */
  public void setSource(Object source) {
    this.source = source;
  }
}
