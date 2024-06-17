package io.onecraft.spring.domain.project.model;

import io.onecraft.spring.domain.design.model.requirement.FunctionalRequirement;
import io.onecraft.spring.domain.design.model.requirement.NonFunctionalRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * This class represents the creation request for a project design.
 *
 * @param functionalRequirements list of functional requirements
 * @param nonFunctionalRequirements list of non-functional requirements
 * @version 1.0
 */
public record OneCraftProjectDesignCreationRequest(@NotEmpty List<@Valid FunctionalRequirement> functionalRequirements,
                                                   @NotEmpty List<@Valid NonFunctionalRequirement> nonFunctionalRequirements) {
}
