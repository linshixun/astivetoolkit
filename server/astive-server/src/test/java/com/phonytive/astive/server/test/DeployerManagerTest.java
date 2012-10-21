/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonytive.astive.server.test;

import java.io.File;
import org.eclipse.jetty.toolchain.test.MavenTestingUtils;
import static org.junit.Assert.*;
import com.phonytive.astive.AstiveException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.AstObj;
import com.phonytive.astive.server.appmanager.DeployerManager;
import junit.framework.TestCase;

/**
 *
 * @since 1.0.0
 */
public class DeployerManagerTest extends TestCase {
  /**
   * Creates a new DeployerManagerTest object.
   */
  public DeployerManagerTest() {
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AstiveException DOCUMENT ME!
   */
  public void testDeployerManager() throws AstiveException {
    File file = MavenTestingUtils.getProjectFile("/src/test/resources/helloworld.jar");
    AstObj astObj = new AstObj("helloworld.jar", file.getAbsolutePath());
    Astivlet ast = astObj.getAstivletByURLPattern("/examples/HelloWorld");
    DeployerManager dm = DeployerManager.getInstance();

    assertNotNull(ast);
    assertEquals("Should be not apps at this point", dm.getApps().size(), 0);

    dm.addApp(astObj);

    assertEquals("Should be one app at this point", dm.getApps().size(), 1);
    assertNotNull(dm.getApp(astObj.getDeploymentId()));
    dm.removeApp(astObj);

    assertEquals("Should be 0 apps again", dm.getApps().size(), 0);
  }
}
