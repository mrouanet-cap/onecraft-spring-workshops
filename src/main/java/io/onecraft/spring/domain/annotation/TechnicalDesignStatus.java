package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.TechnicalDesignStatusValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid technical design status.
 *
 * @see TechnicalDesignStatusValidator
 * @version 1.0
 */
@Constraint(validatedBy = TechnicalDesignStatusValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TechnicalDesignStatus {
    String message() default "Invalid technical design status";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
