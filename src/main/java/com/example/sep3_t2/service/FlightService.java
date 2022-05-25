package com.example.sep3_t2.service;

import com.example.sep3_t2.model.Flight;

import java.util.List;

public interface FlightService {
    Flight createFlight(Flight flight) throws Exception;
    boolean deleteFlight(int id) throws Exception;
    List<Flight> getAllFlights() throws Exception;
}
