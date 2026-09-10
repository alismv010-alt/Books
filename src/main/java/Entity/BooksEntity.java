package Entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooks;

    private String name;

    @ManyToOne (fetch=FetchType.EAGER, optional = false )
    private AuthorsEntity author;

    private Float price;

    public Integer getIdBooks() {
        return idBooks;
    }

    public BooksEntity setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
        return this;
    }

    public String getName() {
        return name;
    }

    public BooksEntity setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorsEntity getAuthor() {
        return author;
    }

    public BooksEntity setAuthor(AuthorsEntity author) {
        this.author = author;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public BooksEntity setPrice(Float price) {
        this.price = price;
        return this;
    }
}
