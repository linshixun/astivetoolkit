package com.phonytive.astive.ami.action;

public class CreateConfigAction extends ActionMessage {
    private String filename;

    public CreateConfigAction(String filename) {
        super(ActionType.CREATE_CONFIG);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
