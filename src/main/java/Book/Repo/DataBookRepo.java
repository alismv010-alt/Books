package Book.Repo;

import Book.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBookRepo extends JpaRepository<BookEntity, Integer> {

}
