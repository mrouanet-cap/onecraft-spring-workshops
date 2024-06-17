package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.NonFunctionalRequirementCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class NonFunctionalRequirementCategoryValidator implements ConstraintValidator<NonFunctionalRequirementCategory, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "performance", "security", "usability", "reliability",
                "compatibility", "maintainability", "portability");
    }
}
