package com.stackroute.exceptions;

public class UserNameAlreadyExistsException extends Exception{
    private String message;

    public UserNameAlreadyExistsException() {
    }
    public UserNameAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }


}
