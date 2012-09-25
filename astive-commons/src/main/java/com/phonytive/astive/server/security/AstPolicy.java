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
package com.phonytive.astive.server.security;

import com.phonytive.astive.server.ServiceProperties;
import java.net.InetAddress;
import java.net.SocketPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @since 1.0.0
 */
public class AstPolicy extends Policy {
    private static PermissionCollection perms; 
    private static final AstPolicy INSTANCE = new AstPolicy();    
    public final static String DEFAULT_ACTION = "accept";
    
    private AstPolicy() {
        super();
        if (perms == null) {            
            perms = (new SocketPermission("127.0.0.1", "accept"))
                    .newPermissionCollection();
        } 
    }
    
    public static AstPolicy getInstance() {
        return INSTANCE;
    }
    
    public PermissionCollection getPermissions() {        
        return perms;
    }    

    public void addPermission(Permission s) {        
        perms.add(s);
    }
    
    public void addPermissions(ServiceProperties sp) {
        List<InetAddress> onlyFromList = sp.getOnlyFrom();
        Iterator<InetAddress> onlyFromIterator = onlyFromList.iterator();
        while(onlyFromIterator.hasNext()) {            
            InetAddress currentInetAddress = onlyFromIterator.next();
            StringBuilder sb = new StringBuilder();            
            sb.append(currentInetAddress.getHostAddress());
            sb.append(":");
            sb.append(sp.getPort());
            perms.add(new SocketPermission(sb.toString(), DEFAULT_ACTION));                                  
        }
    }    
    
    public void clear() {
        perms = null;
    }
}

