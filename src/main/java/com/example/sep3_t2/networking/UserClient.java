package com.example.sep3_t2.networking;

import com.example.sep3_t2.model.User;
import com.example.sep3_t2.model.UserModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Optional;

public class UserClient implements UserModel {
    private Socket socket;
    private String host = "localhost";
    private int port = 2910;

    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;


    public UserClient() throws IOException{
        socket = new Socket(host, port);
        gson = new Gson();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public boolean saveUser(User user) throws IOException {
        User result = null;
        out.println("save user");
        String request = gson.toJson(user);
        out.println(request);
        String response = in.readLine();
        System.out.println(response);
        System.out.println(gson.fromJson(response, Boolean.class));
        return gson.fromJson(response, Boolean.class);
    }

    @Override
    public Optional<User> getUserById(int id) {
        out.println("get user by id");
        String request = gson.toJson(id);
        out.println(request);
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        out.println("update user");
        String request = gson.toJson(user);
        out.println(request);
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        out.println("delete user");
        String request = gson.toJson(id);
        out.println(request);
        return false;
    }

    @Override
    public Optional<Collection<User>> getAllUsers() {
        out.println("get all users");
        return null;
    }

    @Override
    public boolean findEmail(String email) {
        String request = gson.toJson(email);
        out.println(request);
        return true;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        out.println("get user by email");
        String request = gson.toJson(email);
        out.println(request);
        return Optional.empty();
    }
}
