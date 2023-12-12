package ru.otus.homework2.repositories;

import ru.otus.homework2.domain.Comment;

import java.util.Optional;

public interface CommentRepository {

    Optional<Comment> findById(long id);

    Comment save(Comment comment);

    void deleteById(long id);


}
