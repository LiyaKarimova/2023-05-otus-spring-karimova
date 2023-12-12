package ru.otus.homework2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@NamedEntityGraph(name = "comments-book-graph",
        attributeNodes = {@NamedAttributeNode("book")})
public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "content")
    private String content;

    @ManyToOne
    @JoinColumn (name = "book_id")
    private Book book;

}
