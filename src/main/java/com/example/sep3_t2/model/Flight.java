package com.example.sep3_t2.model;

import java.util.List;

public class Flight {
    private int flightId;
    private int aircraftCode;
    private String airline;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private String duration;
    private String status;
    private List<AdditionalService> additionalServices;
    private List<Seat> seats;

    public Flight(int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, String duration, String status) {
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.status = status;
    }

    public Flight(int flightId, int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, String duration, String status) {
        this.flightId = flightId;
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.status = status;
    }

    public Flight(int flightId, int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, String duration, String status, List<AdditionalService> additionalServices, List<Seat> seats) {
        this.flightId = flightId;
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.status = status;
        this.additionalServices = additionalServices;
        this.seats = seats;
    }

    public int getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(int aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public List<AdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> prices) {
        this.seats = prices;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "aircraftCode=" + aircraftCode +
                ", airline='" + airline + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }
}
