package com.phonytive.astive.ami.action;

import com.phonytive.astive.ami.AmiException;
import com.phonytive.astive.ami.Message;

import java.util.ArrayList;


public class ResponseMessage extends Message {
    public ResponseMessage(ArrayList<String> lines) throws AmiException {
        super(lines);
    }
}
