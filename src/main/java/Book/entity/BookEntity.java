package Book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="books_id")
    private Integer booksId;

    private String title;

    @ManyToOne (fetch=FetchType.EAGER, optional = false )
    @JoinColumn(name = "author_id")
    private AuthorEntity authorId;

    private Float price;

    @Column(name="cost_price")
    private Float costPrice;

}
