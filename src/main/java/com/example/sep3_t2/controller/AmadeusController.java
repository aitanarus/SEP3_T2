package com.example.sep3_t2.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class AmadeusController {
    @GetMapping("/locations")
    public Location[] locations(@RequestParam(required=true) String keyword) throws ResponseException {
        return AmadeusConnect.INSTANCE.location(keyword);
    }

    @GetMapping("/flights")
    public FlightOfferSearch[] flights(@RequestParam(required=true) String origin,
                                       @RequestParam(required=true) String destination,
                                       @RequestParam(required=true) String departDate,
                                       @RequestParam(required=true) String adults,
                                       @RequestParam(required = false) String returnDate)
            throws ResponseException {
        return AmadeusConnect.INSTANCE.flights(origin, destination, departDate, adults, returnDate);
    }
}