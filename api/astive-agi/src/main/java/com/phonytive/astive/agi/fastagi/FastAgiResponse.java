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
package com.phonytive.astive.agi.fastagi;

import com.phonytive.astive.agi.AgiCommandHandler;
import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;
import com.phonytive.astive.agi.ChannelStatus;
import com.phonytive.astive.agi.command.*;

import java.util.Date;
import java.util.TimeZone;


/**
 * Final implementation of {@link AgiResponse} use for Fastagi servers.
 *
 * @since 1.0.0
 * @see AgiResponse
 * @see AstivletResponse
 */
public class FastAgiResponse implements AgiResponse {
    /**
     * Handle communication with Asterisk, in the lowest level. Full info in
     * {@link AgiCommandHandler}.
     */
    private AgiCommandHandler cHandler;

    /**
     * Create a new FastAgiResponse with a {@link AgiCommandHandler} as a parameter.
     *
     * @param cHandler command handler.
     */
    public FastAgiResponse(AgiCommandHandler cHandler) {
        this.cHandler = cHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void answer() throws AgiException {
        Answer command = new Answer();
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void asyncAgiBreak() throws AgiException {
        AsyncAgiBreak command = new AsyncAgiBreak();
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChannelStatus getChannelStatus() throws AgiException {
        GetChannelStatus command = new GetChannelStatus();        
        int code = cHandler.sendAgiCommand(command).getResultCode();
        return ChannelStatus.get(code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChannelStatus getChannelStatus(String channel)
        throws AgiException {
        GetChannelStatus command = new GetChannelStatus(channel);
        int code = cHandler.sendAgiCommand(command).getStatus();

        return ChannelStatus.get(code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void controlStreamFile(String file) throws AgiException {
        ControlStreamFile command = new ControlStreamFile(file);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char controlStreamFile(String file, String escapeDigits)
        throws AgiException {
        ControlStreamFile command = new ControlStreamFile(file);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char controlStreamFile(String file, String escapeDigits, int offset)
        throws AgiException {
        ControlStreamFile command = new ControlStreamFile(file, escapeDigits,
                offset);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char controlStreamFile(String file, String escapeDigits, int offset,
        char forwardDigit, char rewindDigit, char pauseDigit)
        throws AgiException {
        ControlStreamFile command = new ControlStreamFile(file, escapeDigits,
                offset, forwardDigit, rewindDigit, pauseDigit);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void databaseDel(String family, String key)
        throws AgiException {
        DatabaseDel command = new DatabaseDel(family, key);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void databaseDelTree(String family) throws AgiException {
        DatabaseDelTree command = new DatabaseDelTree(family);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void databaseDelTree(String family, String keyTree)
        throws AgiException {
        DatabaseDelTree command = new DatabaseDelTree(family, keyTree);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String databaseGet(String family, String key)
        throws AgiException {
        DatabaseGet command = new DatabaseGet(family, key);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void databasePut(String family, String key, String value)
        throws AgiException {
        DatabasePut command = new DatabasePut(family, key, value);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exec(String application) throws AgiException {
        Exec command = new Exec(application);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exec(String application, String... args)
        throws AgiException {
        Exec command = new Exec(application, args);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getData(String file) throws AgiException {
        GetData command = new GetData(file);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getData(String file, int timeout) throws AgiException {
        GetData command = new GetData(file, timeout);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getData(String file, int timeout, int maxDigits)
        throws AgiException {
        GetData command = new GetData(file, timeout, maxDigits);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFullVariable(String variable) throws AgiException {
        GetFullVariable command = new GetFullVariable(variable);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFullVariable(String variable, String channel)
        throws AgiException {
        GetFullVariable command = new GetFullVariable(variable, channel);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getOption(String file, String escapeDigits)
        throws AgiException {
        GetOption command = new GetOption(file, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getOption(String file, String escapeDigits, int timeout)
        throws AgiException {
        GetOption command = new GetOption(file, escapeDigits, timeout);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVariable(String variable) throws AgiException {
        GetVariable command = new GetVariable(variable);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gosub(String context, String extension, String priority)
        throws AgiException {
        GoSub command = new GoSub(context, extension, priority);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gosub(String context, String extension, String priority,
        String... arguments) throws AgiException {
        GoSub command = new GoSub(context, extension, priority, arguments);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hangup() throws AgiException {
        Hangup command = new Hangup();
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void noop() throws AgiException {
        Noop command = new Noop();
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char receiveChar() throws AgiException {
        ReceiveChar command = new ReceiveChar();

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char receiveChar(int timeout) throws AgiException {
        ReceiveChar command = new ReceiveChar(timeout);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String receiveText() throws AgiException {
        ReceiveText command = new ReceiveText();

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String receiveText(int timeout) throws AgiException {
        ReceiveText command = new ReceiveText(timeout);

        return cHandler.sendAgiCommand(command).getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void recordFile(String file, String format)
        throws AgiException {
        RecordFile command = new RecordFile(file, format);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char recordFile(String file, String format, String escapeDigits)
        throws AgiException {
        RecordFile command = new RecordFile(file, format, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char recordFile(String file, String format, String escapeDigits,
        int timeout) throws AgiException {
        RecordFile command = new RecordFile(file, format, escapeDigits, timeout);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char recordFile(String file, String format, String escapeDigits,
        int timeout, int offset, boolean beep, int maxSilence)
        throws AgiException {
        RecordFile command = new RecordFile(file, format, escapeDigits,
                timeout, offset, beep, maxSilence);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayAlpha(String text) throws AgiException {
        SayAlpha command = new SayAlpha(text);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayAlpha(String text, String escapeDigits)
        throws AgiException {
        SayAlpha command = new SayAlpha(text);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayDate(Date date) throws AgiException {
        SayDate command = new SayDate(date);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayDate(Date date, String escapeDigits)
        throws AgiException {
        SayDate command = new SayDate(date, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayDatetime(Date datetime) throws AgiException {
        SayDatetime command = new SayDatetime(datetime);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayDatetime(Date datetime, String escapeDigits)
        throws AgiException {
        SayDatetime command = new SayDatetime(datetime, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayDatetime(Date datetime, String escapeDigits, String format)
        throws AgiException {
        SayDatetime command = new SayDatetime(datetime, escapeDigits, format);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayDatetime(Date datetime, String escapeDigits, String format,
        TimeZone timeZone) throws AgiException {
        SayDatetime command = new SayDatetime(datetime, escapeDigits, format,
                timeZone);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayDigits(String digits) throws AgiException {
        SayDigits command = new SayDigits(digits);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayDigits(String digits, String escapeDigits)
        throws AgiException {
        SayDigits command = new SayDigits(digits, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayNumber(int number) throws AgiException {
        SayNumber command = new SayNumber(number);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayNumber(int number, String escapeDigits)
        throws AgiException {
        SayNumber command = new SayNumber(number, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayPhonetic(String text) throws AgiException {
        SayPhonetic command = new SayPhonetic(text);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayPhonetic(String text, String escapeDigits)
        throws AgiException {
        SayPhonetic command = new SayPhonetic(text, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayTime(Date time) throws AgiException {
        SayTime command = new SayTime(time);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char sayTime(Date time, String escapeDigits)
        throws AgiException {
        SayTime command = new SayTime(time, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendImage(String image) throws AgiException {
        SendImage command = new SendImage(image);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendText(String text) throws AgiException {
        SendText command = new SendText(text);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAutoHangup(int time) throws AgiException {
        SetAutoHangup command = new SetAutoHangup(time);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCallerId(String callerId) throws AgiException {
        SetCallerId command = new SetCallerId(callerId);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContext(String context) throws AgiException {
        SetContext command = new SetContext(context);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExtension(String extension) throws AgiException {
        SetExtension command = new SetExtension(extension);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void musicOnHold(Boolean on) throws AgiException {
        SetMusic command = new SetMusic(on);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void musicOnHold(Boolean on, String musicClass)
        throws AgiException {
        SetMusic command = new SetMusic(on, musicClass);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPriority(String priority) throws AgiException {
        SetPriority command = new SetPriority(priority);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechActivateGrammar(String name) throws AgiException {
        SpeechActivateGrammar command = new SpeechActivateGrammar(name);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechCreate(String engine) throws AgiException {
        SpeechCreate command = new SpeechCreate(engine);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechDeactivateGrammar(String name) throws AgiException {
        SpeechDeactivateGrammar command = new SpeechDeactivateGrammar(name);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechDestroy() throws AgiException {
        SpeechDestroy command = new SpeechDestroy();
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechLoadGrammar(String name, String path)
        throws AgiException {
        SpeechLoadGrammar command = new SpeechLoadGrammar(name, path);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechSet(String name, String value) throws AgiException {
        SpeechSet command = new SpeechSet(name, value);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void speechUnloadGrammar(String name) throws AgiException {
        SpeechUnloadGrammar command = new SpeechUnloadGrammar(name);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void streamFile(String file) throws AgiException {
        StreamFile command = new StreamFile(file);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char streamFile(String file, String escapeDigits)
        throws AgiException {
        StreamFile command = new StreamFile(file, escapeDigits);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char streamFile(String file, String escapeDigits, int offset)
        throws AgiException {
        StreamFile command = new StreamFile(file, escapeDigits, offset);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTddMode(Boolean on) throws AgiException {
        TddMode command = new TddMode(on);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verbose(String message, int level) throws AgiException {
        Verbose command = new Verbose(message, level);
        cHandler.sendAgiCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char waitForDigit(int interDigitsTimeout) throws AgiException {
        WaitForDigit command = new WaitForDigit(interDigitsTimeout);

        return cHandler.sendAgiCommand(command).getResultCodeAsChar();
    }
}
