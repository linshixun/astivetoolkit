/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * Test AppXml.
 * 
 * @since 1.0.0
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
