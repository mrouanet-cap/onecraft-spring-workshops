package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.DeploymentNodeType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates a deployment node type.
 *
 * @version 1.0
 */
public class DeploymentNodeTypeValidator implements ConstraintValidator<DeploymentNodeType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "Physical", "Virtual", "Container");
    }
}
