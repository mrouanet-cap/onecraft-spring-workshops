package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.FunctionalRequirementCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the category of a functional requirement.
 *
 * @see FunctionalRequirementCategory
 */
public class FunctionalRequirementCategoryValidator implements ConstraintValidator<FunctionalRequirementCategory, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "User Interface", "Data Management", "Reporting",
                "Business Logic", "Integration", "Other");
    }
}
