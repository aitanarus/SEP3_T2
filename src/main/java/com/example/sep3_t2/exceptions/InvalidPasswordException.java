package com.example.sep3_t2.exceptions;

public class InvalidPasswordException extends RuntimeException {

    InvalidPasswordException() {
    }

    public InvalidPasswordException(String message) {
        super(message);
    }

    InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}