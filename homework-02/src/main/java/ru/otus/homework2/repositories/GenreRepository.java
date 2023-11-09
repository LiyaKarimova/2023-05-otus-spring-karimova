package ru.otus.homework2.repositories;

import ru.otus.homework2.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    List<Genre> findAll();

    Optional<Genre> findById(long id);
}
