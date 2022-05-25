package com.example.sep3_t2.model;

import java.util.List;

public interface TripModel {
    List<Trip> getTripsByParam(Trip trip) throws Exception;
}
