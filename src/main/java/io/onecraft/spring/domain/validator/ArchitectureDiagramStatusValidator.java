package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ArchitectureDiagramStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * This class validates the status of the architecture diagram.
 *
 * @see ArchitectureDiagramStatus
 */
public class ArchitectureDiagramStatusValidator implements ConstraintValidator<ArchitectureDiagramStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase("Draft", "Final", "Deprecated", "Archived", "Deleted");
    }
}
