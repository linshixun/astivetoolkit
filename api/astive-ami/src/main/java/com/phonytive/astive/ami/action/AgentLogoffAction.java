package com.phonytive.astive.ami.action;

public class AgentLogoffAction extends ActionMessage {
    private String agent;
    private boolean soft = true;

    public AgentLogoffAction(String agent) {
        super(ActionType.AGENT_LOGOFF);
        this.agent = agent;
    }

    public AgentLogoffAction(String agent, boolean soft) {
        super(ActionType.AGENT_LOGOFF);
        this.agent = agent;
        this.soft = soft;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public boolean isSoft() {
        return soft;
    }

    public void setSoft(boolean soft) {
        this.soft = soft;
    }
}
