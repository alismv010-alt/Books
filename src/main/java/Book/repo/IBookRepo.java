package Book.repo;

import Book.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookRepo  {
    public Page<BookEntity> getBooks (String title, Integer author_id,
                                      Float price, Integer id, Pageable pageable);
}
