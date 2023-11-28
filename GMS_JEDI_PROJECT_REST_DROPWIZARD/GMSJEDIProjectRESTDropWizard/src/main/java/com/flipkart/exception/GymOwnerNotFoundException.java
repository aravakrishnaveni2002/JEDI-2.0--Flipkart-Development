package com.flipkart.exception;

public class GymOwnerNotFoundException extends Exception{

    public String getMessage(){
        return "Oops! GymOwner Details not Found";
    }
}
