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
package com.phonytive.astive.ami.event;

import java.util.ArrayList;
import java.util.HashMap;

import com.phonytive.astive.ami.Message;
import com.phonytive.astive.ami.MessageType;
import com.phonytive.astive.ami.Privilege;

/**
 *
 * @since 1.0.0
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
