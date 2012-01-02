package com.phonytive.astive.ami.action;

public class GetConfigJSONAction extends ActionMessage {
    private String filename;

    public GetConfigJSONAction(String filename) {
        super(ActionType.GET_CONFIG_JSON);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
