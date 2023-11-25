package ru.otus.homework2.service.jpaServices;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework2.domain.Genre;
import ru.otus.homework2.repositories.GenreRepository;
import ru.otus.homework2.service.GenreService;

import java.util.List;

public class GenreServiceJpa implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceJpa(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
