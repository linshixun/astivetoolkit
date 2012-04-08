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

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;


/**
 * Final implementation for AstDB.
 *
 * @since 1.0.0
 */
public class MyAstDB implements AstDB {
    // A usual logging class
    private static final Logger logger = Logger.getLogger(MyAstDB.class);
    private static final MyAstDB INSTANCE = new MyAstDB();
    private static Map<String, AstObj> apps;
    private static Map<String, Astivlet> astivletIndex;

    /**
     * Creates a new MyAstDB object.
     */
    private MyAstDB() {
        apps = Collections.synchronizedMap(new HashMap<String, AstObj>());
        astivletIndex = Collections.synchronizedMap(new HashMap<String, Astivlet>());
    }

    /**
     * {@inheritDoc}
     */
    public static AstDB getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AstObj getApp(String deploymentId) {
        return apps.get(deploymentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addApp(AstObj astObj) throws AstiveException {
        // Ensure astObj url's are not in astivletIndex
        for (String urls : astObj.getURLPatterns()) {
            if (urlExist(urls)) {
                throw new AstiveException(AppLocale.getI18n("url already exist"));
            }
        }

        // everithing is good then add the app.
        apps.put(astObj.getDeploymentId(), astObj);

        // add astivlets to the db index.
        for (String url : astObj.getURLPatterns()) {
            logger.debug("Adding url = " + url + " class = " +
                astObj.getAstivletByURLPattern(url));
            astivletIndex.put(url, astObj.getAstivletByURLPattern(url));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeApp(AstObj astObj) {
        // Ensure to remove astivlets from the index.
        for (String url : astObj.getURLPatterns()) {
            astivletIndex.remove(url);
        }

        apps.remove(astObj.getDeploymentId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AstObj> getApps() {
        ArrayList a = new ArrayList();

        for (AstObj ao : apps.values()) {
            a.add(ao);
        }

        return a;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Astivlet getAstivlet(String urlStr) {
        // Check for specific url
        Astivlet ast = null;

        if ((ast = astivletIndex.get(urlStr)) != null) {
            return ast;
        }

        // Match parent paths and extentions
        int lCnt = 0;
        String bestMatch = null;

        for (String url : astivletIndex.keySet()) {
            Pattern curPattern = Pattern.compile(url);
            Boolean match = curPattern.matcher(urlStr).find();

            if (match) {
                if (url.length() > lCnt) {
                    bestMatch = url;
                    lCnt = url.length();
                }
            }
        }

        if (bestMatch != null) {
            if ((ast = astivletIndex.get(bestMatch)) != null) {
                return ast;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getAstivletsURLs() {
        return (String[]) astivletIndex.keySet().toArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean appExist(String deploymentId) {
        if (getApp(deploymentId) != null) {
            return true;
        }

        return false;
    }

    /**
     * Check if URL already exist.
     *
     * @param url URL to check
     * @return true if URL already exist or false otherwise.
     */
    private Boolean urlExist(String url) {
        Set<String> urls = astivletIndex.keySet();

        for (String curUrl : urls) {
            if (curUrl.equals(url)) {
                return true;
            }
        }

        return false;
    }
}
