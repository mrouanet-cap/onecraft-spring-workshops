package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ArchitectureDiagramTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid architecture diagram type.
 *
 * @see ArchitectureDiagramTypeValidator
 * @version 1.0
 */
@Constraint(validatedBy = ArchitectureDiagramTypeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArchitectureDiagramType {
    String message() default "Invalid architecture diagram type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
