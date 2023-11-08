package ru.otus.homework2.repositories.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.repositories.AuthorRepository;
import ru.otus.homework2.repositories.jdbc.mapper.AuthorMapper;
import ru.otus.homework2.domain.Author;

import java.util.List;

@Repository
public class AuthorRepositoryJdbc implements AuthorRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    @Override
    public List<Author> getAll() {
        return namedParameterJdbcOperations.query("select * from authors", new AuthorMapper());
    }
}
