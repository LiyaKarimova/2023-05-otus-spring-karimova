package ru.otus.homework2.repositories;

import ru.otus.homework2.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional <Book> findById(long id);

    List<Book> findAll();

    long insert(Book book);

    void deleteById(long id);
}
