package ru.otus.homework2.repositories.jdbc;

import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Genre;
import ru.otus.homework2.repositories.GenreRepository;

@Repository
public class GenreRepositoryJdbc implements GenreRepository {
    @Override
    public Genre getById() {
        return null;
    }
}
