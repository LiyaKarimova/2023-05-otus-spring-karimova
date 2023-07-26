package ru.otus.homework2.dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.homework2.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("title");
        long authorId = rs.getLong("authorId");
        long genreId = rs.getLong("genreId");
        return new Book(id,name,genreId,authorId);
    }

}
