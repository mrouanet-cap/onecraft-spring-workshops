package io.onecraft.spring.adapter.gpt;

/**
 * Represents a software component that is part of a project.
 *
 * @param name        Name of the software component.
 * @param type        Category or classification of the component (e.g., user interface, backend service, database).
 * @param description Explanation or purpose of the component within the software system.
 */
public record GptSoftwareComponent(String name, String type, String description) {

}
