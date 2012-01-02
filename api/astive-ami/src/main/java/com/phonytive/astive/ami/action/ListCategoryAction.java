package com.phonytive.astive.ami.action;

public class ListCategoryAction extends ActionMessage {
    private String filename;

    public ListCategoryAction(String filename) {
        super(ActionType.LIST_CATEGORIES);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
