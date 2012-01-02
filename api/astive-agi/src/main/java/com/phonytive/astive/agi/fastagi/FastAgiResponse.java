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
package com.phonytive.astive.agi.fastagi;

import com.phonytive.astive.agi.AgiCommandReply;
import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;
import com.phonytive.astive.agi.command.AgiCommandFactory;
import com.phonytive.astive.agi.command.AgiCommandHandler;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see AgiResponse
 * @see AstivletResponse
 */
public class FastAgiResponse implements AgiResponse {
    private AgiCommandHandler cHandler;
    private AgiCommandFactory cFactory;

    public FastAgiResponse(AgiCommandHandler cHandler) {
        this.cHandler = cHandler;
        cFactory = AgiCommandFactory.getInstance();
    }

    @Override
    public void answer() throws AgiException {
        cHandler.sendAgiCommand(cFactory.createAnswer());
    }

    @Override
    public int getChannelStatus() throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createAnswer()).getResultCode();
    }

    @Override
    public String getData(String file) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createGetData(file)).getResult();
    }

    @Override
    public String getData(String file, int timeout) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createGetData(file, timeout))
                       .getResult();
    }

    @Override
    public String getData(String file, int timeout, int maxDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createGetData(file, timeout))
                       .getResult();
    }

    @Override
    public char getOption(String file, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createGetOption(file,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public char getOption(String file, String escapeDigits, int timeout)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createGetOption(file,
                escapeDigits, timeout)).getResultCodeAsChar();
    }

    @Override
    public void hangup() throws AgiException {
        AgiCommandReply reply = cHandler.sendAgiCommand(cFactory.createHangup());
    }

    @Override
    public char receiveChar(int timeout) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createReceiveChar(timeout))
                       .getResultCodeAsChar();
    }

    @Override
    public String receiveText(int timeout) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createReceiveText(timeout))
                       .getResult();
    }

    @Override
    public void recordFile(String file, String format)
        throws AgiException {
        cHandler.sendAgiCommand(cFactory.createRecordFile(file, format));
    }

    @Override
    public char recordFile(String file, String format, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createRecordFile(file, format,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public char recordFile(String file, String format, String escapeDigits,
        int timeout) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createRecordFile(file, format,
                escapeDigits, timeout)).getResultCodeAsChar();
    }

    @Override
    public char recordFile(String file, String format, String escapeDigits,
        int timeout, int offset, boolean beep, int maxSilence)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createRecordFile(file, format,
                escapeDigits, timeout, offset, beep, maxSilence))
                       .getResultCodeAsChar();
    }

    @Override
    public void sayAlpha(String text) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayAlpha(text));
    }

    @Override
    public char sayAlpha(String text, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayAlpha(text,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public void sayDigits(String text) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayDigits(text));
    }

    @Override
    public char sayDigits(String text, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayDigits(text,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public void sayNumber(String text) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayNumber(text));
    }

    @Override
    public char sayNumber(String text, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayNumber(text,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public void sayPhonetic(String text) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayPhonetic(text));
    }

    @Override
    public char sayPhonetic(String text, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayPhonetic(text,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public void sayDate(long time) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayDate(time));
    }

    @Override
    public char sayDate(long time, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayDate(time, escapeDigits))
                       .getResultCodeAsChar();
    }

    @Override
    public void sayTime(long time) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayTime(time));
    }

    @Override
    public char sayTime(long time, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayTime(time, escapeDigits))
                       .getResultCodeAsChar();
    }

    @Override
    public void sayDateTime(long time) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSayDateTime(time));
    }

    @Override
    public char sayDateTime(long time, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayDateTime(time,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public char sayDateTime(long time, String escapeDigits, String format)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayDateTime(time,
                escapeDigits, format)).getResultCodeAsChar();
    }

    @Override
    public char sayDateTime(long time, String escapeDigits, String format,
        String timezone) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createSayDateTime(time,
                escapeDigits, format, timezone)).getResultCodeAsChar();
    }

    @Override
    public void sendImage(String image) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSendImage(image));
    }

    @Override
    public void setContext(String context) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSetContext(context));
    }

    @Override
    public void setExtension(String extension) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSetExtension(extension));
    }

    @Override
    public void setPriority(String priority) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSetPriority(priority));
    }

    @Override
    public void musicOnHoldEnabled(boolean enable) throws AgiException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void musicOnHold(String musicClass) throws AgiException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAutoHangup(int time) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSetAutoHangup(time));
    }

    @Override
    public void setCallerId(String callerId) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSetCallerId(callerId));
    }

    @Override
    public void streamFile(String file) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createStreamFile(file));
    }

    @Override
    public char streamFile(String file, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createStreamFile(file,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public char streamFile(String file, String escapeDigits, int offset)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createStreamFile(file,
                escapeDigits, offset)).getResultCodeAsChar();
    }

    @Override
    public void controlStreamFile(String file) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createStreamFile(file));
    }

    @Override
    public char controlStreamFile(String file, String escapeDigits)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createStreamFile(file,
                escapeDigits)).getResultCodeAsChar();
    }

    @Override
    public char controlStreamFile(String file, String escapeDigits, int offset)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createStreamFile(file,
                escapeDigits, offset)).getResultCodeAsChar();
    }

    @Override
    public char controlStreamFile(String file, String escapeDigits, int offset,
        String forwardDigit, String rewindDigit, String pauseDigit)
        throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createControlStreamFile(file,
                escapeDigits, offset, forwardDigit, rewindDigit, pauseDigit))
                       .getResultCodeAsChar();
    }

    @Override
    public char waitForDigit(int interDigitsTimeout) throws AgiException {
        return cHandler.sendAgiCommand(cFactory.createWaitForDigit(
                interDigitsTimeout)).getResultCodeAsChar();
    }

    @Override
    public void speechCreate() throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSpeechCreate());
    }

    @Override
    public void speechCreate(String engine) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSpeechCreate(engine));
    }

    @Override
    public void speechSet(String name, String value) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSpeechSet(name, value));
    }

    @Override
    public void speechLoadGrammar(String label, String path)
        throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSpeechLoadGrammar(label, path));
    }

    @Override
    public void speechActivateGrammar(String label) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSpeechActivateGrammar(label));
    }

    @Override
    public void speechDeactivateGrammar(String label) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createSpeechDeactivateGrammar(label));
    }

    @Override
    public void gosub(String context, String extension, String priority)
        throws AgiException {
        cHandler.sendAgiCommand(cFactory.createGoSub(context, extension,
                priority));
    }

    @Override
    public void gosub(String context, String extension, String priority,
        String... arguments) throws AgiException {
        cHandler.sendAgiCommand(cFactory.createGoSub(context, extension,
                priority, arguments));
    }
}
