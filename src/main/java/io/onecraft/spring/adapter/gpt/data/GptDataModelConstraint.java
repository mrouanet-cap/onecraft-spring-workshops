package io.onecraft.spring.adapter.gpt.data;

/**
 * Represents an data model constraint that is imposed on the project.
 *
 * @param description Explanation of the architectural constraint or design decision.
 * @param type        Indicates the category or nature of the constraint (e.g., technology choice, compliance
 *                    requirement).
 * @param rationale   Justification for why the constraint is necessary or beneficial.
 */
public record GptDataModelConstraint(String description, String type, String rationale) {
}
