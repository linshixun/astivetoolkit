package com.phonytive.astive.ami.action;

public class GetVarAction extends ActionMessage {
    private String channel;
    private String variable;

    public GetVarAction(String variable) {
        super(ActionType.GETVAR);
        this.variable = variable;
    }

    public GetVarAction(String channel, String variable) {
        super(ActionType.GETVAR);
        this.channel = channel;
        this.variable = variable;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
