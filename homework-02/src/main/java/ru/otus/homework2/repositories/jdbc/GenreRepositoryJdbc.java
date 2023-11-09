package ru.otus.homework2.repositories.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Genre;
import ru.otus.homework2.repositories.GenreRepository;
import ru.otus.homework2.repositories.jdbc.mappers.GenreMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class GenreRepositoryJdbc implements GenreRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public GenreRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Genre> findAll() {
        return namedParameterJdbcOperations.query("select id, genretitle from genres", new GenreMapper());
    }

    @Override
    public Optional<Genre> findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        Genre genre = namedParameterJdbcOperations.queryForObject("select id, genretitle from genres where id =:id", params, new GenreMapper());
        return Optional.ofNullable(genre);
    }
}
