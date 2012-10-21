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
package com.phonytive.astive.agi.command;

import java.io.Serializable;
import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.Parameter;

/**
 * Sends the given image on a <code>channel</code>. Most channels do not support
 * the transmission of images.
 *
 * <p>Returns 0 if image is sent, or if the channel does not support image
 * transmission.  Returns -1 only on error/hangup. Image names should not
 * include extensions.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SEND IMAGE")
public class SendImage implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0xd4847997739b48c6L;

  /**
   * Image to sent to channel.
   */
  @Parameter(optional = false)
  private String image;

  /**
   * Create a new SendImage object.
   *
   * @param image image to send.
   */
  public SendImage(String image) {
    this.image = image;
  }

  /**
   * Get image to send.
   *
   * @return image to to send.
   */
  public String getImage() {
    return image;
  }

  /**
   * Set image to send.
   *
   * @param image image to send.
   */
  public void setImage(String image) {
    this.image = image;
  }
}
