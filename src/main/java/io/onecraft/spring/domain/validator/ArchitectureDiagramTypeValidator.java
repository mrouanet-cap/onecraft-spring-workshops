package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ArchitectureDiagramType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the architecture diagram type.
 *
 * @see ArchitectureDiagramType
 */
public class ArchitectureDiagramTypeValidator implements ConstraintValidator<ArchitectureDiagramType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "C4", "UML", "ERD", "Flowchart", "Other");
    }
}
