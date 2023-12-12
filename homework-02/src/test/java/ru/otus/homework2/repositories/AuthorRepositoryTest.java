package ru.otus.homework2.repositories;

import jakarta.persistence.EntityManager;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.repositories.jpa.AuthorRepositoryJpa;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с авторами")
@DataJpaTest
@Import(AuthorRepositoryJpa.class)
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    private final int EXPECTED_NUMBER_OF_AUTHORS = 3;

    private static final long FIRST_AUTHOR_ID = 1L;

    @Autowired
    private EntityManager em;

    @DisplayName("должен загружать список всех авторов с полной информацией о них")
    @Test
    void shouldReturnAllAuthorsWithFullInfo() {
        val authors = authorRepositoryJpa.findAll();
        assertThat(authors).isNotNull().hasSize(EXPECTED_NUMBER_OF_AUTHORS)
                .allMatch(s -> !s.getName().isEmpty());
    }

    @DisplayName("должен правильно искать автора по айди")
    @Test
    void shouldReturnCorrectAuthorById () {
        val expectedAuthor = em.find(Author.class, FIRST_AUTHOR_ID);
        val authorFromRepo = authorRepositoryJpa.findById(FIRST_AUTHOR_ID);

        assertThat(authorFromRepo).isPresent().get()
                .usingRecursiveComparison().isEqualTo(expectedAuthor);
    }
}
