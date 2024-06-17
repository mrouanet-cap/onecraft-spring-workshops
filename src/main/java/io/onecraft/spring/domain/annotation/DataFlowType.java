package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.DataFlowTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid data flow type.
 *
 * @version 1.0
 * @see DataFlowTypeValidator
 */
@Constraint(validatedBy = DataFlowTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFlowType {
    String message() default "Invalid data flow type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
