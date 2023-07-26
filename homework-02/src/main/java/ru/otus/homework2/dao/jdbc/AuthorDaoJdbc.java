package ru.otus.homework2.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.dao.AuthorDao;
import ru.otus.homework2.dao.jdbc.mapper.AuthorMapper;
import ru.otus.homework2.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id",id);
        return namedParameterJdbcOperations.queryForObject("select * from authors where id = :id", params, new AuthorMapper());
    }
}
