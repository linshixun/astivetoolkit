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
package org.astivetoolkit;

import java.util.HashMap;
import org.apache.log4j.Logger;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.1
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
    if (logger.isDebugEnabled())
      logger.debug(AppLocale.getI18n("pullingMessageFromQuee", new Object[] { key }));

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
    if (logger.isDebugEnabled())
      logger.debug(AppLocale.getI18n("pushingMessageToQuee", new Object[] { key }));

    responseQuee.put(key, message);
  }
}
