package ru.otus.homework2.service.jpaServices;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework2.domain.Author;
import ru.otus.homework2.repositories.AuthorRepository;
import ru.otus.homework2.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceJpa implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceJpa(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
