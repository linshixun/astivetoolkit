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

import com.phonytive.astive.astivlet.Astivlet;
import java.util.List;

/**
 * Help manage Astive app objects.
 * 
 * @since 1.0.0 
 */
public interface AstDB {
    
    /**
     * Get an Astive app object.
     * 
     * @return Astive app object
     */
    public AstObj getApp(String deploymentId) throws AstiveException;
    
    /**
     * Use to add apps to the database index. The final implementation must
     * ensure that a new app don't override old app URL's.
     * 
     * @param astObj object to add.
     */
    public void addApp(AstObj astObj) throws AstiveException;
    
    /**
     * Remove app from index. The final implementation must ensure remove
     * astivlets from de index of apps.
     * 
     * @param astObj app to remove.
     */
    public void removeApp(AstObj astObj) throws AstiveException;
    
    /**
     * List apps in the db index.
     * 
     * @return app list.
     */
    public List<AstObj> getApps() throws AstiveException;
    
    /**
     * Get astivlet by using it url.
     * 
     * @param urlStr url of requested astivlet.
     * @return requested astivlet.
     */
    public Astivlet getAstivlet(String urlStr) throws AstiveException;
    
    /**
     * Get a list the URL's index.
     * 
     * @return URL's index list.
     */
    public String[] getAstivletsURLs() throws AstiveException;
    
    /**
   * 
   * @param deploymentId
   * @return 
   */
    public Boolean appExist(String deploymentId);
}
