package Book.controller;

import Book.dto.AuthorDTO;
import Book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return service.getAllAuthors();
    }
    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable Integer id) {
        return service.getAuthor(id);
    }
}
