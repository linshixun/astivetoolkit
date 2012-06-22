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
package com.phonytive.astive.agi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @since 1.0.0
 */
public class AgiCommandReply {
    public static int SC_TRYING = 100;
    public static int SC_SUCCESS = 200;
    public static int SC_INVALID_OR_UNKNOWN_COMMAND = 510;
    public static int SC_DEAD_CHANNEL = 511;
    public static int SC_INVALID_COMMAND_SYNTAX = 520;
    private static final Pattern STATUS_PATTERN = Pattern.compile(
            "^(\\d{3})[ -]");
    private static final Pattern RESULT_PATTERN = Pattern.compile(
            "^200 result=(\\S+)");
    private static final Pattern PARENTHESIS_PATTERN = Pattern.compile(
            "^200 result=\\S* +\\((.*)\\)");
    private static final Pattern ADDITIONAL_ATTRIBUTES_PATTERN = Pattern.compile(
            "^200 result=\\S* +(\\(.*\\) )?(.+)$");
    private static final Pattern SYNOPSIS_PATTERN = Pattern.compile(
            "^\\s*Usage:\\s*(.*)\\s*$");
    private static final String END_OF_PROPER_USAGE = "520 End of proper usage.";

    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 6279692160047296949L;

    /**
     * The status code.
     */
    private Integer status;
    private List<String> lines;

    /**
     * Additional attributes contained in this reply, for example endpos.
     */
    private Map<String, String> attributes;

    /**
     * The contents of the parenthesis.
     */
    private String extra;
    private String firstLine;

    /**
     * The result, that is the part directly following the "result=" string.
     */
    private String result;

    /**
     * In case of status == 520 (invalid command syntax) this attribute contains
     * the synopsis of the command.
     */
    private String synopsis;

    /**
     * In case of status == 520 (invalid command syntax) this attribute contains
     * the usage of the command.
     */
    private String usage;
    private boolean extraCreated;

    /**
     * Creates a new AgiCommandReply object.
     */
    public AgiCommandReply() {
        super();
        this.status = null;
    }

    /**
     * Creates a new AgiCommandReply object.
     *
     * @param lines DOCUMENT ME!
     */
    public AgiCommandReply(List<String> lines) {
        this();

        if (lines != null) {
            this.lines = new ArrayList<String>(lines);

            if (!lines.isEmpty()) {
                firstLine = lines.get(0);
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param name DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getAttribute(String name) {
        if (getStatus() != SC_SUCCESS) {
            return null;
        }

        if ("result".equalsIgnoreCase(name)) {
            return getResult();
        }

        return getAttributes().get(name.toLowerCase(Locale.ENGLISH));
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    protected Map<String, String> getAttributes() {
        if (attributes != null) {
            return attributes;
        }

        attributes = new HashMap<String, String>();

        final Matcher matcher = ADDITIONAL_ATTRIBUTES_PATTERN.matcher(firstLine);

        if (matcher.find()) {
            attributes.putAll(parseAttributes(matcher.group(2)));
        }

        return attributes;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getExtra() {
        if (getStatus() != SC_SUCCESS) {
            return null;
        }

        if (extraCreated) {
            return extra;
        }

        final Matcher matcher = PARENTHESIS_PATTERN.matcher(firstLine);

        if (matcher.find()) {
            extra = matcher.group(1);
        }

        extraCreated = true;

        return extra;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getFirstLine() {
        return firstLine;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getResult() {
        if (result != null) {
            return result;
        }

        final Matcher matcher = RESULT_PATTERN.matcher(firstLine);

        if (matcher.find()) {
            result = matcher.group(1);
        } else {
            result = "";
        }

        return result;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getResultCode() {
        String r;

        r = getResult();

        if (result == null) {
            return -1;
        }

        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public char getResultCodeAsChar() {
        int resultCode;

        resultCode = getResultCode();

        if (resultCode < 0) {
            return 0x0;
        }

        return (char) resultCode;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getStatus() {
        if (status != null) {
            return status;
        }

        final Matcher matcher = STATUS_PATTERN.matcher(firstLine);

        if (matcher.find()) {
            status = Integer.parseInt(matcher.group(1));

            return status;
        }

        return -1;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getSynopsis() {
        if (getStatus() != SC_INVALID_COMMAND_SYNTAX) {
            return null;
        }

        if ((synopsis == null) && (lines.size() > 1)) {
            final String secondLine;
            final Matcher synopsisMatcher;

            secondLine = lines.get(1);
            synopsisMatcher = SYNOPSIS_PATTERN.matcher(secondLine);

            if (synopsisMatcher.find()) {
                synopsis = synopsisMatcher.group(1);
            }
        }

        return synopsis;
    }

    /**
     * Returns the usage of the command sent if Asterisk expected a different
     * syntax (getStatus() == SC_INVALID_COMMAND_SYNTAX).
     *
     * @return the usage of the command sent, <code>null</code> if there were
     *         no syntax errors.
     */
    public String getUsage() {
        if (usage == null) {
            StringBuilder usageSB;

            usageSB = new StringBuilder();

            for (int i = 2; i < lines.size(); i++) {
                String line;

                line = lines.get(i);

                if (END_OF_PROPER_USAGE.equals(line)) {
                    break;
                }

                usageSB.append(line.trim());
                usageSB.append(" ");
            }

            usage = usageSB.toString().trim();
        }

        return usage;
    }

    /**
     * DOCUMENT ME!
     *
     * @param s DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    Map<String, String> parseAttributes(String s) {
        StringBuilder keyBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();

        boolean inKey = true;
        boolean inQuotes = false;
        char previousChar = 0x0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c == '=') && inKey) {
                inKey = false;
                inQuotes = false;
            } else if (((c == ' ') && !inKey && !inQuotes)) {
                map.put(keyBuilder.toString().toLowerCase(Locale.ENGLISH),
                    valueBuilder.toString());
                keyBuilder.delete(0, keyBuilder.length());
                valueBuilder.delete(0, valueBuilder.length());
                inKey = true;
            } else if ((c == '"') && !inKey) {
                if (previousChar == '\\') {
                    valueBuilder.deleteCharAt(valueBuilder.length() - 1);
                    valueBuilder.append(c);
                } else {
                    inQuotes = !inQuotes;
                }
            } else {
                if (inKey) {
                    keyBuilder.append(c);
                } else {
                    valueBuilder.append(c);
                }
            }

            previousChar = c;
        }

        if (keyBuilder.length() > 0) {
            map.put(keyBuilder.toString().toLowerCase(Locale.ENGLISH),
                valueBuilder.toString());
        }

        return map;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String toString() {
        StringBuilder sb;

        sb = new StringBuilder("AgiReply[");
        sb.append("status=").append(getStatus()).append(",");

        if (status == SC_SUCCESS) {
            sb.append("result='").append(getResult()).append("',");
            sb.append("extra='").append(getExtra()).append("',");
            sb.append("attributes=").append(getAttributes()).append(",");
        }

        if (status == SC_INVALID_COMMAND_SYNTAX) {
            sb.append("synopsis='").append(getSynopsis()).append("',");
        }

        sb.append("systemHashcode=").append(System.identityHashCode(this));
        sb.append("]");

        return sb.toString();
    }
}
