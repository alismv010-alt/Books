package Book.Repo;

import Book.Entity.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepo implements IBookRepo {
    private final EntityManager em;


    public BookRepo (EntityManager em) {
        this.em=em;
    }
    public List<BookEntity> getBooks (String title, Integer author_id,
                                      Float price, Integer id)
    {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<BookEntity> cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = cq.from(BookEntity.class);

        List<Predicate> predicates = new ArrayList();
        if (title!=null && !title.isEmpty()) {
            predicates.add(cb.like(root.get("title"),"%" + title + "%" ));
        }
        if (price!=null && price!=0) {
            predicates.add(cb.equal(root.get("price"), price));
        }
        if (id!=null && id!=0) {
            predicates.add(cb.equal(root.get("idBooks"), id));
        }
        if (author_id!=null && author_id!=0) {
            predicates.add(cb.equal(root.get("author_id").get("idAuthor"), author_id ));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));

        cq.where(and);
        cq.select(root);

        return em.createQuery(cq).getResultList();
    }
}
