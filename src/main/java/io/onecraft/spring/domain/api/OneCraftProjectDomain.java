package io.onecraft.spring.domain.api;

import io.onecraft.spring.domain.project.model.OneCraftProject;
import io.onecraft.spring.domain.project.model.OneCraftProjectCreationRequest;
import jakarta.validation.Valid;

/**
 * The domain interface for OneCraft projects management.
 *
 * @version 1.0
 */
public interface OneCraftProjectDomain {

    /**
     * Create a project based on the given creation request.
     *
     * @param creationRequest The creation request for the project.
     * @return The created project.
     * @throws IllegalArgumentException If the incoming creation request is invalid.
     */
    OneCraftProject createProject(@Valid OneCraftProjectCreationRequest creationRequest);

    /**
     * Get the project based on the given project identifier.
     *
     * @param projectId The unique identifier of the project. Must not be blank. Must be a valid UUID.
     * @return The project based on the given project identifier.
     */
    OneCraftProject getProject(Long projectId);

    /**
     * Close the project based on the given project identifier.
     *
     * @param projectId The unique identifier of the project.
     * @return The closed project based on the given project identifier.
     */
    OneCraftProject closeProject(Long projectId);
}
