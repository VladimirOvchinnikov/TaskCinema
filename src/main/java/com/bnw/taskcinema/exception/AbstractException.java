package com.bnw.taskcinema.exception;

public class AbstractException extends RuntimeException {

    private String id;
    private String code;

    public AbstractException(String id, String code, String message) {
        super(message);
        this.id = id;
        this.code = code;
    }


    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
