package ru.otus.homework2.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class Book {

    private final long id;

    private final String title;

    private Author author;

    private Genre genre;

}
