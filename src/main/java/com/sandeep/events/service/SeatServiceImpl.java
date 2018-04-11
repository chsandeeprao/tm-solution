package com.sandeep.events.service;

import com.sandeep.events.model.Seat;
import com.sandeep.events.model.SeatType;
import com.sandeep.events.repository.SeatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class SeatServiceImpl implements SeatService{

    private static final Logger LOG = LoggerFactory.getLogger(SeatServiceImpl.class);

    @Autowired
    SeatRepository seatRepository;

    /**
     * Returns the number of total available seats.
     *
     * @param eventId the ID associated with the event
     * @return number of total available seats
     */
    @Override
    public int getTotalSeatsCount(String eventId) {
        LOG.info("Inside getTotalSeatsCount method");
        long result = this.seatRepository.getSeats().entrySet()
                .stream()
                .filter(map -> map.getValue().getEventId().equals(eventId))
                .filter(map -> map.getValue().getIsAvailable())
                .count();
        return (int) result;
    }

    /**
     * Returns the number of available seats based on filters.
     *
     * @param eventId the ID associated with the event
     * @param isAisle filter to find the the given seat is of type Aisle
     * @param seatType filter to find the the given seat is of type Adult/Child
     * @return number of available seats based on filters
     *
     * @see SeatType
     */
    @Override
    public int getSeatsCountByFilter(String eventId, Boolean isAisle, SeatType seatType) {
        LOG.info("Inside getSeatsCountByFilter method");
        if(null != isAisle && null != seatType){
            return (int) this.seatRepository.getSeats().entrySet()
                    .stream()
                    .filter(map -> map.getValue().getEventId().equals(eventId))
                    .filter(map -> map.getValue().getIsAvailable())
                    .filter(map -> map.getValue().getIsAisle().equals(isAisle))
                    .filter(map -> map.getValue().getType().equals(seatType))
                    .count();
        } else if(null != isAisle) {
            return (int) this.seatRepository.getSeats().entrySet()
                    .stream()
                    .filter(map -> map.getValue().getEventId().equals(eventId))
                    .filter(map -> map.getValue().getIsAvailable())
                    .filter(map -> map.getValue().getIsAisle().equals(isAisle))
                    .count();
        } else if(null != seatType) {
            return (int) this.seatRepository.getSeats().entrySet()
                    .stream()
                    .filter(map -> map.getValue().getEventId().equals(eventId))
                    .filter(map -> map.getValue().getIsAvailable())
                    .filter(map -> map.getValue().getType().equals(seatType))
                    .count();
        }
        return 0;
    }

    /**
     * Returns the total available seats.
     *
     * @param eventId the ID associated with the event
     * @return map of total available seats
     */
    @Override
    public Map<Long, Seat> getSeats(String eventId) {
        LOG.info("Inside getSeats method");
        return this.seatRepository.getSeats().entrySet()
                .stream()
                .filter(map -> map.getValue().getEventId().equals(eventId))
                .filter(map -> map.getValue().getIsAvailable())
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }

    /**
     * Returns the available seats based on filters.
     *
     * @param eventId the ID associated with the event
     * @param isAisle filter to find the the given seat is of type Aisle
     * @param seatType filter to find the the given seat is of type Adult/Child
     * @return map of available seats based on filters
     *
     * @see SeatType
     */
    @Override
    public Map<Long, Seat> getSeatsByFilter(String eventId, Boolean isAisle, SeatType seatType) {
        LOG.info("Inside getSeatsCountByFilter method");
        if(null != isAisle && null != seatType){
            return this.seatRepository.getSeats().entrySet()
                    .stream()
                    .filter(map -> map.getValue().getEventId().equals(eventId))
                    .filter(map -> map.getValue().getIsAisle().equals(isAisle))
                    .filter(map -> map.getValue().getType().equals(seatType))
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        } else if(null != isAisle) {
            return this.seatRepository.getSeats().entrySet()
                    .stream()
                    .filter(map -> map.getValue().getEventId().equals(eventId))
                    .filter(map -> map.getValue().getIsAisle().equals(isAisle))
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        } else if(null != seatType) {
            return this.seatRepository.getSeats().entrySet()
                    .stream()
                    .filter(map -> map.getValue().getEventId().equals(eventId))
                    .filter(map -> map.getValue().getType().equals(seatType))
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        }
        return null;
    }
}
