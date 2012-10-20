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
package com.phonytive.astive.server.utils;

import com.phonytive.astive.Version;
import com.phonytive.astive.server.ServiceProperties;
import com.phonytive.astive.util.AppLocale;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 * Print the start info.
 *
 * @since 1.0.0
 */
public class InitOutput {

    /**
     * Print the start info.
     *
     * @param properties info to be printed.
     */
    public static void printInit(ArrayList<ServiceProperties> properties) {
        // TODO: Programmatically include the build and the version
        
        StringBuilder sb = new StringBuilder(AppLocale.getI18n("init.header", new String[]{Version.VERSION, Version.BUILD_TIME}));
        
        for (ServiceProperties param : properties) {            
            if (param.isDisabled()) {
                continue;
            }
            // This is not elegant but work !
            if (param.getServiceName().length() > 7) {
                sb.append(param.getServiceName());
                sb.append("\t");
            } else {
                sb.append(param.getServiceName());
                sb.append("\t\t");
            }
            sb.append(param.getBindAddr().getHostAddress());
            sb.append("\t");
            if(param.isUnableToOpen()) {
                sb.append(AppLocale.getI18n("unableToOpen"));
            } else {
                sb.append(param.getPort());
            }
            sb.append("\n");
        }

        sb.append(AppLocale.getI18n("init.footer"));
        out.println(sb.toString());
    }

    private InitOutput() {
    }
}
