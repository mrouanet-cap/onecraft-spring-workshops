package io.onecraft.spring.adapter.gpt.data;

/**
 * Represents an attribute of an entity in a data model.
 *
 * @param name        Name of the attribute representing a characteristic or property of an entity.
 * @param type        Data type of the attribute (e.g., string, integer, date).
 * @param description Explanation or additional details about the attribute.
 */
public record GptDataModelEntityAttribute(String name, String type, String description) {
}
