package com.app.sample.advice;

public class ObjectInvalidException extends RuntimeException {

    public ObjectInvalidException(String message) {
        super(message);
    }

    public ObjectInvalidException() {
    }
}
