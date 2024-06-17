package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.NonFunctionalRequirementCategoryValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid non-functional requirement category.
 *
 * @version 1.0
 * @see NonFunctionalRequirementCategoryValidator
 */
@Constraint(validatedBy = NonFunctionalRequirementCategoryValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NonFunctionalRequirementCategory {
    String message() default "Invalid non-functional requirement category";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
