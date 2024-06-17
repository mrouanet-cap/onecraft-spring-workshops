package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ArtifactType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the type of an artifact.
 *
 * @see ArtifactType
 */
public class ArtifactTypeValidator implements ConstraintValidator<ArtifactType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "jar", "war", "ear");
    }
}
