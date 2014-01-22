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
package org.astivetoolkit.ami.event;

import org.astivetoolkit.ami.Message;
import org.astivetoolkit.ami.MessageType;
import org.astivetoolkit.ami.Privilege;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @since 1.1
 */
public class EventMessage extends Message {
  private ArrayList<Privilege> privilege;
  private EventType event;

  /**
   * Creates a new EventMessage object.
   *
   * @param event DOCUMENT ME!
   */
  public EventMessage(EventType event) {
    super(MessageType.EVENT, event);
    this.event = event;
  }

  /**
   * Creates a new EventMessage object.
   *
   * @param event DOCUMENT ME!
   * @param parameters DOCUMENT ME!
   */
  public EventMessage(EventType event, HashMap parameters) {
    super(MessageType.EVENT, event, parameters);
    this.event = event;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public EventType getEventType() {
    return event;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public ArrayList<Privilege> getPrivilege() {
    String p = (String) getParams().get("Privilege");
    String[] parray = p.split(",");
    privilege = new ArrayList();

    for (int i = 0; i < parray.length; i++) {
      privilege.add(Privilege.valueOf(parray[i].toUpperCase()));
    }

    return privilege;
  }
}
