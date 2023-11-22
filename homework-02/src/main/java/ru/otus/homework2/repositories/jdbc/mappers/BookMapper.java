package ru.otus.homework2.repositories.jdbc.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        long bookId = rs.getLong("bookID");
        String name = rs.getString("bookTitle");
        long authorId = rs.getLong("authorId");
        long genreId = rs.getLong("genreId");
        String authorName = rs.getString("authorName");
        String genreTitle = rs.getString("genreTitle");
        return new Book(bookId,name,new Author(authorId,authorName), new Genre(genreId, genreTitle));
    }

}
