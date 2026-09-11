package Book.Repo;

import Book.Entity.BookEntity;

import java.util.List;

public interface IBookRepo {
    public List<BookEntity> getBooks (String title, Integer author_id,
                                      Float price, Integer id);
}
