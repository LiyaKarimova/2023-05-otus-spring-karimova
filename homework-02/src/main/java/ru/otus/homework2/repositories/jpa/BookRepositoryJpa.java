package ru.otus.homework2.repositories.jpa;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

@Repository
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<Book> findById(long id) {
        EntityGraph <?> authorGenreEntityGraph = em.getEntityGraph("books-authors-genres-entity-graph");
        TypedQuery <Book> query =  em.createQuery("select b from Book b where b.id = :id ", Book.class);
        query.setParameter("id",id);
        query.setHint(FETCH.getKey(), authorGenreEntityGraph);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }

    @Override
    public List <Book> findAll() {
        EntityGraph <?> authorGenreEntityGraph = em.getEntityGraph("books-authors-genres-entity-graph");

        TypedQuery <Book> query =  em.createQuery("select b from Book b", Book.class);
        query.setHint(FETCH.getKey(), authorGenreEntityGraph);

        return query.getResultList();
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
        Query query = em.createQuery("delete " +
                "from Book b " +
                "where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
