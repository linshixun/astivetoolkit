/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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

import com.phonytive.astive.agi.StringConverter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define the converter to be use in a parameter. For instance, arguments
 * in a array must be converted into a comma separated values
 * before you sent to Asterisk. Example:
 *
 * <p> The array <code>arg[] = {"a", "b", "c"}</code> will be converted in
 * <code>"a,b,c"</code>.
 *
 * <p>The default converter is {@link StringConverter}. However, for future
 * commands new converters can be define extending the class {@link Converter}.
 *
 * @since 1.0.0
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = java.lang.annotation.ElementType.FIELD)
public @interface ParamConverter {
    /**
     * Get the converter to be use in a parameter. The default converter is
     * {@link StringConverter}. However, for new commands new converters
     * can be define.
     *
     * @return converter to be use in a parameter.
     */
    public Class<?> converter() default StringConverter.class;
}
