package com.phonytive.astive.util;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;


public class ReadUtil {
    ArrayList<String> lines = new ArrayList<String>();

    public ReadUtil(BufferedReader reader) throws IOException {
        String s = null;
        lines.add(reader.readLine());
        while (true) {
            if ((s = reader.readLine()).equals("")) {
                break;
            }
            lines.add(s);
        }
    }

    public ArrayList<String> getLines() {
        return lines;
    }
}
