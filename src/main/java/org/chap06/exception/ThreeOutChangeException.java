package org.chap06.exception;

public class ThreeOutChangeException extends RuntimeException{
    public ThreeOutChangeException() {
    }

    public ThreeOutChangeException(String message) {
        super(message);
    }

    public ThreeOutChangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThreeOutChangeException(Throwable cause) {
        super(cause);
    }

    public ThreeOutChangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
