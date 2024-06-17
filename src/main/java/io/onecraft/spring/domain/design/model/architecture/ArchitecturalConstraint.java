package io.onecraft.spring.domain.design.model.architecture;

import io.onecraft.spring.domain.annotation.ArchitectureConstraintType;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents an architectural constraint that is imposed on the project.
 *
 * @param id          Unique identifier of the architectural constraint.
 * @param description Explanation of the architectural constraint or design decision.
 * @param type        Indicates the category or nature of the constraint (e.g., technology choice, compliance requirement).
 * @param rationale   Justification for why the constraint is necessary or beneficial.
 */
public record ArchitecturalConstraint(Long id, @NotBlank String description, @ArchitectureConstraintType String type, @NotBlank String rationale) {
}
