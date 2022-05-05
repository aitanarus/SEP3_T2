package com.example.sep3_t2.service;

import com.example.sep3_t2.exceptions.InvalidPasswordException;
import com.example.sep3_t2.exceptions.NotFoundException;
import com.example.sep3_t2.model.User;
import com.example.sep3_t2.networking.UserClient;
import com.example.sep3_t2.security.PasswordEncryptor;
import com.sun.jdi.InternalException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private UserClient userClient;

    private PasswordEncryptor pwdEncryptor;
    private SecretKey key;
    private IvParameterSpec ivParameterSpec;
    private String algorithm;

    public UserServiceImpl() throws IOException, NoSuchAlgorithmException {
        userClient = new UserClient();  //Change this
        pwdEncryptor = new PasswordEncryptor();
        key = PasswordEncryptor.generateKey(128);
        ivParameterSpec = PasswordEncryptor.generateIv();
        algorithm = "AES/CBC/PKCS5Padding";
    }

    @Override
    public boolean saveUser(User user) throws IOException {
       boolean result = false;

        try {
            if (isValidEmail(user.getEmail())  && isValidPassword(user.getPassword()) && isEmailUnique(user.getEmail())) {
                user.setPassword(pwdEncryptor.encrypt(algorithm, user.getPassword(), key, ivParameterSpec));
                result = userClient.saveUser(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!result) {
            throw  new InternalException("User could not be saved .");
        }
        return result;
    }

    @Override
    public boolean updateUser( User user) {
        boolean result = false;

        try {
            if(isEmailUnique(user.getEmail()))
            {
                user.setPassword(pwdEncryptor.encrypt(algorithm, user.getPassword(), key, ivParameterSpec));
                result = userClient.updateUser(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(!result)
        {
            throw  new InternalException("User could not be updated.");
        }

        return result ;
    }

    @Override
    public boolean deleteUser(int id) {
        return userClient.deleteUser(id);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userClient.getUserById(id)
                .orElseThrow(() -> new NotFoundException("User " + id + " not available")));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userClient.getUserByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email " + email + " is not available")));
    }

    @Override
    public Optional<Collection<User>> getAllUsers() {
        return Optional.ofNullable(userClient.getAllUsers()
                .orElseThrow(() -> new NotFoundException("Users list not available")));
    }

    public boolean isEmailUnique(String email) throws Exception {
        boolean isUnique = true;
        if(userClient.findEmail(email)){
            isUnique = false;
            throw new Exception(email + " already exists.");
        }
        return isUnique;
    }

    public boolean isValidEmail (String email){
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    public boolean isValidPassword(String password) throws InvalidPasswordException {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8)
        {
            isValid = false;
            throw new InvalidPasswordException("Password must be less than 20 and more than 8 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            isValid = false;
            throw new InvalidPasswordException("Password must have at least one uppercase character");
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
            isValid = false;
            throw new InvalidPasswordException("Password must have at least one lowercase character");
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
            isValid = false;
            throw new InvalidPasswordException("Password must have at least one number");
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars ))
        {
            isValid = false;
            throw new InvalidPasswordException("Password must have at least one special character among @#$%");
        }
        return isValid;

    }
}

