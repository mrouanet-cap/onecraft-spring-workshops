package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.DeploymentDiagramStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid deployment diagram status.
 *
 * @version 1.0
 * @see DeploymentDiagramStatusValidator
 */
@Constraint(validatedBy = DeploymentDiagramStatusValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DeploymentDiagramStatus {

    String message() default "Invalid deployment diagram status";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
