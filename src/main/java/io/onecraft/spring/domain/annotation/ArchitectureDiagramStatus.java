package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ArchitectureDiagramStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid architecture diagram status.
 *
 * @see ArchitectureDiagramStatusValidator
 * @version 1.0
 */
@Constraint(validatedBy = ArchitectureDiagramStatusValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArchitectureDiagramStatus {

    String message() default "Invalid architecture diagram status";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
