package Book.DTO;

import java.time.LocalDate;

public class AuthorDTO {
    private String name;
    private String surname;
    private LocalDate dateofbirth;

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public AuthorDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public AuthorDTO setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
        return this;
    }

    public LocalDate getDateofdeath() {
        return dateofdeath;
    }

    public AuthorDTO setDateofdeath(LocalDate dateofdeath) {
        this.dateofdeath = dateofdeath;
        return this;
    }

    private LocalDate dateofdeath;
}
