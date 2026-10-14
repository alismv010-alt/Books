package Book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="authors")
@Data
public class AuthorEntity {
    @Id
    private Integer id;
    @OneToMany(mappedBy = "authorId", targetEntity = BookEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BookEntity> books;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
}