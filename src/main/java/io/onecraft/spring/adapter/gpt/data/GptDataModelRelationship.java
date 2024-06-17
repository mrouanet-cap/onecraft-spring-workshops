package io.onecraft.spring.adapter.gpt.data;

/**
 * Represents a relationship between two entities in the data model.
 *
 * @param name        Name of the relationship, indicating how entities are connected.
 * @param type        Type of relationship (e.g., one-to-one, one-to-many, many-to-many).
 * @param description Explanation or additional details about the relationship.
 * @param sourceName  Name of the source entity.
 * @param targetName  Name of the target entity.
 */
public record GptDataModelRelationship(String name, String type, String description, String sourceName, String targetName) {
}
