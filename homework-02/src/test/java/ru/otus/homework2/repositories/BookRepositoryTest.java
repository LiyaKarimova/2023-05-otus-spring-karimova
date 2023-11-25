package ru.otus.homework2.repositories;

import jakarta.persistence.EntityManager;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.repositories.jpa.BookRepositoryJpa;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BookRepositoryJpa.class)
public class BookRepositoryTest {

    private final int EXPECTED_NUMBER_OF_BOOKS = 3;

    private final int EXPECTED_QUERIES_COUNT = 1;

    private final int FIRST_BOOK_ID = 1;

    @Autowired
    private BookRepositoryJpa bookRepositoryJPA;

    @Autowired
    private EntityManager em;


    @DisplayName("должен загружать список всех книг с полной информацией о них")
    @Test
    void shouldReturnCorrectBooksListWithFullInfo() {
        SessionFactory sessionFactory = em.getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);

        val books = bookRepositoryJPA.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(s -> !s.getTitle().isEmpty())
                .allMatch(s -> s.getAuthor() != null && !s.getAuthor().getName().isEmpty())
                .allMatch(s -> s.getGenre() != null && !s.getGenre().getGenreTitle().isEmpty());

        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QUERIES_COUNT);
    }


    @DisplayName("должен правильно искать автора по айди")
    @Test
    void shouldReturnCorrectAuthorById () {
        val expectedAuthor = em.find(Author.class, FIRST_BOOK_ID);
        val authorFromRepo = bookRepositoryJPA.findById(FIRST_BOOK_ID);

        assertThat(authorFromRepo).isPresent().get()
                .usingRecursiveComparison().isEqualTo(expectedAuthor);
    }

}
