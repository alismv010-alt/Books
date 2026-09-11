package Book.DTO;

import jakarta.validation.constraints.NotBlank;

public class BookDTO {

    private Integer idBooks;

    @NotBlank(message="Title is required")
    private String title;

    @NotBlank(message="Author is required")
    private AuthorDTO author_id;

    @NotBlank(message="Price is required")
    private Float price;

    public Integer getIdBooks() {
        return idBooks;
    }

    public BookDTO setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
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
