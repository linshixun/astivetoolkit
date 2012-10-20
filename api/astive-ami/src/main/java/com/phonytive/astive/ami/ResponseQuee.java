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

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.phonytive.astive.util.AppLocale;

/**
 * 
 * @since 1.0.0 
 */
public class ResponseQuee {
  private static final Logger logger = Logger.getLogger(ResponseQuee.class);
  private static HashMap<String, Message> responseQuee = new HashMap();

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isEmpty() {
    return responseQuee.isEmpty();
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean messageExist(String key) {
    return responseQuee.containsKey(key);
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  public Message pullMessage(String key) throws AmiException {
    if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("pullingMessageFromQuee", new Object[] { key }));
        }

    Message msg = responseQuee.get(key);
    responseQuee.remove(key);

    return msg;
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   * @param message DOCUMENT ME!
   */
  public void pushMessage(String key, Message message) {
    if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("pushingMessageToQuee", new Object[] { key }));
        }

    responseQuee.put(key, message);
  }
}
