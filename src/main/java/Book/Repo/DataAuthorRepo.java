package Book.Repo;

import Book.Entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAuthorRepo extends JpaRepository<AuthorEntity, Integer> {
}
