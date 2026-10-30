package Book.validation;

import Book.dto.BookDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookConditionValidator implements ConstraintValidator<ValidBookCondition, BookDTO> {
    @Override
    public boolean isValid(BookDTO dto, ConstraintValidatorContext context) {
        if (dto==null) return true;
        if (dto.isSecondHand() && dto.getCondition()==null) {
            return fail(context, "Condition is required for second-hand books");
        }
        if (!dto.isSecondHand() && dto.getCondition()!=null) {
            return fail(context, "Condition must be empty for new books" );
        }
        return true;
    }
    private boolean fail(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode("bookCondition")
                .addConstraintViolation();
        return false;
    }
}
