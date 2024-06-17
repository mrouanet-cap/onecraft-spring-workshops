package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ArchitectureDiagramFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid architecture diagram format.
 *
 * @see ArchitectureDiagramFormatValidator
 * @version 1.0
 */
@Constraint(validatedBy = ArchitectureDiagramFormatValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArchitectureDiagramFormat {
    String message() default "Invalid architecture diagram format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
