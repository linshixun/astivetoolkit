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

import com.phonytive.astive.server.utils.URLValidator;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class URLValidatorTest extends TestCase {

    public URLValidatorTest(String testName) {
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

    public void testValidateURLs() {

        assert (URLValidator.isValidURL("/") == true);
        assert (URLValidator.isValidURL("/*") == false);
        assert (URLValidator.isValidURL("/2") == false);
        assert (URLValidator.isValidURL("/myproject") == true);
        assert (URLValidator.isValidURL("/_abc") == false);
        assert (URLValidator.isValidURL("/myproject/") == true);
        assert (URLValidator.isValidURL("/myproject/*") == true);
        assert (URLValidator.isValidURL("/myproject/myAstivlet") == true);
        assert (URLValidator.isValidURL("*.ast") == true);
        assert (URLValidator.isValidURL("*.ast2") == true);
        assert (URLValidator.isValidURL("*.ast?%$") == true);
        assert (URLValidator.isValidURL("abc.ast?%$") == false);

    }
}
