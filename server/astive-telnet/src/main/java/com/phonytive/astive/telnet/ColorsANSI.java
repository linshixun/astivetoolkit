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
package com.phonytive.astive.telnet;


/**
 * Contains all the ANSI colors constants.
 *
 * @since 1.0.0
 */
public class ColorsANSI {
  public static final String SANE = "\u001B[0m";
  public static final String BRIGHT = "\u001B[1m";
  public static final String BLACK = "\u001B[0;30m";
  public static final String RED = "\u001B[0;31m";
  public static final String GREEN = "\u001B[0;32m";
  public static final String YELLOW = "\u001B[0;33m";
  public static final String BLUE = "\u001B[0;34m";
  public static final String MAGENTA = "\u001B[0;35m";
  public static final String CYAN = "\u001B[0;36m";
  public static final String WHITE = "\u001B[0;37m";
  public static final String DARK_BLACK = "\u001B[1;30m";
  public static final String DARK_RED = "\u001B[1;31m";
  public static final String DARK_GREEN = "\u001B[1;32m";
  public static final String DARK_YELLOW = "\u001B[1;33m";
  public static final String DARK_BLUE = "\u001B[1;34m";
  public static final String DARK_MAGENTA = "\u001B[1;35m";
  public static final String DARK_CYAN = "\u001B[1;36m";
  public static final String DARK_WHITE = "\u001B[1;37m";
  public static final String BACKGROUND_BLACK = "\u001B[40m";
  public static final String BACKGROUND_RED = "\u001B[41m";
  public static final String BACKGROUND_GREEN = "\u001B[42m";
  public static final String BACKGROUND_YELLOW = "\u001B[43m";
  public static final String BACKGROUND_BLUE = "\u001B[44m";
  public static final String BACKGROUND_MAGENTA = "\u001B[45m";
  public static final String BACKGROUND_CYAN = "\u001B[46m";
  public static final String BACKGROUND_WHITE = "\u001B[47m";

  private ColorsANSI() {
  }
}
