package io.onecraft.spring.domain.design.model.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

/**
 * Represents an entity of a data model.
 *
 * @param id          Unique identifier of the entity.
 * @param name        Name of the entity representing a distinct object or concept in the data model.
 * @param description Description of the entity.
 * @param attributes  Characteristics or properties of the entity.
 */
public record DataModelEntity(Long id, @NotBlank String name, @NotBlank String description,
                              Set<@Valid DataModelEntityAttribute> attributes) {
}
