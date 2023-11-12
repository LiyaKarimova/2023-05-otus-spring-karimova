package ru.otus.homework2.repositories.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.repositories.BookRepository;
import ru.otus.homework2.repositories.jdbc.mappers.BookMapper;
import ru.otus.homework2.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepositoryJdbc implements BookRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Optional <Book> findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        try {
            Book book = namedParameterJdbcOperations.queryForObject(
                    "select books.id as bookID, " +
                            "books.title as bookTitle, " +
                            "authors.id as authorID, " +
                            "authors.name AS authorName,  " +
                            "genres.id as genreID, " +
                            "genres.genretitle as genreTitle " +
                            "from books left join authors " +
                            "on (books.authorId = authors.id) " +
                            "left join genres on (books.genreid = genres.id) " +
                            "where books.id = :id", params, new BookMapper()
            );
            return Optional.ofNullable(book);
        } catch (DataAccessException e) {
            return Optional.empty();
        }

    }

    @Override
    public List<Book> findAll() {
        return namedParameterJdbcOperations.query("select books.id as bookID, " +
                "books.title as bookTitle, " +
                        "authors.id as authorID, " +
                        "authors.name AS authorName,  " +
                        "genres.id as genreID, " +
                        "genres.genretitle as genreTitle " +
                        "from books left join authors " +
                        "on (books.authorId = authors.id) " +
                        "left join genres on (books.genreid = genres.id)", new BookMapper());
    }


    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            return insert(book);
        }
        return update(book);
    }

    private Book insert(Book book) {
        var keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource(Map.of ( "title", book.getTitle(), "genre", book.getGenre().getId(), "author", book.getAuthor().getId()));
        namedParameterJdbcOperations.update("insert into books (`title`,`authorid`, `genreid`) values (:title, :author, :genre)",
                params, keyHolder,new String[]{"id"});


        book.setId(keyHolder.getKey().longValue());
        return book;
    }

    private Book update(Book book) {
        MapSqlParameterSource params = new MapSqlParameterSource(Map.of ( "id", book.getId(),"title", book.getTitle(), "genre", book.getGenre().getId(), "author", book.getAuthor().getId()));
        namedParameterJdbcOperations.update ("update books set title = :title, genreid =:genre, authorid =:author where id =:id ", params);
        return book;
    }

}
