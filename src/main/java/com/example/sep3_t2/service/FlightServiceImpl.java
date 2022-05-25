package com.example.sep3_t2.service;

import com.example.sep3_t2.exceptions.NotFoundException;
import com.example.sep3_t2.model.Flight;
import com.example.sep3_t2.networking.FlightClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{
    private FlightClient flightClient;

    public FlightServiceImpl() throws IOException{
        flightClient = new FlightClient();
    }

    @Override
    public Flight createFlight(Flight flight) throws Exception {
        Flight result = null;
        result = flightClient.createFlight(flight);
        if(result == null){
            throw new Exception("Flight not created");
        }
        return result;
    }

    @Override
    public boolean deleteFlight(int id) throws Exception {
        boolean result = false;
        result = flightClient.deleteFlight(id);
        if (!result){
            throw new Exception("Flight not deleted from database");
        }
        return result;
    }

    @Override
    public List<Flight> getAllFlights() throws Exception {
        List<Flight> result = null;
        result = flightClient.getAllFlights();
        if(result == null){
            throw new NotFoundException("No flights available");
        }
        return result;
    }
}
