package io.onecraft.spring.domain.design.model.data;

import io.onecraft.spring.domain.annotation.DataModelConstraintType;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents an data model constraint that is imposed on the project.
 *
 * @param id          Unique identifier for the constraint.
 * @param description Explanation of the architectural constraint or design decision.
 * @param type        Indicates the category or nature of the constraint (e.g., technology choice, compliance
 *                    requirement).
 * @param rationale   Justification for why the constraint is necessary or beneficial.
 */
public record DataModelConstraint(Long id, @NotBlank String description,
                                  @DataModelConstraintType String type, @NotBlank String rationale) {
}
