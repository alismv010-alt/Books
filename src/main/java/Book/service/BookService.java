package Book.service;

import Book.dto.BookDTO;
import Book.mapStruct.BookMapper;
import Book.repo.BookRepo;
import Book.repo.DataBookRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final DataBookRepo datarepo;
    private final BookRepo repo;
    public BookService (DataBookRepo datarepo, BookRepo repo) {
        this.datarepo=datarepo;
        this.repo=repo;
    }
    public List<BookDTO> getList (String title, Integer author_id,
                                  Float price, Integer id, Pageable pageable)
    {
        return repo.getBooks(title, author_id, price, id, pageable)
                .stream()
                .map(BookMapper.MAPPER::toDTO)
                .collect(Collectors.toList());
    }
    public void create (BookDTO dto) {
        datarepo.save(BookMapper.MAPPER.toEntity(dto));
    }
    public void update (BookDTO dto) {
        datarepo.save(BookMapper.MAPPER.toEntity(dto));
    }
    public void delete (Integer id) {
        datarepo.deleteById(id);
    }
}
