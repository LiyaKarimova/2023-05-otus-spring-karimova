package ru.otus.homework2.repositories.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.repositories.BookRepository;
import ru.otus.homework2.repositories.jdbc.mapper.BookMapper;
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
    public long insert(Book book) {
        return 0;
//        namedParameterJdbcOperations.update("insert into books (id, title, genre, author) values :id, :title, :genre, :author",
//                Map.of("id", book.getId(), "title", book.getTitle(), "genre", book.getGenre(), "author", book.getAuthor()));
    }

    @Override
    public Optional <Book> findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
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

}
