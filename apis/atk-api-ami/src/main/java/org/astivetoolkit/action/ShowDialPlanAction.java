/*
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.1
 */
public class ShowDialPlanAction extends ActionMessage {
  private String context;
  private String extension;

  /**
   * Creates a new ShowDialPlanAction object.
   */
  public ShowDialPlanAction() {
    super(ActionType.SHOW_DIAL_PLAN);
  }

  /**
   * Creates a new ShowDialPlanAction object.
   *
   * @param context DOCUMENT ME!
   */
  public ShowDialPlanAction(String context) {
    super(ActionType.SHOW_DIAL_PLAN);
    this.context = context;
  }

  /**
   * Creates a new ShowDialPlanAction object.
   *
   * @param context DOCUMENT ME!
   * @param extension DOCUMENT ME!
   */
  public ShowDialPlanAction(String context, String extension) {
    super(ActionType.SHOW_DIAL_PLAN);
    this.context = context;
    this.extension = extension;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getContext() {
    return context;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getExtension() {
    return extension;
  }

  /**
   * DOCUMENT ME!
   *
   * @param context DOCUMENT ME!
   */
  public void setContext(String context) {
    this.context = context;
  }

  /**
   * DOCUMENT ME!
   *
   * @param extension DOCUMENT ME!
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }
}
