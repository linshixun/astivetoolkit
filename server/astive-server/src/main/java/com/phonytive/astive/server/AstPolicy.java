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
package com.phonytive.astive.server;

import com.phonytive.astive.server.utils.ServiceProperties;
import java.net.InetAddress;
import java.net.SocketPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.*;

/**
 * 
 * @since 1.0.0
 */
public class AstPolicy extends Policy {
    private static PermissionCollection perms; 
    private final static String DEFAULT_ACTION = "accept";

    public AstPolicy() {
        super();
        if (perms == null) {
            perms = new AstPermissionCollection();            
        }
    }

    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return perms;
    }

    public void addPermissions(Permission p) {        
        perms.add(p);        
    }
    
    public void addPermissions(ServiceProperties sp) {
        List<InetAddress> onlyFromList = sp.getOnlyFrom();
        Iterator<InetAddress> onlyFromIterator = onlyFromList.iterator();
        while(onlyFromIterator.hasNext()) {
            InetAddress currentInetAddress = onlyFromIterator.next();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(currentInetAddress.getHostAddress());
            sb.append("]");
            sb.append(sp.getPort());
            SocketPermission spn = new SocketPermission(sb.toString(), 
                    DEFAULT_ACTION);
            perms.add(spn);
        }
    }    
}

class AstPermissionCollection extends PermissionCollection {

    private static final long serialVersionUID = 614300921365729272L;

    ArrayList<Permission> perms = new ArrayList<Permission>();

    @Override
    public void add(Permission p) {
        perms.add(p);
    }

    @Override    
    public boolean implies(Permission p) {
        for (Iterator<Permission> i = perms.iterator(); i.hasNext();) {
            if (((Permission) i.next()).implies(p)) {
                return true;
            }
        }
        return false;
    }

    @Override    
    public Enumeration<Permission> elements() {
        return Collections.enumeration(perms);
    }

    @Override    
    public boolean isReadOnly() {
        return false;
    }

}
