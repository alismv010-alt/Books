package Book.controller;

import Book.dto.BookDTO;
import Book.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public Page<BookDTO> getBooks (@RequestParam(required = false) String title,
                                   @RequestParam(required = false) String authorName,
                                   @RequestParam(required = false) Float price,
                                   @RequestParam(required = false) Integer id,
                                   Pageable pageable)
    {
        return service.getList(title,authorName,price,id, pageable);
    }

    @PostMapping
    public void createBook (@Valid @RequestBody BookDTO dto) {
        service.create(dto);
    }

    @PutMapping
    public void updateBook (@Valid @RequestBody BookDTO dto) {
        service.update(dto);
    }
    @DeleteMapping
    public void deleteBook (@RequestParam Integer id) {
        service.delete(id);
    }
}
