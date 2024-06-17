package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ArchitectureConstraintType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the type of an architectural constraint.
 *
 * @see ArchitectureConstraintType
 */
public class ArchitectureConstraintTypeValidator implements ConstraintValidator<ArchitectureConstraintType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "technology choice", "compliance requirement", "performance", "security",
                "scalability", "maintainability", "reliability", "availability", "usability", "interoperability",
                "portability", "privacy", "regulatory", "legal", "ethical", "other");
    }
}
