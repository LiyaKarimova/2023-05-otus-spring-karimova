package ru.otus.homework2.repositories;

import ru.otus.homework2.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Optional<Comment> findById(long id);

    List <Comment> findByBook (long bookId);

    Comment save(Comment comment);

    void deleteById(long id);


}
