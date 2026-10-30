package Book.entity;

import Book.enums.BookCondition;
import Book.enums.BookGenre;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booksId;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "authorId")
    private AuthorEntity authorId;
    private Float price;
    @Column(name="is_second_hand")
    private boolean secondHand;
    @Enumerated(EnumType.STRING)
    private BookCondition condition;
    private String description;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;
}
