package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.DeploymentDiagramFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validate the format of the deployment diagram
 *
 * @see DeploymentDiagramFormat
 */
public class DeploymentDiagramFormatValidator implements ConstraintValidator<DeploymentDiagramFormat, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "png", "jpg", "jpeg", "svg", "pdf", "gif");
    }
}
