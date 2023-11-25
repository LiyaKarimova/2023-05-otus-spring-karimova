package ru.otus.homework2.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "AuthorId")
    private Author author;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "GenreId")
    private Genre genre;

}
