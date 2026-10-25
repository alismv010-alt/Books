package Book.entity;

import Book.enums.BookCondition;
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
    private BookCondition bookCondition;
}
