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
package com.phonytive.astive.agi;


/**
 * Define few global variables for an FASTAGI server.
 *
 * @since 1.0.0
 */
public interface DefaultAgiServerSettings {
  /**ADOC_COMME */
  public static int DEFAULT_AGI_SERVER_PORT = 0x11dd;

  /**ADOC_COMME */
  public static int DEFAULT_AGI_SERVER_BACKLOG = 0x32;

  /**ADOC_COMME */
  public static String DEFAULT_AGI_SERVER_BIND_ADDR = "127.0.0.1";
}
