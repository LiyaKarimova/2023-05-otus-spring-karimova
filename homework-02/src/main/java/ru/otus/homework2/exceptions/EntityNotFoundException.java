package ru.otus.homework2.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
