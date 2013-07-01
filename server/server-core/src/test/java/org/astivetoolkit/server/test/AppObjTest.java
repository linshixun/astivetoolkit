/*
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.server.test;

import java.io.File;
import junit.framework.TestCase;
import org.astivetoolkit.AstiveException;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.server.AstObj;
import org.eclipse.jetty.toolchain.test.MavenTestingUtils;

/**
 * Test case for {@link org.astivetoolkit.server.AstObj}.
 *
 * @since 1.0.0
 */
public class AppObjTest extends TestCase {

    /**
     * Creates a new AppObjTest object.
     *
     * @param testName {@inheritDoc}.
     */
    public AppObjTest(String testName) {
        super(testName);
    }

    /**
     * Test method.
     */
    public void testAppObj() throws AstiveException {
        File file = MavenTestingUtils.getProjectFile("/src/test/resources/helloworld.jar");
        AstObj astObj = new AstObj("helloworld.jar", file.getAbsolutePath());
        Astivlet ast = astObj.getAstivletByURLPattern("/examples/HelloWorld");
        assertNotNull(ast);

        ast = astObj.getAstivletByURLPattern("/wha?");
        assertNull(ast);
    }
}
