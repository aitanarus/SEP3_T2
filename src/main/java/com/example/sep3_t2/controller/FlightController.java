package com.example.sep3_t2.controller;

import com.example.sep3_t2.model.Flight;
import com.example.sep3_t2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/flights",method = RequestMethod.POST)
    public ResponseEntity<Object> createFlight(@RequestBody Flight flight)
    {
        try {
            Flight response = flightService.createFlight(flight);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/flights/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteFlight(@PathVariable int id)
    {
        try {
            flightService.deleteFlight(id);
            return new ResponseEntity<>("Flight was removed successfully.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllFlights()
    {
        try {
            List<Flight> response = flightService.getAllFlights();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
