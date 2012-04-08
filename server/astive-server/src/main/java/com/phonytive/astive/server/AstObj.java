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
import com.phonytive.astive.server.utils.URLValidator;
import com.phonytive.astive.util.AppLocale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import noNamespace.AppDocument;
import noNamespace.AppType;
import noNamespace.AstivletMappingType;
import noNamespace.AstivletType;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JarResources;
import org.xeustechnologies.jcl.JclObjectFactory;
import org.xeustechnologies.jcl.proxy.CglibProxyProvider;
import org.xeustechnologies.jcl.proxy.ProxyProviderFactory;

/**
 * Convenient class to manage Astive apps jars.
 *
 * @since 1.0.0
 */
public final class AstObj {

    private JarClassLoader jcl;
    private JclObjectFactory factory;
    private static final String ASTIVE_DEPLOYMENT_DESCRIPTOR = "app.xml";
    private Map<String, Astivlet> astivlets;
    private AppType app;
    /**
     * Application identifier.
     */
    private String deploymentId;

    /**
     * Creates a new AstObj object.
     *
     * @param getDeploymentId application identifier.
     */
    public AstObj(String deploymentId, String jarFile) throws AstiveException {
        this.deploymentId = deploymentId;
        astivlets = new HashMap();
        try {
            // Should be in AstiveServer class
            ProxyProviderFactory.setDefaultProxyProvider(new CglibProxyProvider());
            // Creating a class loader for this app obj.
            jcl = new JarClassLoader();
            jcl.add(jarFile);
            factory = JclObjectFactory.getInstance(true);

            // Getting the descriptor
            JarResources jar = new JarResources();
            jar.loadJar(jarFile);
            byte[] appxml = jar.getResource(ASTIVE_DEPLOYMENT_DESCRIPTOR);
            AppDocument doc = AppDocument.Factory.parse(new String(appxml));

            if (doc.validate() == false) {
                throw new AstiveException(AppLocale.getI18n("invalidDescriptor"));
            }

            app = doc.getApp();
            AstivletType[] ats = app.getAstivletArray();

            // Validate URL's patterns            
            for (AstivletType at : ats) {
                List<String> urls = getURLs(at.getAstivletId());

                // Ignore the Astivlet
                if (urls.isEmpty()) {
                    continue;
                }

                for(String url: urls) {                
                    if (!URLValidator.isValidURL(url)) {
                        throw new AstiveException(AppLocale.getI18n("invalidURL"));
                    }

                    Astivlet ast= getAstivletByURLPattern(url);
                    if(ast != null) { // URL Pattern already exist
                        throw new AstiveException(AppLocale.getI18n("patternAlreadyDefine"));
                    }

                    astivlets.put(url, getAstivletByClass(at.getClass1()));
                }
            }
        } catch (Exception ex) {
            throw new AstiveException(AppLocale.getI18n(
                    "invalidAppOrDescriptor", new Object[]{jarFile}));
        }
    }

    /**
     * Get application identifier.
     *
     * @return application identifier.
     */
    public String getDeploymentId() {
        return deploymentId;
    }

    /**
     * Get an instance of the class in the class loader.
     *
     * @param astivletId
     * @return an instance of the class loaded class.
     */
    public Astivlet getAstivletById(String astivletId) {
        AstivletType[] ats = app.getAstivletArray();
        for (AstivletType at : ats) {
            if (at.getAstivletId().equals(astivletId)) {
                return getAstivletByClass(at.getClass1());
            }
        }
        return null;
    }

    /**
     * Get an instance of the class in the class loader.
     *
     * @param urlPattern find the Astivlet matching with this pattern.
     * @return an instance of the class loaded class.
     */
    public Astivlet getAstivletByURLPattern(String urlPattern) {                
        return astivlets.get(urlPattern);
    }

    /**
     * Get an instance of the class in the class loader.
     *
     * @param clazz class to return
     * @return an instance of requested class.
     */
    public Astivlet getAstivletByClass(String clazz) {
        return (Astivlet) factory.create(jcl, clazz);
    }

    /**
     * Get all URL for this app.
     * 
     * @return a list with all URL's patterns in this object instance.
     */
    public List<String> getURLPatterns() {
        AstivletMappingType[] amts = app.getAstivletMappingArray();
        ArrayList<String> amtList = new ArrayList();

        for (AstivletMappingType amt : amts) {
            amtList.add(amt.getUrlPattern());
        }
        return amtList;
    }

    /**
     * Get URL.
     * 
     * @param astivletId astivlet identifier.
     * @return an url.
     */
    private List getURLs(String astivletId) {
        List<String> urlList = new ArrayList();        
        AstivletMappingType[] amts = app.getAstivletMappingArray();        
        
        for (AstivletMappingType amt : amts) {
            if (amt.getAstivletId().equals(astivletId)) {
                urlList.add(amt.getUrlPattern());
            }
        }
        
        return urlList;
    }
    
    /**
     * Return meta data related to de app.
     * 
     * @return app meta-data.
     */
    public AppType getInfo() {
        return app;
    }
    
}
