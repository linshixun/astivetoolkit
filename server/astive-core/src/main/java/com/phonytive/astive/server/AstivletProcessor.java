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
package com.phonytive.astive.server;

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.util.AppLocale;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 */
public class AstivletProcessor {

    private static final Logger logger = Logger.getLogger(AstivletProcessor.class);

    /**
     * DOCUMENT ME!
     *
     * @param appName DOCUMENT ME!
     * @param request DOCUMENT ME!
     * @param response DOCUMENT ME!
     *
     * @throws AstiveException DOCUMENT ME!
     */
    public static void invokeAstivlet(final AstivletRequest request, final AstivletResponse response)
            throws AstiveException {
        try {
            AstDB astDB = MyAstDB.getInstance();
            String script = "/" + request.getScript();

            if(script.split("\\?").length > 1) {
                script = script.split("\\?")[0];
            }
            
            Astivlet astivlet = astDB.getAstivlet(script);

            Class[] classParamTypes = new Class[2];
            classParamTypes[0] = AstivletRequest.class;
            classParamTypes[1] = AstivletResponse.class;
            
            Class c = Astivlet.class;
            
            Method m;
            m = c.getDeclaredMethod("service", classParamTypes);
            m.setAccessible(true);
            m.invoke(astivlet, new Object[]{request, response});            
        } catch (NoSuchMethodException ex) {            
            logger.warn(ex.getMessage());
        } catch (SecurityException ex) {            
            logger.warn(ex.getMessage());
        } catch (IllegalAccessException ex) {            
            logger.warn(ex.getMessage());
        } catch (IllegalArgumentException ex) {            
            logger.warn(ex.getMessage());
        } catch (InvocationTargetException ex) {            
            logger.warn(ex.getMessage());
        } catch (NullPointerException ex) {
            throw new AstiveException(AppLocale.getI18n("resourceNotExist",
                    new Object[]{"/" + request.getScript()}));
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
        try {
            Class[] classParamTypes = new Class[2];
            classParamTypes[0] = AstivletRequest.class;
            classParamTypes[1] = AstivletResponse.class;
            
            Class c = Astivlet.class;
            Method m = null;

            m = c.getDeclaredMethod("service", classParamTypes);
            m.setAccessible(true);
            m.invoke(astivlet, new Object[]{request, response});
        } catch (NoSuchMethodException ex) {
            logger.warn(AppLocale.getI18n(ex.getMessage()));
        } catch (SecurityException ex) {
            logger.warn(AppLocale.getI18n(ex.getMessage()));
        } catch (IllegalAccessException ex) {
            logger.warn(AppLocale.getI18n(ex.getMessage()));
        } catch (IllegalArgumentException ex) {
            logger.warn(AppLocale.getI18n(ex.getMessage()));
        } catch (InvocationTargetException ex) {
            logger.warn(AppLocale.getI18n(ex.getMessage()));
        }
    }
}
