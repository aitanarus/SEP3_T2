package com.example.sep3_t2.controller;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.*;

enum AmadeusConnect {
    INSTANCE;
    private Amadeus amadeus;

    AmadeusConnect() {
        this.amadeus = Amadeus
                .builder("o0cZMfDVaYNZRvxbX7AAvrsM9AtzlEox", "6GG1cGCtY7kthWEf")
                .build();
    }

    public Location[] location(String keyword) throws ResponseException {
        return amadeus.referenceData.locations.get(Params
                .with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
    }

    public FlightOfferSearch[] flights(String origin, String destination, String departDate, String adults, String returnDate) throws ResponseException {
        if(returnDate==null){
            return amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", origin)
                            .and("destinationLocationCode", destination)
                            .and("departureDate", departDate)
                            .and("adults", adults)
                            .and("max", 2));
        }
        else {
            return amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", origin)
                            .and("destinationLocationCode", destination)
                            .and("departureDate", departDate)
                            .and("returnDate", returnDate)
                            .and("adults", adults)
                            .and("max", 25));
        }
    }
}

