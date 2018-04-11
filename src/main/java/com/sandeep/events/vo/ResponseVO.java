package com.sandeep.events.vo;

import com.sandeep.events.model.Event;

public class ResponseVO {

    private int status;
    private Event event;
    private ServiceErrorVO errorVO;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ServiceErrorVO getErrorVO() {
        return errorVO;
    }

    public void setErrorVO(ServiceErrorVO errorVO) {
        this.errorVO = errorVO;
    }
}
