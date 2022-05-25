package com.example.sep3_t2.model;

public class Seat {
    private int seatId;
    private String travelClass;
    private double pricePerSeat;
    private String currency;
    private int numberOfBookableSeats;

    public Seat(int seatId, String travelClass, double pricePerSeat, String currency, int numberOfBookableSeats) {
        this.seatId = seatId;
        this.travelClass = travelClass;
        this.pricePerSeat = pricePerSeat;
        this.currency = currency;
        this.numberOfBookableSeats = numberOfBookableSeats;
    }

    public Seat(String travelClass, double pricePerSeat, String currency, int numberOfBookableSeats) {
        this.travelClass = travelClass;
        this.pricePerSeat = pricePerSeat;
        this.currency = currency;
        this.numberOfBookableSeats = numberOfBookableSeats;
    }

    public int getSeat_id() {
        return seatId;
    }

    public void setSeat_id(int seatId) {
        this.seatId = seatId;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getNumberOfBookableSeats() {
        return numberOfBookableSeats;
    }

    public void setNumberOfBookableSeats(int numberOfBookableSeats) {
        this.numberOfBookableSeats = numberOfBookableSeats;
    }
}
