package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.DeploymentDiagramFormatValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid deployment diagram format.
 *
 * @version 1.0
 * @see DeploymentDiagramFormatValidator
 */
@Constraint(validatedBy = DeploymentDiagramFormatValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DeploymentDiagramFormat {
    String message() default "Invalid deployment diagram format";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
