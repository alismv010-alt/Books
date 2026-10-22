package Book.service;

import Book.controllerAdvicer.AuthorNotFoundException;
import Book.dto.AuthorDTO;
import Book.mapStruct.AuthorMapper;
import Book.repository.DataAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final DataAuthorRepository datarepo;
    private final AuthorMapper authorMapper;
    @Transactional(readOnly = true)
    public AuthorDTO getAuthor (Integer id) {
        return datarepo.findById(id).map(authorMapper::toDTO)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }
    @Transactional(readOnly = true)
    public List<AuthorDTO> getAllAuthors() {
        return datarepo.findAll().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
