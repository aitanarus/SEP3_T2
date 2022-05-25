package com.example.sep3_t2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class Sep3T2Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Sep3T2Application.class, args);
        Client client = new Client();
        client.run();
    }
}
