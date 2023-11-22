package ru.otus.homework2.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework2.domain.Genre;
import ru.otus.homework2.repositories.jdbc.GenreRepositoryJdbc;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе Jdbc для работы с жанрами")
@JdbcTest
@Import(GenreRepositoryJdbc.class)
public class GenreRepositoryJdbcTest {

    @Autowired
    private GenreRepositoryJdbc genreRepositoryJdbc;

    private List<Genre> genresFromDb;

    @BeforeEach
    private void setUp() {
        genresFromDb = getDBGenres();
    }

    @DisplayName("должен загружать жанры по айди")
    @ParameterizedTest
    @MethodSource("getDBGenres")
    void shouldFindGenreById (Genre expectedGenre) {
        var actualGenre = genreRepositoryJdbc.findById(expectedGenre.getId());

        assertThat(actualGenre).isPresent()
                .get()
                .isEqualTo(expectedGenre);
    }

    @DisplayName("должен загружать список всех жанров")
    @Test
    void shouldFindGenreList () {
        var actualGenres = genreRepositoryJdbc.findAll();
        var expectedGenres = genresFromDb;

        assertThat(actualGenres).containsExactlyElementsOf(expectedGenres);
    }



    private static List<Genre> getDBGenres () {
        return IntStream.range(1,4).boxed()
                .map(id -> new Genre(id,"Genre_" + id))
                .toList();
    }


}


