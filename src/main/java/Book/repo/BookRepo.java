package Book.repo;

import Book.entity.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepo implements IBookRepo   {
    private final EntityManager em;


    public BookRepo (EntityManager em) {
        this.em=em;
    }
    public Page<BookEntity> getBooks (String title, Integer author_id,
                                      Float price, Integer id, Pageable pageable)
    {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<BookEntity> cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = cq.from(BookEntity.class);

        List<Predicate> predicates =buildPredicates(cb, root, title, author_id, price, id);
        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));
        cq.where(and);
        cq.select(root);

        List<Order> orders = new ArrayList<>();
        for (Sort.Order sortOrder : pageable.getSort()) {
            if (sortOrder.isAscending()) {
                orders.add(cb.asc(root.get(sortOrder.getProperty())));
            } else {
                orders.add(cb.desc(root.get(sortOrder.getProperty())));
            }
        }

        TypedQuery<BookEntity> query = em.createQuery(cq);
        query.setFirstResult((int)pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<BookEntity> results = query.getResultList();

        final CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<BookEntity> countRoot = countQuery.from(BookEntity.class);
        List<Predicate> countPredicates = buildPredicates(cb, countRoot, title, author_id, price, id);
        countQuery.select(cb.count(countRoot)).where(cb.and(countPredicates.toArray(new Predicate[0])));

        Long total = em.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(results, pageable, total);
    }
    private List<Predicate> buildPredicates(CriteriaBuilder cb, Root<BookEntity> root,
                                            String title, Integer author_id, Float price, Integer id) {
        List<Predicate> predicates = new ArrayList<>();
        if (title != null && !title.isEmpty()) {
            predicates.add(cb.like(root.get("title"), "%" + title + "%"));
        }
        if (price != null && price != 0) {
            predicates.add(cb.equal(root.get("price"), price));
        }
        if (id != null && id != 0) {
            predicates.add(cb.equal(root.get("id_books"), id));
        }
        if (author_id != null && author_id != 0) {
            predicates.add(cb.equal(root.get("author_id").get("id"), author_id));
        }
        return predicates;
    }
}
