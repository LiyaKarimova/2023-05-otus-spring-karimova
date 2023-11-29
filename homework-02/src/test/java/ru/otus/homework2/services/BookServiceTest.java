package ru.otus.homework2.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.repositories.jpa.AuthorRepositoryJpa;
import ru.otus.homework2.repositories.jpa.BookRepositoryJpa;
import ru.otus.homework2.repositories.jpa.GenreRepositoryJpa;
import ru.otus.homework2.service.BookService;
import ru.otus.homework2.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class BookServiceTest {

    private final int FIRST_BOOK_ID = 1;

    @MockBean
    private BookRepositoryJpa bookRepositoryMocked;

    @MockBean
    private AuthorRepositoryJpa authorRepositoryMocked;

    @MockBean
    private GenreRepositoryJpa genreRepositoryMocked;

    @Autowired
    private BookServiceImpl bookService;

    @DisplayName("возвращает книгу по айди")
    @Test
    public void shouldReturnBook () {
        Book book = Book.builder()
                .id(1)
                .title("title")
                .build();
        given(bookRepositoryMocked.findById(FIRST_BOOK_ID)).willReturn(Optional.of(book));
        var bookFromService = bookService.findById(FIRST_BOOK_ID);
        Assertions.assertNotNull(bookFromService);
    }

    @DisplayName("возвращает список книг")
    @Test
    public void shouldReturnListOfBooks () {
        List <Book> books = List.of(new Book(), new Book());
        given (bookRepositoryMocked.findAll()).willReturn(books);
        assertThat(bookService.findAll().size()).isEqualTo(2);
    }



}
