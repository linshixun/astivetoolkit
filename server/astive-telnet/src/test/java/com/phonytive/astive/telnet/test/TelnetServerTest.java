/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonytive.astive.telnet.test;

import com.phonytive.astive.telnet.TelnetServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class TelnetServerTest extends TestCase {
    
    public TelnetServerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testTelnetServer() throws UnknownHostException, IOException {
        //TelnetServer t = new TelnetServer(5000, 4000, InetAddress.getByName("localhost"));
        //t.run();
    }
}
