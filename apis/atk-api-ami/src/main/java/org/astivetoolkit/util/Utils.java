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
package org.astivetoolkit.ami.util;

import java.util.ArrayList;

import org.astivetoolkit.ami.MessageType;
import org.astivetoolkit.ami.ResponseStatus;
import org.astivetoolkit.ami.action.ActionType;
import org.astivetoolkit.ami.event.EventType;

/**
 *
 * @since 1.1
 */
public class Utils {

  /**
   * DOCUMENT ME!
   *
   * @param actionTypeStr DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static ActionType getActionType(String actionTypeStr) {
    StringBuilder b = new StringBuilder();
    String[] s = splitOnCapitals(actionTypeStr);

    for (int i = 0; i < s.length; i++) {
      b.append(s[i]);

      if (i < (s.length - 1)) {
        b.append("_");
      }
    }

    return ActionType.valueOf(b.toString().toUpperCase());
  }

  /**
   * DOCUMENT ME!
   *
   * @param actionType DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static String getActionType(ActionType actionType) {
    String s = joinCapitals(actionType.toString().split("_"));

    return s;
  }

  /**
   * DOCUMENT ME!
   *
   * @param eventTypeStr DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static EventType getEventType(String eventTypeStr) {
    StringBuilder b = new StringBuilder();
    String[] s = splitOnCapitals(eventTypeStr);

    for (int i = 0; i < s.length; i++) {
      b.append(s[i]);

      if (i < (s.length - 1)) {
        b.append("_");
      }
    }

    return EventType.valueOf(b.toString().toUpperCase());
  }

  /**
   * DOCUMENT ME!
   *
   * @param eventType DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static String getEventType(EventType eventType) {
    String s = joinCapitals(eventType.toString().split("_"));

    return s;
  }

  /**
   * DOCUMENT ME!
   *
   * @param messageTypeStr DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static MessageType getMessageType(String messageTypeStr) {
    return MessageType.valueOf(messageTypeStr.toUpperCase());
  }

  /**
   * DOCUMENT ME!
   *
   * @param messageType DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static String getMessageType(MessageType messageType) {
    return capitalizeFirstLetters(messageType.toString().replace("_", ""));
  }

  /**
   * DOCUMENT ME!
   *
   * @param actionTypeStr DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static ResponseStatus getResponseStatus(String actionTypeStr) {
    return ResponseStatus.valueOf(actionTypeStr.toUpperCase());
  }

  /**
   * DOCUMENT ME!
   *
   * @param responseStatus DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static String getResponseStatus(ResponseStatus responseStatus) {
    return capitalizeFirstLetters(responseStatus.toString().replace("_", "").toLowerCase());
  }

  // TODO: Move this to a most general util
  private static String capitalizeFirstLetters(String s) {
    s = s.toLowerCase();

    for (int i = 0; i < s.length(); i++) {
      if (i == 0) {
        // Capitalize the first letter of the string.
        s = String.format("%s%s", Character.toUpperCase(s.charAt(0)), s.substring(1));
      }
    }

    return s;
  }  
  
  /**
   * DOCUMENT ME!
   *
   * @param str DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static String joinCapitals(String[] str) {
    StringBuilder b = new StringBuilder();

    for (int i = 0; i < str.length; i++) {
      b.append(capitalizeFirstLetters(str[i]));
    }

    return b.toString();
  }

  /**
   * DOCUMENT ME!
   *
   * @param str DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static String[] splitOnCapitals(String str) {
    ArrayList<String> array = new ArrayList<String>();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      if (Character.isUpperCase(str.charAt(i))) {
        String line = builder.toString().trim();

        if (line.length() > 0) {
          array.add(line);
        }

        builder = new StringBuilder();
      }

      builder.append(str.charAt(i));
    }

    array.add(builder.toString().trim()); // get the last little bit too

    return array.toArray(new String[0]);
  }
}
