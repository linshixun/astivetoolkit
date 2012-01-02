package com.phonytive.astive.ami.action;

public class GetConfigAction extends ActionMessage {
    private String filename;
    private String category;

    public GetConfigAction(String filename) {
        super(ActionType.GET_CONFIG);
        this.filename = filename;
    }

    public GetConfigAction(String filename, String category) {
        super(ActionType.GET_CONFIG);
        this.filename = filename;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
