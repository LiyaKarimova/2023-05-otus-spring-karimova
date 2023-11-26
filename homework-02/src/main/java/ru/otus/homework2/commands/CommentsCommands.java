package ru.otus.homework2.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework2.converters.CommentConverter;
import ru.otus.homework2.service.CommentService;

@ShellComponent
public class CommentsCommands {

    private final CommentService commentService;

    private final CommentConverter commentConverter;

    public CommentsCommands(CommentService commentService, CommentConverter commentConverter) {
        this.commentService = commentService;
        this.commentConverter = commentConverter;
    }

    @ShellMethod(value = "Find comment by id", key = "cbid")
    public String findCommentById(long id) {
        return commentService.findById(id)
                .map(commentConverter::commentWithBookToString)
                .orElse("Comment with id %d not found".formatted(id));
    }
}
