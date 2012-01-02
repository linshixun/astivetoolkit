package com.phonytive.astive.ami.action;

public class ChallengeAction extends ActionMessage {
    private AuthType authType;

    public ChallengeAction(AuthType authType) {
        super(ActionType.CHALLENGE);
        this.authType = authType;
    }

    public AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }
}
