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
