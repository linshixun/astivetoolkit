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
package com.phonytive.astive.server;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.util.AppLocale;
import java.util.Map;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;


/**
 * Convenient class to manage astive jars.
 *
 * @since 1.0.0
 */
public class AstObj {
    
    private JarClassLoader jcl;
    private JclObjectFactory factory;
    private DeploymentDescriptor dd;
    private static final String ASTIVE_DEPLOYMENT_DESCRIPTOR = "astivlet.xml";
    private Map<String, String> astivlets;
    
    /**
     * Application identifier.
     */
    private String deploymentId;

    /**
     * Creates a new AstObj object.
     *
     * @param deploymentId application identifier.
     */
    public AstObj(String jarFile) throws AstiveException {
        this.deploymentId = jarFile;
        try {
            // Creating a class loader for this app obj.
            jcl = new JarClassLoader();
            factory = JclObjectFactory.getInstance(true);
            jcl.add(jarFile);
            
            // Getting the descriptor
                        
            // Adding register astivlets
            
            
            //JarResources jar = new JarResources();
            //jar.loadJar(jarFile);
            //byte[] propBytes = jar.getResource(ASTIVE_DEPLOYMENT_DESCRIPTOR);            
            // TODO: Test this !
            //File f = new File(jarFile);
            //id = f.getName();
        } catch (Exception ex) {
            throw new AstiveException(AppLocale.getI18n(
                    "invalidAppOrDescriptor", new Object[] { jarFile }));
        }        
    }

    /**
     * Get application identifier.
     *
     * @return application identifier.
     */
    public String deploymentId() {
        return deploymentId;
    }
    
    /**
     * Get an instance of the class loaded class.
     *
     * @param astivletId
     * @return an instance of the class loaded class.
     */
    public Astivlet getAstivlet(String clazz) {
        return (Astivlet) factory.create(jcl, clazz);
    }    
}
