package Book.service;

import Book.controllerAdvicer.AuthorNotFoundException;
import Book.dto.AuthorDTO;
import Book.mapStruct.AuthorMapper;
import Book.repository.authorRepository.DataAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final DataAuthorRepository datarepo;
    public AuthorDTO getAuthor (Integer id) {
        return datarepo.findById(id).map(AuthorMapper.MAPPER::toDTO)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }
}
