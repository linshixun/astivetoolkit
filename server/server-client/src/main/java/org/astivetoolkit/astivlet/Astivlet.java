/* 
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.astivlet;


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
  abstract protected void service(AstivletRequest request, AstivletResponse response);
}
