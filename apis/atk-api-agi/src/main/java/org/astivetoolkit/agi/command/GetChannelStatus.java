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
package org.astivetoolkit.agi.command;

import java.io.Serializable;
import org.astivetoolkit.agi.annotation.AgiCommand;
import org.astivetoolkit.agi.annotation.Parameter;

/**
 * Returns the status of the specified channel. If no channel name is given
 * then returns the status of the current channel.
 * Return values:
 * <ul>
 * <li>0 - Channel is down and available.
 * <li>1 - Channel is down, but reserved.
 * <li>2 - Channel is off hook.
 * <li>3 - Digits (or equivalent) have been dialed.
 * <li>4 - Line is ringing.
 * <li>5 - Remote end is ringing.
 * <li>6 - Line is up.
 * <li>7 - Line is busy.
 * </ul>
 *
 * @since 1.0.0
 * @see GetChannelStatus
 */
@AgiCommand(command = "CHANNEL STATUS")
public class GetChannelStatus implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = -820579790841625915L;

  /**
   * Channel name, or null for current channel.
   */
  @Parameter
  private String channel;

  /**
   * Create a new GetChannelStatus object.
   */
  public GetChannelStatus() {
  }

  /**
   * Create a new GetChannelStatus object with channel name as parameter.
   *
   * @param channel
   */
  public GetChannelStatus(String channel) {
    this.channel = channel;
  }

  /**
   * Get channel name or null for current channel.
   *
   * @return channel name.
   */
  public String getChannel() {
    return channel;
  }

  /**
   * Set channel name.
   *
   * @param channel channel name, or null for current channel.
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }
}
