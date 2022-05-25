package com.example.sep3_t2.model;
import java.util.List;

public interface FlightModel {
    Flight createFlight(Flight flight) throws Exception;
    boolean deleteFlight(int id) throws Exception;
    List<Flight> getAllFlights() throws Exception;
}
