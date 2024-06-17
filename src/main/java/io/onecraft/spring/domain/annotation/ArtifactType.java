package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ArtifactTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid artifact type.
 *
 * @see ArtifactTypeValidator
 * @version 1.0
 */
@Constraint(validatedBy = ArtifactTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArtifactType {
    String message() default "Invalid artifact type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
