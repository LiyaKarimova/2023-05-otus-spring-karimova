package ru.otus.homework.exception;

public class OtusSpringException extends RuntimeException {

    public OtusSpringException(String message) {
        super(message);
    }

    public OtusSpringException(Throwable cause) {
        super(cause);
    }
}
