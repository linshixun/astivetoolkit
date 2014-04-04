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

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.AstObj;
import com.phonytive.astive.server.AstiveException;
import static java.lang.System.out;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class AppObjTest extends TestCase {
    
    public AppObjTest(String testName) {
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
        
    public void testAppObj() throws AstiveException {
        AstObj astObj = 
                new AstObj("helloworld-1.0.0-M2.jar","/home/psanders/Projects/PhonyTive"
                        + "/astive/examples/helloworld/target"
                            + "/helloworld-1.0.0-M2.jar");
        Astivlet ast = astObj.getAstivletByURLPattern("/examp2les2/2/HelloWorld3");
        
        out.println("ast = " + ast);
    }
}
