package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.FunctionalRequirementCategoryValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid functional requirement category.
 *
 * @version 1.0
 * @see FunctionalRequirementCategoryValidator
 */
@Constraint(validatedBy = FunctionalRequirementCategoryValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FunctionalRequirementCategory {
    String message() default "Invalid functional requirement category";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
