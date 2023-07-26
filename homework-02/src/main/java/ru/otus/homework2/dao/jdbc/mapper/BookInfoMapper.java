package ru.otus.homework2.dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.homework2.domain.BookInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfoMapper implements RowMapper <BookInfo> {

    @Override
    public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        String bookTitle = rs.getString("Title");
        String authorName = rs.getString("Name");
        return new BookInfo(bookTitle, authorName);
    }
}
