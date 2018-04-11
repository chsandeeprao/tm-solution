package com.sandeep.events.repository;

import com.sandeep.events.model.Seat;
import com.sandeep.events.model.SeatType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SeatRepositoryImpl implements SeatRepository {

    private static final Logger LOG = LoggerFactory.getLogger(SeatRepositoryImpl.class);

    private static Map<Long, Seat> seats = new HashMap<>();

    public SeatRepositoryImpl() {
        seats.put(1L, new Seat("1234", Boolean.FALSE, Boolean.TRUE, SeatType.ADULT));
        seats.put(2L, new Seat("1234", Boolean.TRUE, Boolean.FALSE, SeatType.ADULT));
        seats.put(3L, new Seat("1234", Boolean.TRUE, Boolean.FALSE, SeatType.CHILD));
        seats.put(4L, new Seat("1234", Boolean.TRUE, Boolean.FALSE, SeatType.ADULT));
        seats.put(5L, new Seat("1234", Boolean.TRUE, Boolean.FALSE, SeatType.ADULT));
        seats.put(6L, new Seat("1234", Boolean.TRUE, Boolean.FALSE, SeatType.CHILD));
        seats.put(7L, new Seat("1234", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(8L, new Seat("1234", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(9L, new Seat("1234", Boolean.TRUE, Boolean.TRUE, SeatType.CHILD));
        seats.put(10L, new Seat("1234", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(11L, new Seat("1234", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));

        seats.put(12L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(13L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(14L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(15L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(16L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(17L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(18L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(19L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(20L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
        seats.put(21L, new Seat("111", Boolean.TRUE, Boolean.TRUE, SeatType.ADULT));
    }

    @Override
    public Map<Long, Seat> getSeats() {
        LOG.info("Inside getSeats method");
        return seats;
    }
}
