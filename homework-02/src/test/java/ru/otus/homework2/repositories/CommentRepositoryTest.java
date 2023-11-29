package ru.otus.homework2.repositories;

import jakarta.persistence.EntityManager;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework2.repositories.jpa.CommentRepositoryJpa;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(CommentRepositoryJpa.class)
public class CommentRepositoryTest {

    @Autowired
    private CommentRepositoryJpa commentRepositoryJpa;

    @Autowired
    private EntityManager em;

    private final int EXPECTED_COUNT_OF_COMMENTS = 2;

    private final int BOOK_ID = 2;

    @DisplayName("должен выгружать список комментарией по айди книги")
    @Test
    void shouldReturnCommentListByBook () {
        val comments = commentRepositoryJpa.findByBook(BOOK_ID);
        assertThat(comments).isNotNull().hasSize(EXPECTED_COUNT_OF_COMMENTS)
                .allMatch(c -> c.getContent() != null && !c.getContent().isEmpty())
                .allMatch(c -> c.getBook() != null);

    }

}
