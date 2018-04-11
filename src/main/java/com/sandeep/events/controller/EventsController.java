package com.sandeep.events.controller;

import com.sandeep.events.model.Event;
import com.sandeep.events.service.SeatService;
import com.sandeep.events.vo.RequestVO;
import com.sandeep.events.vo.ResponseVO;
import com.sandeep.events.vo.ServiceErrorVO;
import com.sandeep.events.vo.ServiceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/events")
public class EventsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsController.class);

    @Autowired
    private SeatService seatService;

    /**
     * This controller is to find the total available seat count or/and seat count
     * based on the filter(s). It could be easily modified to fetch the available
     * seats collection. Or add extra filters like non-available seats, only counts,
     * only seats.
     *
     * @param requestVO object contains the eventId and filters to get the available seat count
     * @return {@param responseVO} of available seats based on filters
     *
     * @see RequestVO
     * @see ResponseVO
     */

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO getSeats(@Valid @ModelAttribute RequestVO requestVO,
                               BindingResult bindingResult) throws Exception {
        LOGGER.info("******************* events Controller called *******************");
        LOGGER.debug("the event ID value is " + requestVO.getEventId());

        ResponseVO responseVO = new ResponseVO();
        Event event = new Event();
        responseVO.setEvent(event);
        responseVO.getEvent().setEventId(requestVO.getEventId());

        if (null != bindingResult && bindingResult.hasErrors()) {
            responseVO.setStatus(ServiceStatus.BAD_REQUEST.getCode());
            ServiceErrorVO errorVO = new ServiceErrorVO(bindingResult.getFieldError().getCodes()[0]);
            responseVO.setErrorVO(errorVO);
        } else {
            //responseVO.getEvent().setSeats(this.seatService.getSeats(requestVO.getEventId()));
            responseVO.getEvent().setTotalAvailableSeatCount(this.seatService.getTotalSeatsCount(requestVO.getEventId()));

            LOGGER.info("Call getSeatsCountByFilter for aisle value = {} type = {}", requestVO.getIsAisle(), requestVO.getType());

            //responseVO.getEvent().setSeats(this.seatService.getSeatsByFilter(requestVO.getEventId(), requestVO.getIsAisle(), requestVO.getType()));

            responseVO.getEvent().setFilteredAvailableSeatCount(this.seatService.getSeatsCountByFilter(requestVO.getEventId(), requestVO.getIsAisle(), requestVO.getType()));
            LOGGER.debug("Seat count by filter is " + responseVO.getEvent().getFilteredAvailableSeatCount());
            responseVO.setStatus(ServiceStatus.SUCCESS.getCode());
        }
        return responseVO;
    }
}