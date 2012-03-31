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
            Method m = null;
            
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
