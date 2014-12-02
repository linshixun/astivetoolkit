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
package org.astivetoolkit.examples.astivejs;

import static java.lang.System.out;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.astivlet.AstivletRequest;
import org.astivetoolkit.astivlet.AstivletResponse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Hello, World! example.
 *
 * @since 1.0
 */
public class App extends Astivlet {
    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            TTSHelper tts = TTSHelper.getInstance();
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            // Or you can check for importClass function and then load if missing ...
            engine.eval("load('nashorn:mozilla_compat.js')");
            engine.eval("importPackage(Packages.org.astivetoolkit.menu)");
            engine.eval("importPackage(Packages.org.astivetoolkit.astivlet)");
            engine.eval("importPackage(Packages.org.astivetoolkit.agi)");
            engine.eval("importPackage(org.astivetoolkit.examples.astivejs)"); // Not sure if I have to do this
            engine.put("request", request);
            engine.put("response", response);
            engine.put("tts", tts);
            // Define less verbose functions
            engine.eval("function answer() {response.answer()}");
            engine.eval("function hangup() {response.hangup()}");
            engine.eval("function play(file) {response.streamFile(file)}");
            engine.eval("function say(text) {tts.generate(text);play(tts.getFilename(text))}");
            engine.eval("function redirect(ext) {return 'nop'}");
            engine.eval("function record() {print('nop')}");

            String jsPath = request.getQueryParameter("jsPath");
            engine.eval(new FileReader(jsPath));
        } catch (ScriptException e) {
            out.print(e.getStackTrace());
        } catch (FileNotFoundException e) {
            out.print(e.getStackTrace());
        } catch (Exception e) {
            out.print(e.getStackTrace());
        }
    }
}
