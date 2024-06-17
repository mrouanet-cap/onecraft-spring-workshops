package io.onecraft.spring.presentation.model.data;

import io.onecraft.spring.domain.annotation.EntityRelationshipType;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a relationship between two entities in the data model.
 *
 * @param id          Unique identifier for the relationship.
 * @param name        Name of the relationship, indicating how entities are connected.
 * @param type        Type of relationship (e.g., one-to-one, one-to-many, many-to-many).
 * @param description Explanation or additional details about the relationship.
 */
public record DataModelRelationshipDto(Long id, @NotBlank String name,
                                       @EntityRelationshipType String type, @NotBlank String description, DataModelEntityDto sourceEntity, DataModelEntityDto targetEntity) {
}
