package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ProjectStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * The annotated element must be a valid project status.
 *
 * @version 1.0
 * @see ProjectStatusValidator
 */
public class ProjectStatusValidator implements ConstraintValidator<ProjectStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "open", "closed", "in progress", "completed");
    }
}
