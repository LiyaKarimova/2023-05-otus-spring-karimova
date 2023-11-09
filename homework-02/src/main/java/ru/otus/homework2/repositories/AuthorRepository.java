package ru.otus.homework2.repositories;

import ru.otus.homework2.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    List<Author> findAll();

    Optional<Author> findById(long id);
}
