package org.chap06.exception;

public class InAppropriateException extends RuntimeException{
    public InAppropriateException() {
    }

    public InAppropriateException(String message) {
        super(message);
    }

    public InAppropriateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InAppropriateException(Throwable cause) {
        super(cause);
    }

    public InAppropriateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
