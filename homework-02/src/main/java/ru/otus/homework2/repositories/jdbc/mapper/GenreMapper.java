package ru.otus.homework2.repositories.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.homework2.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper <Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String genreTitle = rs.getString("genreTitle");
        return new Genre(id, genreTitle);
    }
}
