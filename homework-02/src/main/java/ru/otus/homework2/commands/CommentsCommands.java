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
                .map(commentConverter::commentToStringWithBookInfo)
                .orElse("Comment with id %d not found".formatted(id));
    }


    @ShellMethod(value = "Find all comments by book", key = "acbb")
    public String findAllCommentsByBook(long bookId) {
        return commentConverter.commentListToString(commentService.findByBook(bookId));
    }

    @ShellMethod(value = "Insert comment", key = "cins")
    public String insertComment(String content, long bookId) {
        var savedComment = commentService.insert(content,bookId);
        return commentConverter.commentToString(savedComment);
    }

    @ShellMethod(value = "Update comment", key = "cupd")
    public String updateComment(long id, String content, long bookId) {
        var savedComment = commentService.update(id, content,bookId);
        return commentConverter.commentToString(savedComment);
    }

    @ShellMethod(value = "Delete comment by id", key = "cdel")
    public void deleteComment(long id) {
        commentService.deleteById(id);
    }
}
