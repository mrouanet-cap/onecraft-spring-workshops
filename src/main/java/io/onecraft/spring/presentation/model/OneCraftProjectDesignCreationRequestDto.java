package io.onecraft.spring.presentation.model;

import io.onecraft.spring.presentation.model.requirement.FunctionalRequirementDto;
import io.onecraft.spring.presentation.model.requirement.NonFunctionalRequirementDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * This class represents the request to create a project design.
 *
 * @param functionalRequirements    list of functional requirements
 * @param nonFunctionalRequirements list of non-functional requirements
 * @version 1.0
 */
public record OneCraftProjectDesignCreationRequestDto(
        @NotEmpty List<@Valid FunctionalRequirementDto> functionalRequirements,
        @NotEmpty List<@Valid NonFunctionalRequirementDto> nonFunctionalRequirements) {
}
