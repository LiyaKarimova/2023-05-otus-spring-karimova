package ru.otus.homework2.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.dao.BookDao;
import ru.otus.homework2.dao.jdbc.mapper.BookMapper;
import ru.otus.homework2.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        Integer count = namedParameterJdbcOperations.queryForObject("select count(*) from books", Collections.EMPTY_MAP, Integer.class);
        return count == null ? 0 : count;
    }

    @Override
    public void insert(Book book) {
        namedParameterJdbcOperations.update("insert into books (id, title, genre, author) values :id, :title, :genre, :author",
                Map.of("id", book.getId(), "title", book.getTitle(), "genre", book.getGenre(), "author", book.getAuthor()));
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select * from books where id = :id", params, new BookMapper()
        );
    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("select * from books", new BookMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
    }

}
