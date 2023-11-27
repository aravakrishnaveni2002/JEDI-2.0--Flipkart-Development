package com.flipkart.exception;

public class DataEntryException extends Exception
{
    public String getMessage(){
        return "Oops!! There was an error while entry your data";
    }
}

