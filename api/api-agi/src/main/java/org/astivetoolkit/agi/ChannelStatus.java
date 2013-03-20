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
package org.astivetoolkit.agi;


/**
 * Enum that handle the status of a <code>channel</code>.
 *
 * @since 1.0.0
 */
public enum ChannelStatus {
  /**
   * Channel is in an unknown status.
   */
  UNKNOWN_STATUS(0xffffffff),
  /**
   * Channel is down and available.
   */
  CHANNEL_IS_DOWN_AND_AVAILABLE(0x0),
  /**
   * Channel is down but reserved.
   */
  CHANNEL_IS_DOWN_BUT_RESERVED(0x1),
  /**
   * Channel is off hook.
   */
  CHANNEL_IS_OFF_HOOK(0x2),
  /**
   * Digits have been dialed.
   */
  DIGITS_HAVE_BEEN_DIALED(0x3),
  /**
   * Line is ringing.
   */
  LINE_IS_RINGING(0x4),
  /**
   * Remote end is ringing.
   */
  REMOTE_END_IS_RINGING(0x5),
  /**
   * Line is up.
   */
  LINE_IS_UP(0x6),
  /**
   * Line is busy
   */
  LINE_IS_BUSY(0x7);
  /**
   * Int value of this type.
   */
  private int code;

  /**
   * Create a new ChannelStatus object with status code as parameter. This
   * class is an enum, therefore can't be instantiated directly.
   */
  private ChannelStatus(int code) {
    this.code = code;
  }

  /**
   * Return enum for channel status code.
   *
   * @param code channel status code
   * @return ChannelStatus enum
   */
  public static ChannelStatus get(int code) {
    for (ChannelStatus cs : ChannelStatus.values()) {
      if (cs.code == code) {
        return cs;
      }
    }

    return null;
  }

  /**
   * Get the int value of this type.
   *
   * @return value for the enum element.
   */
  public int getCode() {
    return code;
  }
}
