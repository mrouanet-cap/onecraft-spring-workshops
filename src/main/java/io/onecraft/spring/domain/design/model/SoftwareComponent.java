package io.onecraft.spring.domain.design.model;

import jakarta.validation.constraints.NotBlank;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a software component that is part of a project.
 *
 * @param id          Unique identifier of the component.
 * @param name        Name of the software component.
 * @param type        Category or classification of the component (e.g., user interface, backend service, database).
 * @param description Explanation or purpose of the component within the software system.
 */
public record SoftwareComponent(Long id, @NotBlank String name, @NotBlank String type, @NotBlank String description) implements Comparable<SoftwareComponent> {

    @Override
    public int compareTo(SoftwareComponent other) {
        return StringUtils.compare(name, other.name);
    }

}
