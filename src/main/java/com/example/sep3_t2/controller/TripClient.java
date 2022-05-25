package com.example.sep3_t2.controller;

import com.example.sep3_t2.model.Trip;
import com.example.sep3_t2.model.TripModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class TripClient implements TripModel {
    private Socket socket;
    private String host = "localhost";
    private int port = 2912;

    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;


    public TripClient() throws IOException {
        socket = new Socket(host, port);
        gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public List<Trip> getTripsByParam(Trip trip) throws Exception {
        List<Trip> result = null;
        out.println("get trips by param");
        String request = gson.toJson(trip);
        out.println(request);
        try {
            String response = in.readLine();
            //Type founderListType = new TypeToken<ArrayList<Flight>>(){}.getType();
            result = gson.fromJson(response, List.class);
            System.out.println(result);
        } catch (SocketException e){
            throw new Exception("Cannot connect to database");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
