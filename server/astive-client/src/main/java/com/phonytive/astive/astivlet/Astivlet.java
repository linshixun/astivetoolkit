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
package com.phonytive.astive.astivlet;

/**
 * Defines methods that all astivle's must implement.
 * 
 * <p>A astivlet is a small Java program that runs within a Astive Server. 
 * Astivlets receive and respond to requests from Telephone systems like 
 * Asterisk. 
 * 
 * @see AstivletRequest
 * @see AstivletResponse
 * @since 1.0.0
 */
public abstract class Astivlet {

    /**
     * Called by Astive Server to allow the astivlet to respond to a request.
     *
     * @param request object that contains the client's request
     * @param response object that contains the astivle's response
     */
    protected void service(AstivletRequest request,
            AstivletResponse response) {
    }
}
