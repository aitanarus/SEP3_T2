package com.example.sep3_t2.networking;

import com.example.sep3_t2.model.Flight;
import com.example.sep3_t2.model.FlightModel;
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

public class FlightClient implements FlightModel {
    private Socket socket;
    private String host = "localhost";
    private int port = 2911;

    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;

    public FlightClient() throws IOException {
        socket = new Socket(host, port);
        gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public Flight createFlight(Flight flight) throws Exception {
        Flight result = null;
        out.println("create flight");
        String request = gson.toJson(flight);
        out.println(request);
        try {
            String response = in.readLine();
            result = gson.fromJson(response, Flight.class);
        } catch (SocketException e) {
            throw new Exception("Cannot connect to database");
        }
        return result;
    }

    @Override
    public boolean deleteFlight(int id) throws Exception {
        boolean result = false;
        out.println("delete flight");
        String request = gson.toJson(id);
        out.println(request);
        try {
            String response = in.readLine();
            result = gson.fromJson(response, boolean.class);
        } catch (SocketException e) {
            throw new Exception("Cannot connect to database");
        }
        return result;
    }

    @Override
    public List<Flight> getAllFlights() throws Exception {
        List<Flight> result = null;
        out.println("get all flights");
        try {
            String response = in.readLine();
            result = gson.fromJson(response, List.class);
        } catch (SocketException e){
            throw new Exception("Cannot connect to database");
        }
        return result;
    }
}
