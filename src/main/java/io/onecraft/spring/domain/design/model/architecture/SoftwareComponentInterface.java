package io.onecraft.spring.domain.design.model.architecture;

import io.onecraft.spring.domain.design.model.SoftwareComponent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a software component interface that is part of a project
 *
 * @param id          Unique identifier of the interface.
 * @param component   Software component to which the interface belongs.
 * @param name        Name or identifier of the interface.
 * @param type        Type or protocol of the interface (e.g., REST API, messaging queue).
 * @param description Explanation or purpose of the interface within the software component.
 */
public record SoftwareComponentInterface(Long id, @NotNull SoftwareComponent component, @NotBlank String name,
                                         @NotBlank String type, @NotBlank String description) {
}
