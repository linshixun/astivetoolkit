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
package com.phonytive.astive.server.appmanager;

import com.phonytive.astive.server.App;
import com.phonytive.astive.server.AstiveException;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import org.xeustechnologies.jcl.exception.JclException;
import org.xeustechnologies.jcl.proxy.CglibProxyProvider;
import org.xeustechnologies.jcl.proxy.ProxyProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see ApplicationManager
 */
public final class ApplicationManagerImpl implements ApplicationManager {
    private static final Logger logger = Logger.getLogger(ApplicationManagerImpl.class);
    private static final ApplicationManagerImpl INSTANCE = new ApplicationManagerImpl();
    private final Map<String, App> apps;

    private ApplicationManagerImpl() {
        ProxyProviderFactory.setDefaultProxyProvider(new CglibProxyProvider());
        apps = Collections.synchronizedMap(new HashMap<String, App>());

        try {
            deployApps();
        } catch (AstiveException ex) {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[] { ex.getMessage() }));
        }
    }

    public static ApplicationManagerImpl getInstance() {
        return INSTANCE;
    }

    public void deployApps() throws AstiveException {
        logger.debug(AppLocale.getI18n("deployingApps",
                new Object[] { ASTIVE_APPS }));

        //String apps = ASTIVE_APPS;
        File f = new File(ASTIVE_APPS);

        if (f.isDirectory()) {
            File[] files = f.listFiles();

            for (int i = 0; i < files.length; i++) {
                String file = files[i].getAbsolutePath();

                if (file.toLowerCase().endsWith(".jar")) {
                    deploy(file);
                } else {
                    logger.debug(AppLocale.getI18n("isNotValidApp",
                            new Object[] { file }));
                }
            }
        } else {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[] { ASTIVE_APPS }));
        }
    }

    @Override
    public void deploy(String app) throws AstiveException {
        try {
            logger.debug(AppLocale.getI18n("cli.deploy.deployingApp",
                    new Object[] { app }));

            File srcFile = new File(app);
            String dstFileStr = ASTIVE_APPS + srcFile.getName();
            App a = new App(app);

            if (!appExist(a.getAppName())) {
                apps.put(a.getAppName(), a);

                if (!dstFileStr.equals(app)) {
                    CopyFile.copyfile(app, dstFileStr);
                }
            } else {
                logger.debug(AppLocale.getI18n("cli.deploy.appExist",
                        new Object[] { app, ASTIVE_APPS }));

                return;
            }

            logger.debug(AppLocale.getI18n("cli.deploy.appDeployed",
                    new Object[] { a.getAppName() }));
        } catch (FileNotFoundException ex) {
            logger.error(AppLocale.getI18n("cli.deploy.cantReadFile",
                    new Object[] { app }));
        } catch (IOException ex) {
            logger.error(AppLocale.getI18n("cli.deploy.cantCopy"));
        } catch (JclException ex) {
            logger.error(AppLocale.getI18n("cli.deploy.cantReadFile",
                    new Object[] { app }));
        } catch (AstiveException ex) {
            logger.debug(AppLocale.getI18n("unexpectedError",
                    new Object[] { ex.getMessage() }));
        }
    }

    @Override
    public void undeploy(String app) throws AstiveException {
        logger.debug(AppLocale.getI18n("cli.undeploy.undeployingApp",
                new Object[] { app }));

        try {
            File f = new File(ASTIVE_APPS + app);
            String file = ASTIVE_APPS + app;

            App a = new App(file);

            if (appExist(a.getAppName())) {
                apps.remove(a.getAppName());

                if (f.exists()) {
                    f.delete();
                    logger.debug(AppLocale.getI18n(
                            "cli.undeploy.appUndeployed", new Object[] { app }));
                } else {
                    logger.debug(AppLocale.getI18n(
                            "cli.deploy.appFileNotExist", new Object[] { app }));
                }
            } else {
                logger.debug(AppLocale.getI18n("cli.deploy.appNotExist",
                        new Object[] { app }));
            }
        } catch (org.xeustechnologies.jcl.exception.JclException ex) {
            logger.debug(AppLocale.getI18n("cli.deploy.appNotExist",
                    new Object[] { app }));
        } catch (AstiveException ex) {
            logger.debug(AppLocale.getI18n("unexpectedError",
                    new Object[] { ex.getMessage() }));
        }
    }

    @Override
    public ArrayList apps() {
        return (ArrayList) apps.values();
    }

    @Override
    public boolean appExist(String app) {
        if ((apps == null) || apps.isEmpty()) {
            return false;
        }

        return apps.containsKey(app);
    }

    @Override
    public App getApp(String app) throws AstiveException {
        return apps.get(app);
    }
}


class CopyFile {    
    public static synchronized void copyfile(String srFile, String dtFile)
        throws FileNotFoundException, IOException {
        try {
            File f1 = new File(srFile);
            File f2 = new File(dtFile);
            InputStream in = new FileInputStream(f1);

            //For Overwrite the file.
            OutputStream out = new FileOutputStream(f2);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
