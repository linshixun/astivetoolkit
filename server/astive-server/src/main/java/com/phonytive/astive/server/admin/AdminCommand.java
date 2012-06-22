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
package com.phonytive.astive.server.admin;

/**
 *
 * @since 1.0.0
 */
public enum AdminCommand {

    /**
     * Start server.
     */
    START("start"),
    /**
     * Stop server.
     */
    STOP("stop"),
    /**
     * Deploy an application.
     */
    DEPLOY("deploy"),
    /**
     * Undeploy an application.
     */
    UNDEPLOY("undeploy"),
    /**
     * Show help for commands
     */
    HELP("help"),    
    /**
     * 
     */
    VERSION("version");
    
    /**
     * String value for this enum.
     */
    private String command;

    /**
     * Create a new AdminCommand object with status code as parameter. This
     * class is an enum, therefore can't be instantiated directly.
     */
    private AdminCommand(String command) {
        this.command = command;
    }

    /**
     * Get command enum.
     *
     * @param command command as text.
     * @return command as enum
     */
    static public AdminCommand get(String command) {
        for (AdminCommand ac : AdminCommand.values()) {
            if (ac.command.equals(command)) {
                return ac;
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
