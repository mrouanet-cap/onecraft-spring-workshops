package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.DataModelConstraintTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid data model constraint type.
 *
 * @version 1.0
 * @see DataModelConstraintTypeValidator
 */
@Constraint(validatedBy = DataModelConstraintTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataModelConstraintType {
    String message() default "Invalid data model constraint type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
