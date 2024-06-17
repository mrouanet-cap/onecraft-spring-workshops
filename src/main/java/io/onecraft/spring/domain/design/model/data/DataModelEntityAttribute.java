package io.onecraft.spring.domain.design.model.data;

import io.onecraft.spring.domain.annotation.DataType;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents an attribute of an entity in a data model.
 *
 * @param id          Unique identifier of the attribute.
 * @param name        Name of the attribute representing a characteristic or property of an entity.
 * @param type        Data type of the attribute (e.g., string, integer, date).
 * @param description Explanation or additional details about the attribute.
 */
public record DataModelEntityAttribute(Long id, @NotBlank String name, @DataType String type, @NotBlank String description) {
}
