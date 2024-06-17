package io.onecraft.spring.presentation.model;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO for the creation of a project.
 *
 * @param name the name of the project
 * @version 1.0
 */
public record OneCraftProjectCreationRequestDto(@NotBlank String name) {
}
