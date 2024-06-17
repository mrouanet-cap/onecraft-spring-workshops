package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.NodeResourceTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid node resource type.
 *
 * @version 1.0
 * @see NodeResourceTypeValidator
 */
@Constraint(validatedBy = NodeResourceTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NodeResourceType {
    String message() default "Invalid node resource type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
