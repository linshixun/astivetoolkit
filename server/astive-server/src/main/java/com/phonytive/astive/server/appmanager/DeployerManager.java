/*
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.xeustechnologies.jcl.exception.JclException;
import org.xeustechnologies.jcl.proxy.CglibProxyProvider;
import org.xeustechnologies.jcl.proxy.ProxyProviderFactory;
import com.phonytive.astive.AstiveException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.*;
import com.phonytive.astive.server.utils.CopyFile;
import com.phonytive.astive.util.AppLocale;

/**
 * Final implementation of interface {@link Deployer}.
 *
 * @since 1.0.0
 * @see Deployer
 */
public final class DeployerManager implements Deployer, AstDB {
  private static final Logger LOG = Logger.getLogger(DeployerManager.class);
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
      LOG.error(AppLocale.getI18n("unexpectedError", new Object[] { ex.getMessage() }));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addApp(AstObj astObj) throws AstiveException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("addingApp", new Object[] { astObj.getDeploymentId() }));
    }

    astDB.addApp(astObj);

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
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
  public void deploy(String appPath) throws AstiveException {
    try {
      if (LOG.isInfoEnabled()) {
        LOG.info(AppLocale.getI18n("cli.deploy.deployingApp", new Object[] { appPath }));
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
        if (LOG.isInfoEnabled()) {
          LOG.info(AppLocale.getI18n("cli.deploy.appExist",
                                     new Object[] { appPath, AbstractAstiveServer.ASTIVE_APPS }));
        }

        return;
      }

      if (LOG.isInfoEnabled()) {
        LOG.info(AppLocale.getI18n("cli.deploy.appDeployed",
                                   new Object[] { app.getInfo().getName() }));
      }
    } catch (FileNotFoundException ex) {        
      LOG.error(AppLocale.getI18n("cli.deploy.cantReadFile", new Object[] { appPath }));
    } catch (IOException ex) {
      LOG.error(AppLocale.getI18n("cli.deploy.cantCopy"));
    } catch (JclException ex) {        
      LOG.error(AppLocale.getI18n("cli.deploy.cantReadFile", new Object[] { appPath }));
    } catch (AstiveException ex) {        
      LOG.error(AppLocale.getI18n("cli.deploy.cantReadFile", new Object[] { appPath }));
    }
  }

  /**
   * {@inheritDoc}
   */
  public void deployApps() throws AstiveException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("deployingApps", new Object[] { AbstractAstiveServer.ASTIVE_APPS }));
    }

    //String apps = ASTIVE_APPS;
    File f = new File(AbstractAstiveServer.ASTIVE_APPS);

    if (f.isDirectory()) {
      File[] files = f.listFiles();

      for (int i = 0x0; i < files.length; i++) {
        String file = files[i].getAbsolutePath();

        if (file.toLowerCase().endsWith(".jar")) {
          deploy(file);
        } else {
          LOG.warn(AppLocale.getI18n("isNotValidApp", new Object[] { file }));
        }
      }
    } else {
      LOG.error(AppLocale.getI18n("unexpectedError",
                                  new Object[] { AbstractAstiveServer.ASTIVE_APPS }));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AstObj getApp(String deploymentId) throws AstiveException {
    AstObj result = astDB.getApp(deploymentId);

    return result;
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
  public void removeApp(AstObj astObj) throws AstiveException {
    astDB.removeApp(astObj);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void undeploy(String app) throws AstiveException {
    if (LOG.isInfoEnabled()) {
      LOG.info(AppLocale.getI18n("cli.undeploy.undeployingApp", new Object[] { app }));
    }

    try {
      File f = new File(AbstractAstiveServer.ASTIVE_APPS + app);
      String file = AbstractAstiveServer.ASTIVE_APPS + app;

      AstObj astObj = new AstObj(app, file);

      if (appExist(astObj.getDeploymentId())) {
        astDB.removeApp(astObj);

        if (f.exists()) {
          f.delete();

          if (LOG.isInfoEnabled()) {
            LOG.info(AppLocale.getI18n("cli.undeploy.appUndeployed", new Object[] { app }));
          }
        } else {
          LOG.warn(AppLocale.getI18n("cli.deploy.appFileNotExist", new Object[] { app }));
        }
      } else {
        LOG.warn(AppLocale.getI18n("cli.deploy.appNotExist", new Object[] { app }));
      }
    } catch (org.xeustechnologies.jcl.exception.JclException ex) {
      LOG.error(AppLocale.getI18n("cli.deploy.appNotExist", new Object[] { app }));
    } catch (AstiveException ex) {
      LOG.error(AppLocale.getI18n("cli.deploy.appNotExist", new Object[] { app }));
    }
  }
}
