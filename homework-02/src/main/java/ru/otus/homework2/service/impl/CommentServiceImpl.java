package ru.otus.homework2.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.domain.Comment;
import ru.otus.homework2.exceptions.EntityNotFoundException;
import ru.otus.homework2.repositories.BookRepository;
import ru.otus.homework2.repositories.CommentRepository;
import ru.otus.homework2.service.CommentService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    private final BookRepository bookRepository;

    public CommentServiceImpl(CommentRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Comment> findById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<Comment> findByBook(long bookId) {
        List <Comment> comments = bookRepository.findById(bookId).map(Book::getCommentsList).
                orElse(Collections.emptyList());
        return comments.stream().toList();
    }

    @Override
    @Transactional
    public Comment insert(String content, long bookId) {
        return save(0, content, bookId);
    }

    @Override
    @Transactional
    public Comment update(long id, String content, long bookId) {
        return save(id, content, bookId);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public Comment save (long id, String content, long bookId) {
        var book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id %d not found".formatted(bookId)));
        var comment = new Comment(id,content,book);
        return repository.save(comment);
    }
}
