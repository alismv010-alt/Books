package Book.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="authors")
public class AuthorEntity {
    @Id
    Integer idAuthor;
    @OneToMany(mappedBy = "AuthorEntity", targetEntity = BookEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<BookEntity> books;
    private String name;
    private String surname;
    private LocalDate dateofbirth;
    private LocalDate dateofdeath;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public AuthorEntity setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
        return this;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public AuthorEntity setBooks(List<BookEntity> books) {
        this.books = books;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public AuthorEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public AuthorEntity setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
        return this;
    }

    public LocalDate getDateofdeath() {
        return dateofdeath;
    }

    public AuthorEntity setDateofdeath(LocalDate dateofdeath) {
        this.dateofdeath = dateofdeath;
        return this;
    }
}