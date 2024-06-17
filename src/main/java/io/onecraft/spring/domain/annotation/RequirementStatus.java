package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.RequirementStatusValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid requirement status.
 *
 * @see RequirementStatusValidator
 * @version 1.0
 */
@Constraint(validatedBy = RequirementStatusValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequirementStatus {
    String message() default "Invalid requirement status";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
