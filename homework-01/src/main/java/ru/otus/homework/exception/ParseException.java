package ru.otus.homework.exception;

public class ParseException extends OtusSpringException {

    public ParseException( Throwable cause) {
        super(cause);
    }

    public ParseException(String message) {
        super(message);
    }
}
