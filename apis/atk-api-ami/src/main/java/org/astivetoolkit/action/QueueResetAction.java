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
package org.astivetoolkit.action;


/**
 *
 * @since 1.1
 */
public class QueueResetAction extends ActionMessage {
  private String queue;

  /**
   * Creates a new QueueResetAction object.
   */
  public QueueResetAction() {
    super(ActionType.QUEUE_RESET);
  }

  /**
   * Creates a new QueueResetAction object.
   *
   * @param queue DOCUMENT ME!
   */
  public QueueResetAction(String queue) {
    super(ActionType.QUEUE_RESET);
    this.queue = queue;
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
   * @param queue DOCUMENT ME!
   */
  public void setQueue(String queue) {
    this.queue = queue;
  }
}
