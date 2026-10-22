package Book.repository;

import Book.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
