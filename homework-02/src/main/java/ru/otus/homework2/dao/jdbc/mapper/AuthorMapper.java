package ru.otus.homework2.dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.homework2.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        return new Author(id, name);
    }
}

