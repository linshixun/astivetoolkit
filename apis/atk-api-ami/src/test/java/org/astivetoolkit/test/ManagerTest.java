package org.astivetoolkit.test;

import static org.junit.Assert.*;

import org.astivetoolkit.AmiException;
import org.astivetoolkit.Manager;
import org.astivetoolkit.ManagerFactory;
import org.astivetoolkit.action.AgentsAction;
import org.junit.Test;

public class ManagerTest {

	@Test
	public void test() throws AmiException {
		Manager m = ManagerFactory.getInstance().createManager("kaffeineminds.com", "admin", "osopolar");		
		m.login();
		m.sendAction(new AgentsAction());
		m.logout();
	}

}
