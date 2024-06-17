package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ArchitectureDiagramFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the format of the architecture diagram.
 *
 * @see ArchitectureDiagramFormat
 */
public class ArchitectureDiagramFormatValidator implements ConstraintValidator<ArchitectureDiagramFormat, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "png", "jpg", "jpeg", "svg", "pdf", "gif");
    }
}
