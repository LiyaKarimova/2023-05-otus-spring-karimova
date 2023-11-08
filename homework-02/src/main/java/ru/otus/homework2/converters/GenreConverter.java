package ru.otus.homework2.converters;

import org.springframework.stereotype.Component;
import ru.otus.homework2.domain.Genre;

@Component
public class GenreConverter {
    public String genreToString(Genre genre) {
        return "Id: %d, Name: %s".formatted(genre.getId(), genre.getGenreTitle());
    }
}
