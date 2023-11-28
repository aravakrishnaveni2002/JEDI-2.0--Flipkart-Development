package com.flipkart.exception;

public class NoDataFoundException extends Exception {
    public String getMessage(){
        return "No data was found";
    }

}