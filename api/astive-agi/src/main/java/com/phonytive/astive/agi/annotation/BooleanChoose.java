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
package com.phonytive.astive.agi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation use to define the value expected by Asterisk on a boolean value.
 * For instance the command {@link RecordFile} expect a "BEEP" when the parameter
 * beep is set to true.
 *
 * <p>This annotation should be used in combination with {@link Parameter} and
 * {@link ParamConverter}.
 *
 * @since 1.0.0
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = java.lang.annotation.ElementType.FIELD)
public @interface BooleanChoose {
    /**
     * Get string value for a true.
     *
     * @return string value for a true. The default value is "ON".
     */
    public String valueOnTrue() default "ON";
    /**
     * Get string value for a false.
     *
     * @return string value for a false. The default value is "OFF".
     */
    public String valueOnFalse() default "OFF";
}
