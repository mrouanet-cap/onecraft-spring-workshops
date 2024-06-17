package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.EntityRelationshipType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the entity relationship type.
 *
 * @see EntityRelationshipType
 */
public class EntityRelationshipTypeValidator implements ConstraintValidator<EntityRelationshipType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "one-to-one", "one-to-many", "many-to-one", "many-to-many");
    }
}
