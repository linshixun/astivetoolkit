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

import java.security.Permission;
import java.security.PermissionCollection;

/**
 * Utility use to verified whether or not a permission is part of the collection
 * of permissions store in {@link AstPolicy}.
 * 
 * @see AstPolicy 
 * @since 1.0.0  
 */
public class AstPolicyUtil {
    static private PermissionCollection p = 
            AstPolicy.getInstance().getPermissions();
    
    /**
     * Verified if a particular permission is granted in {@link AstPolicy}
     * 
     * @param permission to be checked.
     * @return true if permission is store in {@link AstPolicy}, false otherwise.
     */
    static public boolean hasPermission(Permission permission) {
        return p.implies(permission);
    }

    private AstPolicyUtil() {
    }
}
