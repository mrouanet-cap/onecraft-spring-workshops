package io.onecraft.spring.presentation.model;

import io.onecraft.spring.domain.annotation.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * The presentation model for the OneCraft project.
 *
 * @param id   the unique identifier of the project.
 * @param name the name of the project.
 * @version 1.0
 */
public record OneCraftProjectDto(@Positive Long id, @NotBlank String name, @ProjectStatus String status) {
}
