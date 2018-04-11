package com.sandeep.events.service;

import com.sandeep.events.model.Seat;
import com.sandeep.events.model.SeatType;

import java.util.Map;

public interface SeatService {

    int getTotalSeatsCount(String eventId);

    int getSeatsCountByFilter(String eventId, Boolean isAisle, SeatType seatType);

    Map<Long, Seat> getSeats(String eventId);

    Map<Long, Seat> getSeatsByFilter(String eventId, Boolean isAisle, SeatType seatType);

}
