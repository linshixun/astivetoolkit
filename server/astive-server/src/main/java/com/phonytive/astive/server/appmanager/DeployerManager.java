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
package com.phonytive.astive.server.appmanager;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.*;
import com.phonytive.astive.server.utils.CopyFile;
import com.phonytive.astive.util.AppLocale;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.xeustechnologies.jcl.exception.JclException;
import org.xeustechnologies.jcl.proxy.CglibProxyProvider;
import org.xeustechnologies.jcl.proxy.ProxyProviderFactory;


/**
 * Final implementation of interface {@link Deployer}.
 * 
 * @since 1.0.0
 * @see Deployer
 */
public final class DeployerManager implements Deployer, AstDB {

    private static final Logger logger = Logger.getLogger(DeployerManager.class);
    private static final DeployerManager INSTANCE = new DeployerManager();
    private static AstDB astDB;
    
    /**
     * Create a new DeployerManager object.
     */
    private DeployerManager() {
        ProxyProviderFactory.setDefaultProxyProvider(new CglibProxyProvider());        
        astDB = MyAstDB.getInstance();
        try {
            deployApps();
        } catch (AstiveException ex) {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[]{ex.getMessage()}));
        }
    }

    /**
     * {@inheritDoc}
     */
    public static DeployerManager getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deploy(String appPath) throws AstiveException {
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(AppLocale.getI18n("cli.deploy.deployingApp",
                        new Object[]{appPath}));
            }

            File srcFile = new File(appPath);
            String dstFileStr = AbstractAstiveServer.ASTIVE_APPS + srcFile.getName();

            // The name of the file must be use also to undeploy the apps.
            AstObj app = new AstObj(srcFile.getName(), srcFile.getCanonicalPath());                        

            if (!appExist(app.deploymentId())) {
                addApp(app);

                if (!dstFileStr.equals(appPath)) {
                    CopyFile.copyfile(appPath, dstFileStr);
                }
            } else {
                logger.debug(AppLocale.getI18n("cli.deploy.appExist",
                        new Object[]{appPath, AbstractAstiveServer.ASTIVE_APPS}));

                return;
            }

            if (logger.isDebugEnabled()) {
                logger.debug(AppLocale.getI18n("cli.deploy.appDeployed",
                        new Object[]{app.deploymentId()}));
            }

            // Hand code
            //logger.debug(
            //        " - @Astivlet(id= \"helloworld\" class=\"com.phonytive.astive.helloworld.App\")");
            //logger.debug(
            //        " - @Astivlet(id= \"handlingevents\" class=\"com.phonytive.astive.handingevents.App\")");
        } catch (FileNotFoundException ex) {
            logger.error(AppLocale.getI18n("cli.deploy.cantReadFile",
                    new Object[]{appPath}));
        } catch (IOException ex) {
            logger.error(AppLocale.getI18n("cli.deploy.cantCopy"));
        } catch (JclException ex) {
            logger.error(AppLocale.getI18n("cli.deploy.cantReadFile",
                    new Object[]{appPath}));
        } catch (AstiveException ex) {
            if (logger.isDebugEnabled()) {
                logger.debug(AppLocale.getI18n("unexpectedError",
                        new Object[]{ex.getMessage()}));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void undeploy(String app) throws AstiveException {
        if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("cli.undeploy.undeployingApp",
                    new Object[]{app}));
        }

        try {
            File f = new File(AbstractAstiveServer.ASTIVE_APPS + app);
            String file = AbstractAstiveServer.ASTIVE_APPS + app;

            AstObj astObj = new AstObj(app, file);

            if (appExist(astObj.deploymentId())) {
                astDB.removeApp(astObj);

                if (f.exists()) {
                    f.delete();
                    logger.debug(AppLocale.getI18n(
                            "cli.undeploy.appUndeployed", new Object[]{app}));
                } else {
                    logger.debug(AppLocale.getI18n(
                            "cli.deploy.appFileNotExist", new Object[]{app}));
                }
            } else {
                logger.debug(AppLocale.getI18n("cli.deploy.appNotExist",
                        new Object[]{app}));
            }
        } catch (org.xeustechnologies.jcl.exception.JclException ex) {
            if (logger.isDebugEnabled()) {
                logger.debug(AppLocale.getI18n("cli.deploy.appNotExist",
                        new Object[]{app}));
            }
        } catch (AstiveException ex) {
            if (logger.isDebugEnabled()) {
                logger.debug(AppLocale.getI18n("unexpectedError",
                        new Object[]{ex.getMessage()}));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void deployApps() throws AstiveException {
        if (logger.isDebugEnabled()) {
            logger.debug(AppLocale.getI18n("deployingApps",
                    new Object[]{AbstractAstiveServer.ASTIVE_APPS}));
        }

        //String apps = ASTIVE_APPS;
        File f = new File(AbstractAstiveServer.ASTIVE_APPS);

        if (f.isDirectory()) {
            File[] files = f.listFiles();

            for (int i = 0; i < files.length; i++) {
                String file = files[i].getAbsolutePath();

                if (file.toLowerCase().endsWith(".jar")) {
                    deploy(file);
                } else {
                    logger.debug(AppLocale.getI18n("isNotValidApp",
                            new Object[]{file}));
                }
            }
        } else {
            logger.error(AppLocale.getI18n("unexpectedError",
                    new Object[]{AbstractAstiveServer.ASTIVE_APPS}));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean appExist(String deploymentId) {
        return astDB.appExist(deploymentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AstObj getApp(String deploymentId) throws AstiveException {
        return astDB.getApp(deploymentId);
    }

    /**
     * {@inheritDoc}
     */    
    @Override
    public void addApp(AstObj astObj) throws AstiveException {
        astDB.addApp(astObj);
    }

    /**
     * {@inheritDoc}
     */    
    @Override
    public void removeApp(AstObj astObj) throws AstiveException {
        astDB.removeApp(astObj);
    }

    /**
     * {@inheritDoc}
     */    
    @Override
    public List<AstObj> getApps() throws AstiveException {
        return astDB.getApps();
    }

    /**
     * {@inheritDoc}
     */    
    @Override
    public Astivlet getAstivlet(String urlStr) throws AstiveException {
        return astDB.getAstivlet(urlStr);
    }

    /**
     * {@inheritDoc}
     */    
    @Override
    public String[] getAstivletsURLs() throws AstiveException {
        return astDB.getAstivletsURLs();
    }
}
