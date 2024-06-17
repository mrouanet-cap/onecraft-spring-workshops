package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.NodeResourceType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates a node resource type.
 *
 * @version 1.0
 * @see NodeResourceTypeValidator
 */
public class NodeResourceTypeValidator implements ConstraintValidator<NodeResourceType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "CPU", "RAM", "Storage");
    }
}
