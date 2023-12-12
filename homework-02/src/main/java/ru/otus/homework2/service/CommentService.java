package ru.otus.homework2.service;

import ru.otus.homework2.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> findById(long id);

    List<Comment> findByBook (long bookId);

    Comment insert(String content, long bookId);

    Comment update(long id, String content, long bookId);

    void deleteById(long id);
}
