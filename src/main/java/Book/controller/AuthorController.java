package Book.controller;

import Book.dto.AuthorDTO;
import Book.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@CrossOrigin
public class AuthorController {
    private final AuthorService service;

    public AuthorController (AuthorService service) {
        this.service=service;
    }

    @GetMapping("/id")
    public AuthorDTO getAuthor(@RequestParam Integer id) {
        return service.getAuthor(id);
    }
}
