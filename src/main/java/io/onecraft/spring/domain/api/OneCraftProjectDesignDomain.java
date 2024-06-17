package io.onecraft.spring.domain.api;

import io.onecraft.spring.domain.project.model.OneCraftProjectDesignCreationRequest;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface OneCraftProjectDesignDomain {

    /**
     * Design a project based on the given functional requirements.
     *
     * @param projectId             The unique identifier of the project. Must not be blank. Must be a valid UUID.
     * @param designCreationRequest The creation request for the project design.
     * @return The technical design of the project.
     * @throws IllegalArgumentException If the incoming functional requirements are invalid.
     */
    OneCraftProjectTechnicalDesign designProject(@NotBlank Long projectId, @Valid OneCraftProjectDesignCreationRequest designCreationRequest);

    /**
     * Get the technical design of the project.
     *
     * @param designId The unique identifier of the design. Must not be blank. Must be a valid UUID.
     * @return The technical design of the project.
     * @throws IllegalArgumentException If the incoming project or design identifiers are invalid.
     */
    OneCraftProjectTechnicalDesign getDesign(Long designId);

    /**
     * Approve the technical design of the project.
     *
     * @param designId The unique identifier of the design. Must not be blank. Must be a valid UUID.
     * @return The approved technical design of the project.
     */
    OneCraftProjectTechnicalDesign approveDesign(Long designId);
}
