package Book.repository;

import Book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBookRepository extends JpaRepository<BookEntity, Integer>,
        JpaSpecificationExecutor<BookEntity> {

}
