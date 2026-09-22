package Book.service;

import Book.controllerAdvicer.AuthorNotFoundException;
import Book.dto.AuthorDTO;
import Book.mapStruct.AuthorMapper;
import Book.repo.DataAuthorRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final DataAuthorRepo datarepo;
    public AuthorService (DataAuthorRepo datarepo) {
        this.datarepo=datarepo;
    }
    public AuthorDTO getAuthor (Integer id) {
        return datarepo.findById(id).map(AuthorMapper.MAPPER::toDTO)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }
}
