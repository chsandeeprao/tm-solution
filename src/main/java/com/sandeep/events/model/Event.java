package com.sandeep.events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public class Event {
    private String eventId;
    private int totalAvailableSeatCount;
    private int filteredAvailableSeatCount;
    @JsonIgnore
    private Map<Long, Seat> seats;

    public int getTotalAvailableSeatCount() {
        return totalAvailableSeatCount;
    }

    public void setTotalAvailableSeatCount(int totalAvailableSeatCount) {
        this.totalAvailableSeatCount = totalAvailableSeatCount;
    }

    public int getFilteredAvailableSeatCount() {
        return filteredAvailableSeatCount;
    }

    public void setFilteredAvailableSeatCount(int filteredAvailableSeatCount) {
        this.filteredAvailableSeatCount = filteredAvailableSeatCount;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Map<Long, Seat> getSeats() {
        return seats;
    }

    public void setSeats(Map<Long, Seat> seats) {
        this.seats = seats;
    }
}
