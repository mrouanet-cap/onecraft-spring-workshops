package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.EntityRelationshipTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid entity relationship type.
 *
 * @version 1.0
 * @see EntityRelationshipTypeValidator
 */
@Constraint(validatedBy = EntityRelationshipTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityRelationshipType {
    String message() default "Invalid entity relationship type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
