package com.phonytive.astive.ami.action;

public class JabberSendAction extends ActionMessage {
    private String jabber;
    private String jId;
    private String message;

    public JabberSendAction(String jabber, String jId, String message) {
        super(ActionType.JABBER_SEND);
        this.jabber = jabber;
        this.jId = jId;
        this.message = message;
    }

    public String getjId() {
        return jId;
    }

    public void setjId(String jId) {
        this.jId = jId;
    }

    public String getJabber() {
        return jabber;
    }

    public void setJabber(String jabber) {
        this.jabber = jabber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
