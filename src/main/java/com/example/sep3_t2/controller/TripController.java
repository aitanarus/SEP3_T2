package com.example.sep3_t2.controller;

import com.example.sep3_t2.exceptions.NotFoundException;
import com.example.sep3_t2.model.Trip;
import com.example.sep3_t2.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public ResponseEntity<Object> getTripsByParam(@RequestParam(required=true) String origin,
                                                    @RequestParam(required=true) String destination,
                                                    @RequestParam(required=true) String departDate,
                                                    @RequestParam(required=true) String oneWay,
                                                    @RequestParam(required=true) String travelClass,
                                                    @RequestParam(required=true) String adults,
                                                    @RequestParam(required = false) String returnDate) {
        try {
            List<Trip> response = tripService.getTripsByParam(new Trip(Boolean.valueOf(oneWay), origin, destination, departDate, returnDate, Integer.parseInt(adults), travelClass));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
