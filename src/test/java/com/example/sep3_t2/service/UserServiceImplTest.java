package com.example.sep3_t2.service;

import com.example.sep3_t2.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class UserServiceImplTest {

    private User user;

    @BeforeEach
    public void setUp() throws IOException {
        user = new User(1, "Aitana", "Rus", "aitana@gmail.com", "Aitanarus123@", "Customer");
    }

    @AfterEach
    public void tearDown() {
        if (user != null) {
            user = null;
        }
    }

    @Test
    public void saveNullUser(){

    }

}