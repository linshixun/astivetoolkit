/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phonytive.astive.server.utils;

import com.phonytive.astive.Version;
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
}
