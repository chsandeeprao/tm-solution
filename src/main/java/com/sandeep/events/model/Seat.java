package com.sandeep.events.model;

public class Seat {
    private String eventId;
    private Boolean isAvailable;
    private Boolean isAisle;
    private SeatType type;

    public Seat() {

    }

    public Seat(String eventId, Boolean isAvailable, Boolean isAisle, SeatType type) {
        this.eventId = eventId;
        this.isAvailable = isAvailable;
        this.isAisle = isAisle;
        this.type = type;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Boolean getIsAisle() {
        return isAisle;
    }

    public void setAisle(Boolean isAisle) {
        this.isAisle = isAisle;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
