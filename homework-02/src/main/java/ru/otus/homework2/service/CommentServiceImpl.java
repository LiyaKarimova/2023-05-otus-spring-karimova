package ru.otus.homework2.service;

import org.springframework.stereotype.Service;
import ru.otus.homework2.domain.Comment;
import ru.otus.homework2.repositories.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Comment> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Comment> findByBook(long bookId) {
        return null;
    }

    @Override
    public Comment insert(String content, long bookId) {
        return null;
    }

    @Override
    public Comment update(long id, String content, long bookId) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
