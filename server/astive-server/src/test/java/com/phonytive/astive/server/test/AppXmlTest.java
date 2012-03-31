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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonytive.astive.server.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import junit.framework.TestCase;
import noNamespace.AppDocument;
import noNamespace.AppType;
import org.apache.xmlbeans.XmlException;

/**
 *
 * @author psanders
 */
public class AppXmlTest extends TestCase {

    public AppXmlTest(String testName) {
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

    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testHello() throws XmlException, IOException {
        URL url = this.getClass().getResource("app_test.xml");

        AppDocument doc = AppDocument.Factory.parse(
                new File(url.getFile()));

        assert (doc.validate() == true);

        AppType app = doc.getApp();

        assert (!app.getName().equals(""));
        assert (!app.getName().equals(""));
        assert (!app.getDescription().equals(""));
        assert (app.getAstivletArray().length == 2);
        assert (app.getAstivletMappingArray().length == 2);
    }
}
