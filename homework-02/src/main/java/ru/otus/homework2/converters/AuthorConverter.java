package ru.otus.homework2.converters;

import org.springframework.stereotype.Component;
import ru.otus.homework2.domain.Author;

@Component
public class AuthorConverter {
    public String authorToString(Author author) {
        return "Id: %d, FullName: %s".formatted(author.getId(), author.getName());
    }
}
