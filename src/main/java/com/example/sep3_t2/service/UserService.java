package com.example.sep3_t2.service;

import com.example.sep3_t2.model.User;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface UserService {
    boolean saveUser(User user) throws IOException;
    boolean updateUser(User user);
    boolean deleteUser(int id);
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
    Optional<Collection<User>> getAllUsers();
}
