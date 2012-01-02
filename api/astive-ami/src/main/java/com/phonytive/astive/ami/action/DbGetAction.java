package com.phonytive.astive.ami.action;

public class DbGetAction extends ActionMessage {
    private String family;
    private String key;

    public DbGetAction(String family, String key) {
        super(ActionType.DB_GET);
        this.family = family;
        this.key = key;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
