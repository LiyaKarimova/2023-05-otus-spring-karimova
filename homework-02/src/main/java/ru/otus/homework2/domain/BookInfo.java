package ru.otus.homework2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.domain.Book;

@Getter
@AllArgsConstructor
public class BookInfo {

    private String bookTitle;

    private String authorName;

}
