package com.example.sep3_t2.model;

public class AdditionalService {
    private int additionalServiceId;
    private String type;
    private boolean available;
    private double price;

    public AdditionalService(String type, boolean available, double price) {
        this.type = type;
        this.available = available;
        this.price = price;
    }
}
