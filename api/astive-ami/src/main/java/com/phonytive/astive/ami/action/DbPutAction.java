package com.phonytive.astive.ami.action;

public class DbPutAction extends ActionMessage {
    private String family;
    private String key;
    private String val;

    public DbPutAction(String family, String key) {
        super(ActionType.DB_PUT);
        this.family = family;
        this.key = key;
    }

    public DbPutAction(String family, String key, String val) {
        super(ActionType.DB_DEL);
        this.family = family;
        this.key = key;
        this.val = val;
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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
