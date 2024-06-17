package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ConnectionProtocolValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid connection protocol.
 *
 * @version 1.0
 * @see ConnectionProtocolValidator
 */
@Constraint(validatedBy = ConnectionProtocolValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConnectionProtocol {
    String message() default "Invalid connection protocol";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
