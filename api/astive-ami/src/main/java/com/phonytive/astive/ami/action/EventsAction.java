package com.phonytive.astive.ami.action;

public class EventsAction extends ActionMessage {
    private String eventMask;

    public EventsAction(String eventMask) {
        super(ActionType.EVENTS);
        this.eventMask = eventMask;
    }

    public String getEventMask() {
        return eventMask;
    }

    public void setEventMask(String eventMask) {
        this.eventMask = eventMask;
    }
}
