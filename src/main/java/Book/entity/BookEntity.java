package Book.entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_books;

    private String title;

    @ManyToOne (fetch=FetchType.EAGER, optional = false )
    @JoinColumn(name = "author_id")
    private AuthorEntity author_id;

    private Float price;

    private Float cost_price;

    public Float getCost_price() {
        return cost_price;
    }

    public BookEntity setCost_price(Float cost_price) {
        this.cost_price = cost_price;
        return this;
    }

    public Integer getId_books() {
        return id_books;
    }

    public BookEntity setId_books(Integer id_books) {
        this.id_books = id_books;
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
