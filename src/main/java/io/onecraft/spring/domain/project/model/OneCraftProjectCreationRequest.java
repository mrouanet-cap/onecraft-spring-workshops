package io.onecraft.spring.domain.project.model;

/**
 * The request to create a project.
 *
 * @param name the name of the project
 */
public record OneCraftProjectCreationRequest(String name) {
}
