// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.server;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.appmanager.ApplicationManager;
import com.phonytive.astive.server.utils.Utils;
import com.phonytive.astive.util.AppLocale;

import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JarResources;
import org.xeustechnologies.jcl.JclObjectFactory;
import org.xeustechnologies.jcl.exception.JclException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class App {
    private String appName;
    private String defaultEntryPoint;
    private JarClassLoader jcl;
    private JclObjectFactory factory;

    // This constructor find the resource astivlet-mapping
    public App(String file) throws AstiveException {
        try {
            jcl = new JarClassLoader();
            factory = JclObjectFactory.getInstance(true);
            jcl.add(file);

            JarResources jar = new JarResources();
            jar.loadJar(file);

            byte[] propBytes = jar.getResource(ApplicationManager.ASTIVE_MAPPING_FILE);
            appName = Utils.getAppName(new String(propBytes));
            defaultEntryPoint = Utils.getAppEntryPoint(new String(propBytes));
        } catch (Exception ex) {
            throw new AstiveException(AppLocale.getI18n(
                    "invalidAppOrDescriptor", new Object[] { file }));
        }
    }

    public String getAppName() {
        return appName;
    }

    public String getDefaultEntryPoint() {
        return defaultEntryPoint;
    }

    public Astivlet getEntryPoint() {
        return getEntryPoint(defaultEntryPoint);
    }

    public Astivlet getEntryPoint(String entryPoint) {
        //Create and cast object of loaded class
        return (Astivlet) factory.create(jcl, entryPoint);
    }
}
