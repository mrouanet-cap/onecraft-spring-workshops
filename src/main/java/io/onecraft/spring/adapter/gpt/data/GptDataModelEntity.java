package io.onecraft.spring.adapter.gpt.data;

import java.util.Set;

/**
 * Represents an entity of a data model.
 *
 * @param name        Name of the entity representing a distinct object or concept in the data model.
 * @param description Description of the entity.
 * @param attributes  Characteristics or properties of the entity.
 */
public record GptDataModelEntity(String name, String description, Set<GptDataModelEntityAttribute> attributes) {
}
