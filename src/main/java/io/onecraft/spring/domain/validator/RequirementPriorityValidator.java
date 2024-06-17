package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.RequirementPriority;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the priority of a requirement.
 *
 * @see RequirementPriority
 */
public class RequirementPriorityValidator implements ConstraintValidator<RequirementPriority, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "low", "medium", "high", "critical");
    }
}
