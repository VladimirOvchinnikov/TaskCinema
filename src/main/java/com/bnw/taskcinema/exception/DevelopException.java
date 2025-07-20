package com.bnw.taskcinema.exception;

//Эта ошибка из-за разработки.
public class DevelopException extends RuntimeException {

    public static final String MSG = "This error should not happen!!!:";

    public DevelopException() {
        super(MSG);
    }

    public DevelopException(String msg) {
        super(DevelopException.MSG + msg);
    }
}
