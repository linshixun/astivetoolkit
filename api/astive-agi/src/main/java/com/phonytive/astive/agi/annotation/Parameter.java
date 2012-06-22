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
package com.phonytive.astive.agi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation use to mark an field as a command parameter.
 *
 * <p>Keep in mind, that if a parameter is marked as optional and set as null
 * any subsequent parameter will be ignored.
 *
 * @since 1.0.0
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = java.lang.annotation.ElementType.FIELD)
public @interface Parameter {
    /**
     * Get the position of this parameter in a command. The position should be
     * repeated or an AgiException will be thrown.
     *
     * @return position of this parameter in a command. Default position is 0.
     */
    public short position() default 0;
    /**
     * Get the prefix of the parameter or and empty string is none is defined.
     *
     * @return prefix of the parameter.
     */
    public String prefix() default "";
    /**
     * Return whether or not a parameter is optional.
     *
     * @return true if parameter is option or false otherwise.
     */
    public boolean optional() default true;
}
