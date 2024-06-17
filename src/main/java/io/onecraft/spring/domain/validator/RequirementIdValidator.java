package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.RequirementId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the unique identifier of a requirement.
 *
 * @see RequirementId
 * @version 1.0
 */
public class RequirementIdValidator implements ConstraintValidator<RequirementId, String> {

    // The pattern of the requirement identifier.
    private String pattern;

    @Override
    public void initialize(RequirementId constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotBlank(value) && value.matches(pattern);
    }
}
