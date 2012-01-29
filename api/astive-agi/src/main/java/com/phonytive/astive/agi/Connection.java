/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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

import java.io.IOException;


/**
 * Provide read/write capabilities for few objects.
 *
 * @since 1.0.0
 */
public interface Connection {
    /**
     * Reads a line of text from I/O channel.
     *
     * @return line of text from I/O channel.
     * @throws IOException if unable to perform input operation.
     */
    abstract String readLine() throws IOException;

    /**
     * Sends a given String to I/O channel.
     *
     * @param line string to send.
     * @throws IOException if unable to perform output operation.
     */
    abstract void write(String str) throws IOException;

    /**
     * Whether or not the channel is closed.
     *
     * @return true for a closed channel, false otherwise.
     */
    abstract boolean isClosed();
}
