package ru.otus.homework2.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Author {

    private final long id;

    private final String name;

}
