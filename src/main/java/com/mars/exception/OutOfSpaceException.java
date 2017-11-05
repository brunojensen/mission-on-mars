package com.mars.exception;

public class OutOfSpaceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OutOfSpaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OutOfSpaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfSpaceException(String message) {
        super(message);
    }

    public OutOfSpaceException(Throwable cause) {
        super(cause);
    }

}
