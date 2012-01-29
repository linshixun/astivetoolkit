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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.command.DatabaseGet;
import com.phonytive.astive.agi.CommandProcessor;

import junit.framework.TestCase;


public class DatabaseGetTest extends TestCase {
    public DatabaseGetTest(String testName) {
        super(testName);
    }

    public void testCommand() throws AgiException {
        String family = "familyDb";
        String key = "keyDb";

        StringBuilder b = new StringBuilder("DATABASE GET");
        b.append(" ");
        b.append("\"");
        b.append(family);
        b.append("\"");
        b.append(" ");
        b.append("\"");
        b.append(key);
        b.append("\"");

        DatabaseGet command = new DatabaseGet(family, key);
        assert (b.toString().equals(CommandProcessor.buildCommand(command)));
    }
}
