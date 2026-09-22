package Book.dto;

import jakarta.validation.constraints.NotBlank;

public class BookDTO {

    private Integer id_books;

    @NotBlank(message="Title is required")
    private String title;

    @NotBlank(message="Author is required")
    private AuthorDTO author_id;

    @NotBlank(message="Price is required")
    private Float price;

    public Integer getId_books() {
        return id_books;
    }

    public BookDTO setId_books(Integer id_books) {
        this.id_books = id_books;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public AuthorDTO getAuthor_id() {
        return author_id;
    }

    public BookDTO setAuthor_id(AuthorDTO author_id) {
        this.author_id = author_id;
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
