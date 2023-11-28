package com.flipkart.exception;

public class GymDetailsNotFoundException extends Exception {

    public String getMessage() {
        return "Oops! GymDetails not found";
    }
}
