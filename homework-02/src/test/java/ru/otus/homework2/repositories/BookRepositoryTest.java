package ru.otus.homework2.repositories;

import jakarta.persistence.EntityManager;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.domain.Comment;
import ru.otus.homework2.domain.Genre;
import ru.otus.homework2.repositories.jpa.BookRepositoryJpa;
import ru.otus.homework2.repositories.jpa.GenreRepositoryJpa;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({BookRepositoryJpa.class, GenreRepositoryJpa.class, })
public class BookRepositoryTest {

    private final int EXPECTED_NUMBER_OF_BOOKS = 3;

    private final int FIRST_BOOK_ID = 1;

    @Autowired
    private BookRepositoryJpa bookRepositoryJPA;

    @Autowired
    private EntityManager em;


    @DisplayName("должен загружать список всех книг с полной информацией о них")
    @Test
    void shouldReturnCorrectBooksListWithFullInfo() {
        val books = bookRepositoryJPA.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(s -> !s.getTitle().isEmpty())
                .allMatch(s -> s.getAuthor() != null && !s.getAuthor().getName().isEmpty())
                .allMatch(s -> s.getGenre() != null && !s.getGenre().getGenreTitle().isEmpty());
    }


    @DisplayName("должен правильно искать книгу по айди")
    @Test
    void shouldReturnCorrectById () {
        var expectedBook = em.find(Book.class, FIRST_BOOK_ID);
        var bookFromRepo = bookRepositoryJPA.findById(FIRST_BOOK_ID);

        assertThat(bookFromRepo).isPresent().get()
                .usingRecursiveComparison().isEqualTo(expectedBook);

    }

    @DisplayName("должен добавлять новую книгу")
    @Test
    void shouldInsertNewBook () {
        Book book = Book.builder()
                .id(0)
                .title("NEW BOOK")
                .author(em.find(Author.class, 1))
                .genre(em.find(Genre.class, 1))
                .build();
        var newBook = bookRepositoryJPA.save(book);
        var expectedBook = bookRepositoryJPA.findById(newBook.getId());

        assertThat(expectedBook).isPresent().get()
                .usingRecursiveComparison().isEqualTo(newBook);

    }

    @DisplayName("должен удалять книгу со списком всех комментариев к ней")
    @Test
    void shouldDeleteBook () {
        bookRepositoryJPA.deleteById(FIRST_BOOK_ID);
        var updatedBookNumber = bookRepositoryJPA.findAll().size();
        var commentListSize = em.createQuery("select c from Comment c where c.book.id = " + FIRST_BOOK_ID, Comment.class).getResultList();
        assertThat(updatedBookNumber).isEqualTo(EXPECTED_NUMBER_OF_BOOKS - 1);
        assertThat(commentListSize).hasSize(0);
    }


}
