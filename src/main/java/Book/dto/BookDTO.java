package Book.dto;

import Book.enums.BookCondition;
import Book.validation.ValidBookCondition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@ValidBookCondition
public class BookDTO {


    private Integer booksId;

    @NotBlank(message="Title is required")
    private String title;

    @NotNull(message="Author is required")
    private AuthorDTO authorId;

    @NotBlank(message="Price is required")
    private Float price;

    private boolean secondHand;

    private BookCondition bookCondition;

}
