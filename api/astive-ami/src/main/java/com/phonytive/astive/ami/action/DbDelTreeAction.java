package com.phonytive.astive.ami.action;

public class DbDelTreeAction extends ActionMessage {
    private String family;
    private String key;

    public DbDelTreeAction(String family) {
        super(ActionType.DB_DEL_TREE);
        this.family = family;
    }

    public DbDelTreeAction(String family, String key) {
        super(ActionType.DB_DEL_TREE);
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
