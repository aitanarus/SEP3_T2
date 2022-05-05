package com.example.sep3_t2.model;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Optional;


public interface UserModel {
    boolean saveUser(User user) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException;
    Optional<User> getUserById(int id);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    Optional<Collection<User>> getAllUsers();
    boolean findEmail(String email);

    Optional<User> getUserByEmail(String email);
}
