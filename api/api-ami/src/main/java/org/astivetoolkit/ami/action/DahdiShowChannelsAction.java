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
package org.astivetoolkit.ami.action;


/**
 * DOCUMENT ME
 */
public class DahdiShowChannelsAction extends ActionMessage {
  private String dahdiChannel;

  /**
   * Creates a new DahdiShowChannelsAction object.
   */
  public DahdiShowChannelsAction() {
    super(ActionType.DAHDI_SHOW_CHANNELS);
  }

  /**
   * Creates a new DahdiShowChannelsAction object.
   *
   * @param dahdiChannel DOCUMENT ME!
   */
  public DahdiShowChannelsAction(String dahdiChannel) {
    super(ActionType.DAHDI_SHOW_CHANNELS);
    this.dahdiChannel = dahdiChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getDahdiChannel() {
    return dahdiChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @param dahdiChannel DOCUMENT ME!
   */
  public void setDahdiChannel(String dahdiChannel) {
    this.dahdiChannel = dahdiChannel;
  }
}
