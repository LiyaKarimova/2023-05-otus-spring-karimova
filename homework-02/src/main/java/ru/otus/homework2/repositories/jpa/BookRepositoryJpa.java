package ru.otus.homework2.repositories.jpa;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.repositories.BookRepository;

import java.util.List;
import java.util.Optional;


@Repository
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<Book> findById(long id) {
        Book book =  em.find(Book.class, id);
        try {
            return Optional.of(book);
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }

    @Override
    public List <Book> findAll() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            em.persist(book);
            return book;
        }
        return em.merge(book);
    }

    @Override
    public void deleteById(long id) {
        var book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }
}
