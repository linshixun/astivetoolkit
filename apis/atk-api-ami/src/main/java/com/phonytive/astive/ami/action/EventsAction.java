/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
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
package com.phonytive.astive.ami.action;


/**
 *
 * @since 1.0.0
 */
public class EventsAction extends ActionMessage {
  private String eventMask;

  /**
   * Creates a new EventsAction object.
   *
   * @param eventMask DOCUMENT ME!
   */
  public EventsAction(String eventMask) {
    super(ActionType.EVENTS);
    this.eventMask = eventMask;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getEventMask() {
    return eventMask;
  }

  /**
   * DOCUMENT ME!
   *
   * @param eventMask DOCUMENT ME!
   */
  public void setEventMask(String eventMask) {
    this.eventMask = eventMask;
  }
}
