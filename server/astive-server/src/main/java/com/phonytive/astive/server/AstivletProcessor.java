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
package com.phonytive.astive.server;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.appmanager.DeployerManager;
import com.phonytive.astive.util.AppLocale;


/**
 *
 * @since 1.0.0
 */
public class AstivletProcessor {
    /**
     * DOCUMENT ME!
     *
     * @param appName DOCUMENT ME!
     * @param request DOCUMENT ME!
     * @param response DOCUMENT ME!
     *
     * @throws AstiveException DOCUMENT ME!
     */
    public static void invokeAstivlet(String appId, String astivletId ,
            AstivletRequest request, AstivletResponse response) throws AstiveException {
        try {
            DeployerManager appManager = DeployerManager.getInstance();
            
            // Locate AstObj by path
            AstObj app = appManager.getApp(appId);
            Astivlet astivlet = app.getAstivlet(astivletId);
            
            // TODO: Execute throught reflection
            astivlet.service(request, response);
        } catch (NullPointerException ex) {
            throw new AstiveException(AppLocale.getI18n("resourceNotExist",
                    new Object[] { astivletId }));
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param entryPoint DOCUMENT ME!
     * @param request DOCUMENT ME!
     * @param response DOCUMENT ME!
     *
     * @throws AstiveException DOCUMENT ME!
     */
    public static void invokeAstivlet(Astivlet astivlet,
        AstivletRequest request, AstivletResponse response)
        throws AstiveException {
        astivlet.service(request, response);
    }
}
