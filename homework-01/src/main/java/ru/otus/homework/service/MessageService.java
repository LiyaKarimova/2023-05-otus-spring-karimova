package ru.otus.homework.service;

public interface MessageService {

    String getMessage (String key);

    String getMessage (String key, String [] options);
}
