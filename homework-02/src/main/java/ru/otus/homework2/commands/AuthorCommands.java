package ru.otus.homework2.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework2.converters.AuthorConverter;
import ru.otus.homework2.service.AuthorService;

import java.util.stream.Collectors;


@ShellComponent
public class AuthorCommands {

    private final  AuthorService authorService;

    private final AuthorConverter authorConverter;

    public AuthorCommands(AuthorConverter authorConverter, AuthorService authorService) {
        this.authorService = authorService;
        this.authorConverter = authorConverter;
    }


    @ShellMethod(value = "Find all authors", key = "aa")
    public String findAllAuthors() {
        return "All: " + authorService.findAll().stream()
                .map(authorConverter::authorToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }
}
