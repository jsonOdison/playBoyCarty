package com.cartOfLife.playBoyCarty.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);  // Pass the message to the superclass constructor
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
