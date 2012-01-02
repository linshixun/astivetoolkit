// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.server.utils;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.App;
import com.phonytive.astive.server.AstiveException;
import com.phonytive.astive.server.appmanager.ApplicationManagerImpl;
import com.phonytive.astive.util.AppLocale;





/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class AstivletRunner {
    public static void invokeAstivlet(String appName, AstivletRequest request,
        AstivletResponse response) throws AstiveException {
        try {
            ApplicationManagerImpl appManager = ApplicationManagerImpl.getInstance();
            App app = appManager.getApp(appName);
            Astivlet entryPoint = app.getEntryPoint(app.getDefaultEntryPoint());
            entryPoint.onModuleLoad(request, response);
        } catch (NullPointerException ex) {
            throw new AstiveException(AppLocale.getI18n("resourceNotExist",
                    new Object[] { appName }));
        }
    }

    public static void invokeAstivlet(Astivlet entryPoint,
        AstivletRequest request, AstivletResponse response)
        throws AstiveException {
        entryPoint.onModuleLoad(request, response);
    }
}
