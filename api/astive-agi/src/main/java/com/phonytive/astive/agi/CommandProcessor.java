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
package com.phonytive.astive.agi;

import com.phonytive.astive.agi.annotation.*;
import com.phonytive.astive.util.AppLocale;
import java.lang.reflect.Field;
import java.util.*;
import org.apache.log4j.Logger;


/**
 * This class is a helper. Can be use to extract meta information from Agi
 * commands classes and then construct commands in string format.
 *
 * @since 1.0.0
 */
public class CommandProcessor {
    /**
     * Usual logger.
     */
    private static final Logger logger = Logger.getLogger(CommandProcessor.class);

    /**
     * Get all fields marked with annotation @Parameter in a class marked with
     * annotation annotation @Command.
     *
     * @param o object to analyze.
     * @return list of parameters
     * @throws AgiException
     */
    private static ArrayList getParameters(Object o) throws AgiException {
        ArrayList parameters = new ArrayList();
        HashMap hmParameters = new HashMap();

        try {
            Field[] fs = o.getClass().getDeclaredFields();

            for (Field f : fs) {
                f.setAccessible(true);

                if (f.getAnnotation(Parameter.class) != null) {
                    // Then this field is a parameter
                    Parameter p = f.getAnnotation(Parameter.class);
                    int order = p.position();
                    Object c = f.get(o);

                    // This avoid automatic cast to string
                    if (c != null) {
                        hmParameters.put(order, f);
                    } else {
                        // Ignore any other parameter, since it break the
                        // secuense. Also write a Warning to alert the
                        // developers about that issue.
                        logger.warn(AppLocale.getI18n(
                                "ignoringSubsequentParameters"));

                        break;
                    }
                }
            }

            Object[] keysArr = hmParameters.keySet().toArray();
            Arrays.sort(keysArr);

            for (Object i : keysArr) {
                parameters.add(hmParameters.get(i));
            }
        } catch (SecurityException ex) {
            throw new AgiException(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new AgiException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new AgiException(ex.getMessage());
        }

        return parameters;
    }

    /**
     * Build a command from a class marked with annotation @{@link AgiCommand}.
     *
     * @param o object to in command generation.
     * @return command as string.
     * @throws AgiException
     */
    public static String buildCommand(Object o) throws AgiException {
        AgiCommand command = o.getClass().getAnnotation(AgiCommand.class);

        if (command == null) {
            throw new AgiException(AppLocale.getI18n("notACommandObject"));
        }

        ArrayList<Field> parameters = getParameters(o);

        StringBuilder cmd = new StringBuilder(command.command());

        if (parameters == null) {
            return command.command();
        }

        for (Field field : parameters) {
            Parameter p = field.getAnnotation(Parameter.class);
            Object param = null;

            try {
                param = field.get(o);
            } catch (IllegalArgumentException ex) {
                throw new AgiException();
            } catch (IllegalAccessException ex) {
                throw new AgiException();
            }

            // Separate parameters
            cmd.append(" ");

            if (param instanceof String || param instanceof Character) {
                if(param instanceof Character) {
                    Character c = (Character) param;
                    if(!c.toString().trim().equals("")) {
                        cmd.append("\"");                                
                        cmd.append(c);
                        cmd.append("\"");
                    }
                } else {
                    cmd.append("\"");                                
                    cmd.append(param.toString().trim());
                    cmd.append("\"");
                }
            } else if (param.getClass().isArray()) {
                if (!field.isAnnotationPresent(ParamConverter.class)) {
                    throw new AgiException(AppLocale.getI18n(
                            "cantFoundAnnotation",
                            new Object[] { ParamConverter.class }));
                } else if (!field.isAnnotationPresent(Separator.class)) {
                    throw new AgiException(AppLocale.getI18n(
                            "cantFoundAnnotation",
                            new Object[] { Separator.class }));
                }

                ParamConverter pc = field.getAnnotation(ParamConverter.class);
                Separator separator = field.getAnnotation(Separator.class);
                StringConverter sc;

                try {
                    sc = (StringConverter) pc.converter().newInstance();

                    String[] paramArr = (String[]) param;
                    String paramStr = sc.fromArrayString(paramArr,
                            separator.value());
                    cmd.append("\"");
                    cmd.append(paramStr);
                    cmd.append("\"");
                } catch (InstantiationException ex) {
                    throw new AgiException(ex.getMessage());
                } catch (IllegalAccessException ex) {
                    throw new AgiException(ex.getMessage());
                }
            } else if (param instanceof Boolean) {
                if (!field.isAnnotationPresent(ParamConverter.class)) {
                    throw new AgiException(AppLocale.getI18n(
                            "cantFoundAnnotation"));
                } else if (!field.isAnnotationPresent(BooleanChoose.class)) {
                    throw new AgiException(AppLocale.getI18n(
                            "cantFoundAnnotation",
                            new Object[] { Separator.class }));
                }

                // XXX: Move this to a converter.
                BooleanChoose bc = field.getAnnotation(BooleanChoose.class);

                String t = bc.valueOnFalse();
                Boolean b = (Boolean) param;

                if (b == true) {
                    t = bc.valueOnTrue();
                }

                cmd.append("\"");
                cmd.append(t);
                cmd.append("\"");
            } else if (param instanceof Date) {
                if (!field.isAnnotationPresent(ParamConverter.class)) {
                    throw new AgiException(AppLocale.getI18n(
                            "cantFoundAnnotation"));
                }

                // TODO: Move this to a converter.
                Date date = (Date) param;
                long seconds = date.getTime() / 1000;
                cmd.append("\"");
                cmd.append(seconds);
                cmd.append("\"");
            } else if (param instanceof TimeZone) {
                if (!field.isAnnotationPresent(ParamConverter.class)) {
                    throw new AgiException(AppLocale.getI18n(
                            "cantFoundAnnotation"));
                }

                // TODO: Move this to a converter.
                TimeZone tz = (TimeZone) param;
                String id = tz.getID();
                cmd.append("\"");
                cmd.append(id);
                cmd.append("\"");
            } else {
                if (!p.prefix().equals("")) {
                    cmd.append("\"");
                    cmd.append(p.prefix());
                    cmd.append(param);
                    cmd.append("\"");
                } else {
                    cmd.append(param);
                }
            }
        }

        return cmd.toString().trim();
    }

    private CommandProcessor() {
    }
}
