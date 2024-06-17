package io.onecraft.spring.adapter.gpt.architecture;

/**
 * Represents a software component interface that is part of a project
 *
 * @param componentName Name of the software component.
 * @param name          Name or identifier of the interface.
 * @param type          Type or protocol of the interface (e.g., REST API, messaging queue).
 * @param description   Explanation or purpose of the interface within the software component.
 */
public record GptSoftwareComponentInterface(String componentName, String name, String type, String description) {
}
