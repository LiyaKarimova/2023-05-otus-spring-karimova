package ru.otus.homework2.converters;


import org.springframework.stereotype.Component;
import ru.otus.homework2.domain.Book;
import ru.otus.homework2.domain.Comment;

import java.util.List;

@Component
public class CommentConverter {

    public String commentToString (Comment comment) {
        return ("Id: %d, content: %s").formatted(
                comment.getId(),
                comment.getContent());
    }

    public String commentListToString (List<Comment> commentList) {
        StringBuilder stringBuilder = new StringBuilder();
        commentList.forEach(c -> {
            stringBuilder.append(commentToString(c)).append(";").append("\n");
        });

        return stringBuilder.toString();
    }


    public String commentToStringWithBookInfo(Comment comment) {
        return ("Comment_id: %d, content: %s, Book: %s").formatted(
                comment.getId(),
                comment.getContent(),
                comment.getBook().getTitle());
    }



}
