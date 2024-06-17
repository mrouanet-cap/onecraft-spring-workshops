package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ProjectStatusValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid project status.
 *
 * @version 1.0
 * @see ProjectStatusValidator
 */
@Constraint(validatedBy = ProjectStatusValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ProjectStatus {
    String message() default "Invalid project status";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
