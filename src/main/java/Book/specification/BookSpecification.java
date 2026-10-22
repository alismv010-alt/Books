package Book.specification;

import Book.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<BookEntity> titleContains(String title) {
        return (root, query, cb) ->
                (title == null || title.isEmpty())
                        ? cb.conjunction()
                        : cb.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<BookEntity> priceEquals(Float price) {
        return (root, query, cb) ->
                (price == null || price == 0)
                        ? cb.conjunction()
                        : cb.equal(root.get("price"), price);
    }

    public static Specification<BookEntity> idEquals(Integer id) {
        return (root, query, cb) ->
                (id == null || id == 0)
                        ? cb.conjunction()
                        : cb.equal(root.get("booksId"), id);
    }

    public static Specification<BookEntity> authorNameContains(String authorName) {
        return (root, query, cb) -> {
            if (authorName == null || authorName.isBlank()) {
                return cb.conjunction();
            } else {
                String pattern = "%" + authorName.trim().toLowerCase() + "%";
                return cb.like(root.get("authorId").get("name"), pattern);
            }

        };
    }
}