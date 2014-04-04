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

            if (!appExist(app.getDeploymentId())) {
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
                        new Object[]{app.getInfo().getName()}));
            }
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

            if (appExist(astObj.getDeploymentId())) {
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
