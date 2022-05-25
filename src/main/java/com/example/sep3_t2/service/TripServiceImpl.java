package com.example.sep3_t2.service;

import com.example.sep3_t2.exceptions.NotFoundException;
import com.example.sep3_t2.model.Trip;
import com.example.sep3_t2.networking.TripClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class TripServiceImpl implements TripService {

    private TripClient tripClient;

    public TripServiceImpl() throws IOException {
        tripClient = new TripClient();
    }

    @Override
    public List<Trip> getTripsByParam(Trip trip) throws Exception {
        List<Trip> result = null;
        try{
            dateComparator(getDateFromString(trip.getDepartureDate()), getDateFromString(trip.getReturnDate()));
            result = tripClient.getTripsByParam(trip);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (result.isEmpty() || result == null){
            new NotFoundException( "No flights found.");
        }

        //double price = result.get(0).getFlights().get(0).getSeats().get(0).getPricePerSeat();
        //result.get(0).setGrandTotal(price);
        //System.out.println(result.get(0).getGrandTotal());
        System.out.println(result.get(0).getFlights().get(0).getSeats().get(0).getPricePerSeat());

        return result;
    }

    public static Date getDateFromString(String string) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date = dateFormat.parse(string);
        return date;
    }

    public static void dateComparator(Date departureDate, Date returnDate) throws Exception {
        if(departureDate.compareTo(returnDate) > 0) {
            throw new Exception("Departure date must be after the return date");
        } else if(departureDate.compareTo(returnDate) == 0) {
            throw new Exception("Departure date cannot equal the return date");
        }
    }

    public static void calculateGrandTotal(Trip trip){
        double price = 0;
        for (int i = 0; i < trip.getFlights().size(); i++) {
            for (int j = 0; j < trip.getFlights().get(i).getSeats().size(); j++){
                price += trip.getFlights().get(i).getSeats().get(j).getPricePerSeat();
            }
        }
        trip.setGrandTotal(price);
        System.out.println(trip.getGrandTotal());
    }

}
