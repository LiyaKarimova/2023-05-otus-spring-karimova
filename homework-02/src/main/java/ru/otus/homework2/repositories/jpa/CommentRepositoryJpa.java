package ru.otus.homework2.repositories.jpa;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Comment;
import ru.otus.homework2.repositories.CommentRepository;

import java.util.Optional;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

@Repository
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    public CommentRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Comment> findById(long id) {

        EntityGraph <?> entityGraph = em.getEntityGraph("comments-book-graph");
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where id= :id", Comment.class);
        query.setParameter("id", id);
        query.setHint(FETCH.getKey(),entityGraph);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0) {
            em.persist(comment);
            return comment;
        }
        return em.merge(comment);
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Comment c " +
                "where c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
