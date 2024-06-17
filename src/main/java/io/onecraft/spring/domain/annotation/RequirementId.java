package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.RequirementIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid requirement id.
 *
 * @version 1.0
 * @see RequirementIdValidator
 */
@Constraint(validatedBy = RequirementIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequirementId {
    String pattern() default "^[A-Z]{2,3}-[0-9]{1,4}$";

    String message() default "Invalid requirement id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
