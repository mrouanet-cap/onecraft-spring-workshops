package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ArchitectureDiagramStatus;
import io.onecraft.spring.domain.annotation.DeploymentDiagramStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * This class validates the status of the architecture diagram.
 *
 * @see ArchitectureDiagramStatus
 */
public class DeploymentDiagramStatusValidator implements ConstraintValidator<DeploymentDiagramStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase("Draft", "Final", "Deprecated", "Archived", "Deleted");
    }
}
