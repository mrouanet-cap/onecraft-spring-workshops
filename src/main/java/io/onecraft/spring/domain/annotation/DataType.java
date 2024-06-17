package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.DataTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid data type.
 *
 * @version 1.0
 * @see DataTypeValidator
 */
@Constraint(validatedBy = DataTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataType {
    String message() default "Invalid data type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
