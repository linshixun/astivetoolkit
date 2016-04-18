/* 
 * Copyright (C) 2010-2016 by Fonoster Inc (http://fonoster.com)
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
package org.astivetoolkit.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.astivetoolkit.AstiveException;
import org.astivetoolkit.server.AbstractAstiveServer;
import org.astivetoolkit.server.SystemException;

import java.io.IOException;

@Mojo( name = "run")
public class SimpleServerMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        try {
            AbstractAstiveServer aas = new AbstractAstiveServer() {
                @Override
                protected void launchConnectionMonitor() throws AstiveException {

                }
            };
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLog().info( "Hello, world." );
    }
}