package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.PositiveOrZeroPage;

public class PageValidator implements ConstraintValidator<PositiveOrZeroPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value >= 0;
    }
}
