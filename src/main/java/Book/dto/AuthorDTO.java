package Book.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDTO {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
}
