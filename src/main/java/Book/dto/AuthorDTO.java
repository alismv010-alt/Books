package Book.dto;

import Book.entity.BookEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AuthorDTO {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
}
