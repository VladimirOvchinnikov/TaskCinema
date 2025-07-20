package com.bnw.taskcinema.exception;

import java.util.Objects;

public class ValidationException extends RuntimeException {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Object obj, String message) {
        super(message);
    }

}
