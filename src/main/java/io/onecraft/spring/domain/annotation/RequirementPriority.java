package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.RequirementPriorityValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid requirement priority.
 *
 * @version 1.0
 * @see RequirementPriorityValidator
 */
@Constraint(validatedBy = RequirementPriorityValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequirementPriority {
    String message() default "Invalid requirement priority";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
