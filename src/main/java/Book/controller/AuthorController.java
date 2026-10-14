package Book.controller;

import Book.dto.AuthorDTO;
import Book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@CrossOrigin
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping("/id")
    public AuthorDTO getAuthor(@RequestParam Integer id) {
        return service.getAuthor(id);
    }
}
