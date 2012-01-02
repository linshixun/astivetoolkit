package com.phonytive.astive.ami.action;

public class DahdiDialOffHookAction extends ActionMessage {
    private String dahdiChannel;
    private String number;

    public DahdiDialOffHookAction(String dahdiChannel, String number) {
        super(ActionType.DAHDI_DIAL_OFF_HOOK);
        this.dahdiChannel = dahdiChannel;
        this.number = number;
    }

    public String getDahdiChannel() {
        return dahdiChannel;
    }

    public void setDahdiChannel(String dahdiChannel) {
        this.dahdiChannel = dahdiChannel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
