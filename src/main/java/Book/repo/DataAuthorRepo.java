package Book.repo;

import Book.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAuthorRepo extends JpaRepository<AuthorEntity, Integer> {
}
