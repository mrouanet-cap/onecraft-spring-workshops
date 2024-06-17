package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.RequirementStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the status of a requirement.
 *
 * @see RequirementStatus
 */
public class RequirementStatusValidator implements ConstraintValidator<RequirementStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "Draft", "Proposed", "Under Review", "Approved", "Rejected",
                "In Progress", "Implemented", "Closed", "Deferred", "Reopened");
    }
}
