package Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="authors")
public class AuthorsEntity {
    @Id
    Integer idAuthor;
    @OneToMany (mappedBy = "AuthorsEntity", targetEntity =  BooksEntity.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    List<BooksEntity> books;
    String name;
    String surname;
    LocalDate dateofbirth;
    LocalDate dateofdeath;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public AuthorsEntity setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorsEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public AuthorsEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public AuthorsEntity setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
        return this;
    }

    public LocalDate getDateofdeath() {
        return dateofdeath;
    }

    public AuthorsEntity setDateofdeath(LocalDate dateofdeath) {
        this.dateofdeath = dateofdeath;
        return this;
    }
}
