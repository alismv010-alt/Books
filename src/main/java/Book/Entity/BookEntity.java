package Book.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooks;

    private String name;

    @ManyToOne (fetch=FetchType.EAGER, optional = false )
    private AuthorEntity author;

    private Float price;

    public Integer getIdBooks() {
        return idBooks;
    }

    public BookEntity setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookEntity setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public BookEntity setAuthor(AuthorEntity author) {
        this.author = author;
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
