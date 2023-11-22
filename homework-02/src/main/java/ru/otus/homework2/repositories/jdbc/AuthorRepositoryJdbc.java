package ru.otus.homework2.repositories.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.repositories.AuthorRepository;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.repositories.jdbc.mappers.AuthorMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AuthorRepositoryJdbc implements AuthorRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    @Override
    public List<Author> findAll() {
        return namedParameterJdbcOperations.query("select id, name from authors", new AuthorMapper());
    }

    @Override
    public Optional<Author> findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        Author author = namedParameterJdbcOperations.queryForObject("select id, name from authors where id =:id", params,new AuthorMapper());
        return Optional.ofNullable(author);
    }
}
