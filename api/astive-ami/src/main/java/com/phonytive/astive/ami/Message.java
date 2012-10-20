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

import com.phonytive.astive.ami.action.ActionType;
import com.phonytive.astive.ami.event.EventType;
import com.phonytive.astive.ami.util.Utils;
import com.phonytive.astive.util.AppLocale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 *
 * @since 1.0.0
 */
public class Message {
  public static final String SEPARATOR = ": ";
  private Enum subType;
  private HashMap<String, String> params;
  private MessageType type;
  private Pattern p = Pattern.compile("");

  /**
   * Creates a new Message object.
   *
   * @param type DOCUMENT ME!
   * @param subType DOCUMENT ME!
   */
  public Message(MessageType type, Enum subType) {
    this.type = type;
    this.subType = subType;
    params = new HashMap();
  }

  /**
   * Creates a new Message object.
   *
   * @param type DOCUMENT ME!
   * @param subType DOCUMENT ME!
   * @param params DOCUMENT ME!
   */
  public Message(MessageType type, Enum subType, HashMap<String, String> params) {
    this.type = type;
    this.subType = subType;
    this.params = params;
  }

  /**
   * Creates a new Message object.
   *
   * @param lines DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  public Message(ArrayList<String> lines) throws AmiException {
    String messageType = lines.get(0x0).split(SEPARATOR)[0x0];
    String messageSubType = lines.get(0x0).split(SEPARATOR)[0x1];
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

    params = new HashMap();

    for (int i = 0x1; i < lines.size(); i++) {
      String k = lines.get(i).split(SEPARATOR)[0x0];
      String v = lines.get(i).split(SEPARATOR)[0x1];
      params.put(k, v);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public void addParameter(String key, String value) {
    params.put(key, value);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public ArrayList<String> getMessageLines() {
    ArrayList<String> lines = new ArrayList();
    // First line
    lines.add(getType() + SEPARATOR + getSubType());

    Iterator i = getParams().keySet().iterator();

    while (i.hasNext()) {
      String k = (String) i.next();
      String line = k + SEPARATOR + getParams().get(k);
      lines.add(line);
    }

    return lines;
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getParameter(String key) {
    return params.get(key);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public HashMap<String, String> getParams() {
    return params;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Enum getSubType() {
    return subType;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public MessageType getType() {
    return type;
  }

  /**
   * DOCUMENT ME!
   *
   * @param params DOCUMENT ME!
   */
  public void setParams(HashMap<String, String> params) {
    this.params = params;
  }

  /**
   * DOCUMENT ME!
   *
   * @param subType DOCUMENT ME!
   */
  public void setSubType(Enum subType) {
    this.subType = subType;
  }

  /**
   * DOCUMENT ME!
   *
   * @param type DOCUMENT ME!
   */
  public void setType(MessageType type) {
    this.type = type;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
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
      Iterator i = getParams().keySet().iterator();

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
