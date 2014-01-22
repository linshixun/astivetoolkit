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
public class QueueReloadAction extends ActionMessage {
  private String queue;
  private YesNo members;
  private YesNo parameters;
  private YesNo rules;

  /**
   * Creates a new QueueReloadAction object.
   */
  public QueueReloadAction() {
    super(ActionType.QUEUE_RELOAD);
    members = YesNo.NO;
    rules = YesNo.NO;
    parameters = YesNo.NO;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public YesNo getMembers() {
    return members;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public YesNo getParameters() {
    return parameters;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getQueue() {
    return queue;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public YesNo getRules() {
    return rules;
  }

  /**
   * DOCUMENT ME!
   *
   * @param members DOCUMENT ME!
   */
  public void setMembers(YesNo members) {
    this.members = members;
  }

  /**
   * DOCUMENT ME!
   *
   * @param parameters DOCUMENT ME!
   */
  public void setParameters(YesNo parameters) {
    this.parameters = parameters;
  }

  /**
   * DOCUMENT ME!
   *
   * @param queue DOCUMENT ME!
   */
  public void setQueue(String queue) {
    this.queue = queue;
  }

  /**
   * DOCUMENT ME!
   *
   * @param rules DOCUMENT ME!
   */
  public void setRules(YesNo rules) {
    this.rules = rules;
  }
}
