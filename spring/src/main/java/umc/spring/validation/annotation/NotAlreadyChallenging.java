package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import umc.spring.validation.validator.NotAlreadyChallengingValidator;

@Documented
@Constraint(validatedBy = NotAlreadyChallengingValidator.class)
@Target({ ElementType.PARAMETER }) // PathVariable에 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAlreadyChallenging {
    String message() default "ALREADY_CHALLENGING";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

