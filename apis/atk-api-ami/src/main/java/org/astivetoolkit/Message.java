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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.astivetoolkit.action.ActionType;
import org.astivetoolkit.event.EventType;
import org.astivetoolkit.util.AppLocale;
import org.astivetoolkit.util.Utils;

/**
 *
 * @since 1.1
 */
public class Message {
  public static final String SEPARATOR = ": ";
  private Enum<?> subType;
  private HashMap<String, String> params;
  private MessageType type;

  public Message(MessageType type, Enum<?> subType) {
    this.type = type;
    this.subType = subType;
    params = new HashMap<String, String>();
  }

  public Message(MessageType type, Enum<?> subType, HashMap<String, String> params) {
    this.type = type;
    this.subType = subType;
    this.params = params;
  }

  public Message(ArrayList<String> lines) throws AmiException {
    String messageType = lines.get(0).split(SEPARATOR)[0];
    String messageSubType = lines.get(0).split(SEPARATOR)[1];
    type = Utils.getMessageType(messageType);

    if (type.equals(MessageType.ACTION)) {
      subType = Utils.getMessageType(messageSubType);
    } else if (type.equals(MessageType.EVENT)) {
      // Convert messageSubType as it come from Asterisk into
      // the enum(capitalize) with the dashes(_) before exec the valueOf
      subType = Utils.getEventType(messageSubType);
    } else if (type.equals(MessageType.RESPONSE)) {
      subType = Utils.getResponseStatus(messageSubType);
    } else {
      // TODO: Include a message with this exception
      throw new AmiException(AppLocale.getI18n("unknownActionType"));
    }

    params = new HashMap<String, String>();

    for (int i = 1; i < lines.size(); i++) {
      String k = lines.get(i).split(SEPARATOR)[0];
      String v = lines.get(i).split(SEPARATOR)[1];
      params.put(k, v);
    }
  }

  public void addParameter(String key, String value) {
    params.put(key, value);
  }

  public ArrayList<String> getMessageLines() {
    ArrayList<String> lines = new ArrayList<String>();
    // First line
    lines.add(getType() + SEPARATOR + getSubType());

    Iterator<?> i = getParams().keySet().iterator();

    while (i.hasNext()) {
      String k = (String) i.next();
      String line = k + SEPARATOR + getParams().get(k);
      lines.add(line);
    }

    return lines;
  }

  public String getParameter(String key) {
    return params.get(key);
  }

  public HashMap<String, String> getParams() {
    return params;
  }


  public Enum<?> getSubType() {
    return subType;
  }

  public MessageType getType() {
    return type;
  }

  public void setParams(HashMap<String, String> params) {
    this.params = params;
  }


  public void setSubType(Enum<?> subType) {
    this.subType = subType;
  }

  public void setType(MessageType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();

    // Capitalize
    String messageType = Utils.getMessageType(type);
    String messageSubType = null;

    if (type.equals(MessageType.ACTION)) {
      ActionType aType = ActionType.valueOf(subType.toString());
      messageSubType = Utils.getActionType(aType);
    } else if (type.equals(MessageType.EVENT)) {
      EventType eType = EventType.valueOf(subType.toString());
      messageSubType = Utils.getEventType(eType);
    } else if (type.equals(MessageType.RESPONSE)) {
      ResponseStatus rType = ResponseStatus.valueOf(subType.toString());
      messageSubType = Utils.getResponseStatus(rType);
    } else {
      // Epic fail !
    }

    // Adding header #1
    b.append(messageType);
    b.append(SEPARATOR);
    b.append(messageSubType);
    b.append("\n");

    if (!getParams().isEmpty()) {
      Iterator<?> i = getParams().keySet().iterator();

      while (i.hasNext()) {
        String k = (String) i.next();
        b.append(k);
        b.append(SEPARATOR);
        b.append(getParams().get(k));
        b.append("\n");
      }
    }

    return b.toString();
  }
}
