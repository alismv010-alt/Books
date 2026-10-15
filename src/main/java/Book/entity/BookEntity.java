package Book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booksId;

    private String title;

    @ManyToOne (fetch=FetchType.EAGER, optional = false )
    @JoinColumn(name = "authorId")
    private AuthorEntity authorId;

    private Float price;

    private Float costPrice;

}
