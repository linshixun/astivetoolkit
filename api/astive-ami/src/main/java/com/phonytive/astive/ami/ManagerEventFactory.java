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
package com.phonytive.astive.ami;

import com.phonytive.astive.ami.event.EventType;
import com.phonytive.astive.ami.event.ManagerEvent;
import com.phonytive.astive.util.AppLocale;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 */
public class ManagerEventFactory {
  private static final Logger LOG = Logger.getLogger(MessageHandler.class);
  private static ManagerEventFactory INSTANCE = new ManagerEventFactory();

  private ManagerEventFactory() {
  }

  /**
   * DOCUMENT ME!
   *
   * @param source DOCUMENT ME!
   * @param msg DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public ManagerEvent getEvent(Object source, Message msg) {
    LOG.warn(AppLocale.getI18n("unknownEvent",
                                  new Object[] { msg.getMessageLines().get(0x0), msg.toString() }));

    return new ManagerEvent(source, EventType.UNKNOWN, msg.getParams());
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static ManagerEventFactory getInstance() {
    return INSTANCE;
  }

  // TODO: Implemente a "create" method for each event type
}
