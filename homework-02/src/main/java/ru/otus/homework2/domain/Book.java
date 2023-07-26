package ru.otus.homework2.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {

    private final long id;

    private final String title;

    private final Long genre;

    private final Long author;

}
