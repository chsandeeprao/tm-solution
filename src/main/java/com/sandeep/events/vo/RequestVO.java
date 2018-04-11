package com.sandeep.events.vo;

import com.sandeep.events.model.SeatType;

import javax.validation.constraints.NotNull;

public class RequestVO {

    @NotNull
    private String eventId;
    private Boolean isAisle;
    private SeatType type;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Boolean getIsAisle() {
        return isAisle;
    }

    public void setIsAisle(Boolean aisle) {
        this.isAisle = aisle;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
