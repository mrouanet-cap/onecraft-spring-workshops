package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.TechnicalDesignStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * This class validates the status of a technical design.
 *
 * @version 1.0
 */
public class TechnicalDesignStatusValidator implements ConstraintValidator<TechnicalDesignStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "Draft", "Final");
    }
}
