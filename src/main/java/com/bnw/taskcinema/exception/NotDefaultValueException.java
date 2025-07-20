package com.bnw.taskcinema.exception;

public class NotDefaultValueException extends RuntimeException {

    public NotDefaultValueException() {
    }

    public NotDefaultValueException(String message) {
        super(message);
    }
}
