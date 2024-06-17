package io.onecraft.spring.domain.annotation;

import io.onecraft.spring.domain.validator.ArchitectureConstraintTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The annotated element must be a valid architecture constraint type.
 *
 * @see ArchitectureConstraintTypeValidator
 * @version 1.0
 */
@Constraint(validatedBy = ArchitectureConstraintTypeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArchitectureConstraintType {

    String message() default "Invalid architecture constraint type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
