package Book.DTO;

public class BookDTO {
    private Integer idBooks;

    private String name;

    private AuthorDTO author;

    private Float price;

    public Integer getIdBooks() {
        return idBooks;
    }

    public BookDTO setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookDTO setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public BookDTO setAuthor(AuthorDTO author) {
        this.author = author;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public BookDTO setPrice(Float price) {
        this.price = price;
        return this;
    }


}
