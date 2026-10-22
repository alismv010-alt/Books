package Book.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AuthorDTO {
    private Integer id;
    private String name;
    private String surname;
    private List<BookDTO> books;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
}
