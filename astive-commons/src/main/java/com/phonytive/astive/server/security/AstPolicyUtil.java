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
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @since 1.0.0 
 */
public class AstPolicyUtil {
    static private PermissionCollection p = 
            AstPolicy.getInstance().getPermissions();
    
    static public boolean hasPermission(Permission s) {
        return p.implies(s);
    }

    static public boolean hasPermission(ServiceProperties sp) {
        List<InetAddress> onlyFromList = sp.getOnlyFrom();
        Iterator<InetAddress> onlyFromIterator = onlyFromList.iterator();
        while(onlyFromIterator.hasNext()) {            
            InetAddress currentInetAddress = onlyFromIterator.next();
            StringBuilder sb = new StringBuilder();            
            sb.append(currentInetAddress.getHostAddress());
            sb.append(":");
            sb.append(sp.getPort());

            boolean i = 
                    p.implies(new SocketPermission(sb.toString(), 
                        AstPolicy.DEFAULT_ACTION));
            if(i == true) {
                return true;
            }
        }
        return false;
    }    

}
