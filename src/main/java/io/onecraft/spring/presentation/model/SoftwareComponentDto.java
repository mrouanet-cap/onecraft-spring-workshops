package io.onecraft.spring.presentation.model;

import jakarta.validation.constraints.NotBlank;

/**
 * Represents a software component that is part of a project.
 *
 * @param id          Unique identifier of the component.
 * @param name        Name of the software component.
 * @param type        Category or classification of the component (e.g., user interface, backend service, database).
 * @param description Explanation or purpose of the component within the software system.
 */
public record SoftwareComponentDto(Long id, @NotBlank String name, @NotBlank String type, @NotBlank String description) {

}
