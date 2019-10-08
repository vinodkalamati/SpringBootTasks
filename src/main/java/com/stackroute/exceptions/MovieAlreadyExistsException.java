package com.stackroute.exceptions;

public class MovieAlreadyExistsException extends Exception{
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public MovieAlreadyExistsException(){}
    public MovieAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }

}
