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
package com.phonytive.astive.agi.command;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see AgiCommand
 * @see AgiCommandHandler
 */

// Variation of the Factory pattern
public class AgiCommandFactory {
    private static AgiCommandFactory INSTANCE = new AgiCommandFactory();

    private AgiCommandFactory() {
    }

    public static AgiCommandFactory getInstance() {
        return INSTANCE;
    }

    public AgiCommand createAnswer() {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = buildString(Command.ANSWER, null);

                    return cmd;
                }
            };
    }

    public AgiCommand createGetChannelStatus() {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = buildString(Command.CHANNEL_STATUS, null);

                    return cmd;
                }
            };
    }

    public AgiCommand createGetData(final String file) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file };
                    String cmd = buildString(Command.GET_DATA, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createGetData(final String file, final int timeout) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, timeout };
                    String cmd = buildString(Command.GET_DATA, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createGetData(final String file, final int timeout,
        final int maxDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, timeout };
                    String cmd = buildString(Command.GET_DATA, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createGetOption(final String file,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createGetOption(file, escapeDigits, -1)
                                     .buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createGetOption(final String file,
        final String escapeDigits, final int timeout) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, timeout };
                    String cmd = buildString(Command.GET_OPTION, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createHangup() {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = buildString(Command.HANGUP, null);

                    return cmd;
                }
            };
    }

    public AgiCommand createReceiveChar(final int timeout) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = buildString(Command.RECEIVE_CHAR, null);

                    return cmd;
                }
            };
    }

    public AgiCommand createReceiveText(final int timeout) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = buildString(Command.RECEIVE_TEXT, null);

                    return cmd;
                }
            };
    }

    public AgiCommand createRecordFile(final String file, final String format) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createRecordFile(file, format, "")
                                     .buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createRecordFile(final String file, final String format,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createRecordFile(file, format, escapeDigits, -1)
                                     .buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createRecordFile(final String file, final String format,
        final String escapeDigits, final int timeout) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, format, escapeDigits, timeout };
                    String cmd = buildString(Command.RECORD_FILE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createRecordFile(final String file, final String format,
        final String escapeDigits, final int timeout, final int offset,
        final boolean beep, final int maxSilence) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = {
                            file, format, escapeDigits, timeout, offset, beep,
                            maxSilence
                        };
                    String cmd = buildString(Command.RECORD_FILE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayAlpha(final String text) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, "" };
                    String cmd = buildString(Command.SAY_ALPHA, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayAlpha(final String text,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, escapeDigits };
                    String cmd = buildString(Command.SAY_ALPHA, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDigits(final String text) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, "" };
                    String cmd = buildString(Command.SAY_DIGITS, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDigits(final String text,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, escapeDigits };
                    String cmd = buildString(Command.SAY_DIGITS, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayNumber(final String text) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, "" };
                    String cmd = buildString(Command.SAY_NUMBER, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayNumber(final String text,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, escapeDigits };
                    String cmd = buildString(Command.SAY_NUMBER, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayPhonetic(final String text) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, "" };
                    String cmd = buildString(Command.SAY_PHONETIC, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayPhonetic(final String text,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { text, escapeDigits };
                    String cmd = buildString(Command.SAY_PHONETIC, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDate(final long time) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createSayDate(time, "").buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDate(final long time, final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { time, escapeDigits };
                    String cmd = buildString(Command.SAY_DATE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayTime(final long time) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createSayTime(time, "").buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createSayTime(final long time, final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { time, escapeDigits };
                    String cmd = buildString(Command.SAY_TIME, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDateTime(final long time) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createSayDateTime(time, "", "", "")
                                     .buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDateTime(final long time,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createSayDateTime(time, escapeDigits, "", "")
                                     .buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDateTime(final long time,
        final String escapeDigits, final String format) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createSayDateTime(time, escapeDigits, format,
                            "").buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createSayDateTime(final long time,
        final String escapeDigits, final String format, final String timezone) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { time, escapeDigits, format, timezone };
                    String cmd = buildString(Command.SAY_DATETIME, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSendImage(final String image) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { image };
                    String cmd = buildString(Command.SEND_IMAGE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSetContext(final String context) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { context };
                    String cmd = buildString(Command.SET_CONTEXT, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSetExtension(final String extension) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { extension };
                    String cmd = buildString(Command.SET_EXTENSION, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSetPriority(final String priority) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { priority };
                    String cmd = buildString(Command.SET_PRIORITY, params);

                    return cmd;
                }
            };
    }

    //void musicOnHoldEnabled(boolean enable) throws AgiException;

    //void musicOnHold(String musicClass) throws AgiException;
    public AgiCommand createSetAutoHangup(final int time) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { time };
                    String cmd = buildString(Command.SET_AUTOHANGUP, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSetCallerId(final String callerId) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    return null;
                }
            };
    }

    public AgiCommand createStreamFile(final String file,
        final String scapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createStreamFile(file, scapeDigits, -1)
                                     .buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createStreamFile(final String file) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createStreamFile(file, "", -1).buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createStreamFile(final String file,
        final String scapeDigits, final int offset) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, scapeDigits, offset };
                    String cmd = buildString(Command.STREAM_FILE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createControlStreamFile(final String file) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, "", -1, "", "", "" };
                    String cmd = buildString(Command.CONTROL_STREAM_FILE,
                            params);

                    return cmd;
                }
            };
    }

    public AgiCommand createControlStreamFile(final String file,
        final String escapeDigits) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, escapeDigits, -1, "", "", "" };
                    String cmd = buildString(Command.CONTROL_STREAM_FILE,
                            params);

                    return cmd;
                }
            };
    }

    public AgiCommand createControlStreamFile(final String file,
        final String escapeDigits, final int offset) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { file, escapeDigits, offset, "", "", "" };
                    String cmd = buildString(Command.CONTROL_STREAM_FILE,
                            params);

                    return cmd;
                }
            };
    }

    public AgiCommand createControlStreamFile(final String file,
        final String escapeDigits, final int offset, final String forwardDigit,
        final String rewindDigit, final String pauseDigit) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = {
                            file, escapeDigits, offset, forwardDigit,
                            rewindDigit, pauseDigit
                        };
                    String cmd = buildString(Command.CONTROL_STREAM_FILE,
                            params);

                    return cmd;
                }
            };
    }

    public AgiCommand createWaitForDigit(final int interDigitsTimeout) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { interDigitsTimeout };
                    String cmd = buildString(Command.WAIT_FOR_DIGIT, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSpeechCreate() {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    String cmd = createSpeechCreate("").buildCommand();

                    return cmd;
                }
            };
    }

    public AgiCommand createSpeechCreate(final String engine) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { engine };
                    String cmd = buildString(Command.SPEECH_CREATE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSpeechSet(final String name, final String value) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { name, value };
                    String cmd = buildString(Command.SPEECH_CREATE, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSpeechLoadGrammar(final String label,
        final String path) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { label, path };
                    String cmd = buildString(Command.SPEECH_LOAD_GRAMMAR,
                            params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSpeechActivateGrammar(final String label) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { label };
                    String cmd = buildString(Command.SPEECH_ACTIVATE_GRAMMAR,
                            params);

                    return cmd;
                }
            };
    }

    public AgiCommand createSpeechDeactivateGrammar(final String label) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { label };
                    String cmd = buildString(Command.SPEECH_DEACTIVATE_GRAMMAR,
                            params);

                    return cmd;
                }
            };
    }

    //SpeechRecognitionResult speechRecognize(String prompt, int timeout) throws AgiException;

    //SpeechRecognitionResult speechRecognize(String prompt, int timeout, int offset) throws AgiException, AgiSpeechException;
    public AgiCommand createGoSub(final String context, final String extension,
        final String priority) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { context, extension, priority };
                    String cmd = buildString(Command.GOSUB, params);

                    return cmd;
                }
            };
    }

    public AgiCommand createGoSub(final String context, final String extension,
        final String priority, final String... arguments) {
        return new AgiCommand() {
                @Override
                public String buildCommand() {
                    Object[] params = { context, extension, priority, arguments };
                    String cmd = buildString(Command.GOSUB, params);

                    return cmd;
                }
            };
    }

    private String buildString(Command command, Object[] parameters) {
        String cmd = command.toString().replace('_', ' ');

        if (parameters == null) {
            return cmd;
        }

        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] instanceof String) {
                cmd += (" \"" + ((String) parameters[i]).trim() + "\"");
            } else {
                cmd += (" " + parameters[i]);
            }
        }

        return cmd;
    }
}
