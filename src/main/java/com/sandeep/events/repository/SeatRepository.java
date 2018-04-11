package com.sandeep.events.repository;


import com.sandeep.events.model.Seat;

import java.util.Map;

public interface SeatRepository {
    Map<Long, Seat> getSeats();
}
