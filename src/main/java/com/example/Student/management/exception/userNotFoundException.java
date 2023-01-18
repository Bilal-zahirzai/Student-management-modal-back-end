package com.example.Student.management.exception;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException(String message) {
        super((message));
    }
}
