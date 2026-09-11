package Book.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooks;

    private String title;

    @ManyToOne (fetch=FetchType.EAGER, optional = false )
    private AuthorEntity author_id;

    private Float price;

    public Integer getIdBooks() {
        return idBooks;
    }

    public BookEntity setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public AuthorEntity getAuthor_id() {
        return author_id;
    }

    public BookEntity setAuthor(AuthorEntity author_id) {
        this.author_id = author_id;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public BookEntity setPrice(Float price) {
        this.price = price;
        return this;
    }
}
