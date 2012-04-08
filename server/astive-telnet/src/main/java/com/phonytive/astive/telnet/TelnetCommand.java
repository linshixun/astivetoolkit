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
package com.phonytive.astive.telnet;

/**
 *
 * @since 1.0.0
 */
public enum TelnetCommand {

    /**
     * Stop server.
     */
    STOP("stop"),
    /**
     * List server configurations.
     */
    SYSTEM("system"),
    /**
     * Look for applications.
     */
    LOOKUP("lookup"),
    /**
     * Show help for commands
     */
    HELP("help"),    
    /**
     * Get server version.
     */
    VERSION("version"),
    /**
     * Close client connection.
     */
    EXIT("exit");
    
    /**
     * String value for this enum.
     */
    private String command;

    /**
     * Create a new AdminCommand object with status code as parameter. This
     * class is an enum, therefore can't be instantiated directly.
     */
    private TelnetCommand(String command) {
        this.command = command;
    }

    /**
     * Get command enum.
     *
     * @param command command as text.
     * @return command as enum
     */
    static public TelnetCommand get(String command) {
        for (TelnetCommand tc : TelnetCommand.values()) {
            if (tc.command.equals(command)) {
                return tc;
            }
        }
        return null;
    }

    /**
     * Get command as text.
     *
     * @param command command as enum.
     * @return command as text.
     */
    public String getCommand() {
        return command;
    }
}
