package com.example.sep3_t2.service;

import com.example.sep3_t2.model.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getTripsByParam(Trip trip) throws Exception;
}