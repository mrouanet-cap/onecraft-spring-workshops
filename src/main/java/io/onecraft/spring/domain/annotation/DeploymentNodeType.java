package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.DeploymentNodeTypeValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid deployment node type.
 *
 * @version 1.0
 * @see DeploymentNodeTypeValidator
 */
@Constraint(validatedBy = DeploymentNodeTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DeploymentNodeType {
    String message() default "Invalid deployment node type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
