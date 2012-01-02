package com.phonytive.astive.ami.action;

public class ExtensionStateAction extends ActionMessage {
    private String exten;
    private String context;

    public ExtensionStateAction(String exten, String context) {
        super(ActionType.EXTENSION_STATE);
        this.exten = exten;
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getExten() {
        return exten;
    }

    public void setExten(String exten) {
        this.exten = exten;
    }
}
