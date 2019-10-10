package com.stackroute.Movie.exception;

public class MovieAlreadyExistException extends Exception{

    String message;

    public MovieAlreadyExistException() {
    }

    public MovieAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }


}
