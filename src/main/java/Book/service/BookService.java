package Book.service;

import Book.dto.BookDTO;
import Book.entity.BookEntity;
import Book.mapStruct.BookMapper;
import Book.repository.bookRepository.DataBookRepository;
import Book.specification.BookSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final DataBookRepository datarepo;
    public Page<BookDTO> getList (String title, Integer authorId,
                                  Float price, Integer id, Pageable pageable)
    {
        Specification<BookEntity> spec = Specification
                .where(BookSpecification.titleContains(title))
                .and(BookSpecification.priceEquals(price))
                .and(BookSpecification.idEquals(id))
                .and(BookSpecification.authorIdEquals(authorId));

        return datarepo.findAll(spec, pageable)
                .map(BookMapper.MAPPER::toDTO);
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
