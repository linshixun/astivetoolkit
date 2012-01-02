// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.astivlet;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;

/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see AstivletRequest
 */
public class AstivletResponse implements AgiResponse {

    private AgiResponse response;

    // By doing this we have an AgiResponse independent of the actual
    // implementation(ie.: FastAgiResponse).
    public AstivletResponse(AgiResponse response) {
        this.response = response;
    }

    @Override
    public void answer() throws AgiException {
        response.answer();
    }

    @Override
    public int getChannelStatus() throws AgiException {
        return response.getChannelStatus();
    }

    @Override
    public String getData(String file) throws AgiException {
        return response.getData(file);
    }

    @Override
    public String getData(String file, int timeout) throws AgiException {
        return response.getData(file, timeout);
    }

    @Override
    public String getData(String file, int timeout, int maxDigits) throws AgiException {
        return response.getData(file, timeout, maxDigits);
    }

    @Override
    public char getOption(String file, String escapeDigits) throws AgiException {
        return response.getOption(file, escapeDigits);
    }

    @Override
    public char getOption(String file, String escapeDigits, int timeout) throws AgiException {
        return response.getOption(file, escapeDigits, timeout);
    }

    @Override
    public void hangup() throws AgiException {
        response.hangup();
    }

    @Override
    public char receiveChar(int timeout) throws AgiException {
        return response.receiveChar(timeout);
    }

    @Override
    public String receiveText(int timeout) throws AgiException {
        return response.receiveText(timeout);
    }

    @Override
    public void recordFile(String file, String format) throws AgiException {
        response.recordFile(file, format);
    }

    @Override
    public char recordFile(String file, String format, String escapeDigits) throws AgiException {
        return response.recordFile(file, format, escapeDigits);
    }

    @Override
    public char recordFile(String file, String format, String escapeDigits, int timeout) throws AgiException {
        return response.recordFile(file, format, escapeDigits, timeout);
    }

    @Override
    public char recordFile(String file, String format, String escapeDigits,
            int timeout, int offset, boolean beep, int maxSilence) throws AgiException {
        return response.recordFile(file, format, escapeDigits, timeout,
                offset, beep, maxSilence);
    }

    @Override
    public void sayAlpha(String text) throws AgiException {
        response.sayAlpha(text);
    }

    @Override
    public char sayAlpha(String text, String escapeDigits) throws AgiException {
        return response.sayAlpha(text, escapeDigits);
    }

    @Override
    public void sayDigits(String text) throws AgiException {
        response.sayDigits(text);
    }

    @Override
    public char sayDigits(String text, String escapeDigits) throws AgiException {
        return response.sayDigits(text, escapeDigits);
    }

    @Override
    public void sayNumber(String text) throws AgiException {
        response.sayDigits(text);
    }

    @Override
    public char sayNumber(String text, String escapeDigits) throws AgiException {
        return response.sayNumber(text, escapeDigits);
    }

    @Override
    public void sayPhonetic(String text) throws AgiException {
        response.sayPhonetic(text);
    }

    @Override
    public char sayPhonetic(String text, String escapeDigits) throws AgiException {
        return response.sayPhonetic(text, escapeDigits);
    }

    @Override
    public void sayDate(long time) throws AgiException {
        response.sayDate(time);
    }

    @Override
    public char sayDate(long time, String escapeDigits) throws AgiException {
        return response.sayDate(time, escapeDigits);
    }

    @Override
    public void sayTime(long time) throws AgiException {
        response.sayDate(time);
    }

    @Override
    public char sayTime(long time, String escapeDigits) throws AgiException {
        return response.sayDate(time, escapeDigits);
    }

    @Override
    public void sayDateTime(long time) throws AgiException {
        response.sayDate(time);
    }

    @Override
    public char sayDateTime(long time, String escapeDigits) throws AgiException {
        return response.sayDateTime(time, escapeDigits);
    }

    @Override
    public char sayDateTime(long time, String escapeDigits, String format) throws AgiException {
        return response.sayDateTime(time, escapeDigits, format);
    }

    @Override
    public char sayDateTime(long time, String escapeDigits, String format, String timezone) throws AgiException {
        return response.sayDateTime(time, escapeDigits, format, timezone);
    }

    @Override
    public void sendImage(String image) throws AgiException {
        response.sendImage(image);
    }

    @Override
    public void setContext(String context) throws AgiException {
        response.setContext(context);
    }

    @Override
    public void setExtension(String extension) throws AgiException {
        response.setExtension(extension);
    }

    @Override
    public void setPriority(String priority) throws AgiException {
        response.setExtension(priority);
    }

    @Override
    public void musicOnHoldEnabled(boolean enable) throws AgiException {
        response.musicOnHoldEnabled(enable);
    }

    @Override
    public void musicOnHold(String musicClass) throws AgiException {
        response.musicOnHold(musicClass);
    }

    @Override
    public void setAutoHangup(int time) throws AgiException {
        response.setAutoHangup(time);
    }

    @Override
    public void setCallerId(String callerId) throws AgiException {
        response.setCallerId(callerId);
    }

    @Override
    public void streamFile(String file) throws AgiException {
        response.streamFile(file);
    }

    @Override
    public char streamFile(String file, String escapeDigits) throws AgiException {
        return response.streamFile(file, escapeDigits);
    }

    @Override
    public char streamFile(String file, String escapeDigits, int offset) throws AgiException {
        return response.streamFile(file, escapeDigits, offset);
    }

    @Override
    public void controlStreamFile(String file) throws AgiException {
        response.controlStreamFile(file);
    }

    @Override
    public char controlStreamFile(String file, String escapeDigits) throws AgiException {
        return response.controlStreamFile(file, escapeDigits);
    }

    @Override
    public char controlStreamFile(String file, String escapeDigits, int offset) throws AgiException {
        return response.controlStreamFile(file, escapeDigits, offset);
    }

    @Override
    public char controlStreamFile(String file, String escapeDigits, int offset, String forwardDigit, String rewindDigit, String pauseDigit) throws AgiException {
        return response.controlStreamFile(file, escapeDigits, offset,
                forwardDigit, rewindDigit, pauseDigit);
    }

    @Override
    public char waitForDigit(int interDigitsTimeout) throws AgiException {
        return response.waitForDigit(interDigitsTimeout);
    }

    @Override
    public void speechCreate() throws AgiException {
        response.speechCreate();
    }

    @Override
    public void speechCreate(String engine) throws AgiException {
        response.speechCreate(engine);
    }

    @Override
    public void speechSet(String name, String value) throws AgiException {
        response.speechSet(name, value);
    }

    @Override
    public void speechLoadGrammar(String label, String path) throws AgiException {
        response.speechLoadGrammar(label, path);
    }

    @Override
    public void speechActivateGrammar(String label) throws AgiException {
        response.speechActivateGrammar(label);
    }

    @Override
    public void speechDeactivateGrammar(String label) throws AgiException {
        response.speechDeactivateGrammar(label);
    }

    @Override
    public void gosub(String context, String extension, String priority) throws AgiException {
        response.gosub(context, extension, priority);
    }

    @Override
    public void gosub(String context, String extension, String priority, String... arguments) throws AgiException {
        response.gosub(context, extension, priority, arguments);
    }
}
