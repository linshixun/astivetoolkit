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
package com.phonytive.astive.server.test;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import static java.lang.System.out;

/**
 * Final implementation for {@link Astivlet} class.
 * 
 * @since 1.0.0
 */
public class MyAstivlet extends Astivlet {

    /**
     * Entry point for {@link Astivlet}.
     *
     * @param request info sent from Asterisk server.
     * @param response info to send to Asterisk.
     */
    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();
            String data = response.getData("tt-monkeys");            
            response.hangup();
        } catch (AgiException ex) {
            out.println(ex.getMessage());
        }
    }
}
