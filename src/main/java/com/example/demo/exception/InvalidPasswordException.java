package com.example.demo.exception;

public class InvalidPasswordException extends RuntimeException{

    private String message;

    public InvalidPasswordException() {
        super();
        message = "Invalid transaction";
    }

    public InvalidPasswordException(String message) {
        super(message);
        this.message = message;
    }
}
