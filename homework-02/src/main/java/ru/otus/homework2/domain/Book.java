package ru.otus.homework2.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "books")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "books-authors-genres-entity-graph",
                attributeNodes =
                        {@NamedAttributeNode("genre"),
                                @NamedAttributeNode("author")})
})
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "title")
    private  String title;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "AuthorId")
    private Author author;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "GenreId")
    private Genre genre;

    @OneToMany (mappedBy = "book", cascade = CascadeType.ALL)
    private List<Comment> commentsList;

    public Book(long id, String title, Author author, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
