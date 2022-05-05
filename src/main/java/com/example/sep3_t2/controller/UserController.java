package com.example.sep3_t2.controller;

import com.example.sep3_t2.exceptions.InvalidPasswordException;
import com.example.sep3_t2.model.User;
import com.example.sep3_t2.service.UserService;
import com.sun.jdi.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) throws IOException {
        boolean response = userService.saveUser(user);
        try {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id)
   {
       boolean response = userService.updateUser(user);
       try {
           return new ResponseEntity<>(response,HttpStatus.OK);
       }
       catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

   @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable int id)
   {
       userService.deleteUser(id);
       return new ResponseEntity<>("User was removed successfully.", HttpStatus.OK);
   }

    public ResponseEntity<Object> getUserById(){
        return null;
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getAllUsers()
    {
        Optional<Collection<User>> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email)
    {
        Optional<User> user = userService.getUserByEmail(email);
        System.out.println(email);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
