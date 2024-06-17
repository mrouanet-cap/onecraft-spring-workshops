package io.onecraft.spring.domain.spi;

import io.onecraft.spring.domain.project.model.OneCraftProject;

import java.util.Set;

/**
 * The data access object for the OneCraft project.
 *
 * @version 1.0
 */
public interface OneCraftProjectDao {

    /**
     * Saves the project to the data store.
     *
     * @param oneCraftProject the project to save.
     * @return the saved project.
     */
    OneCraftProject saveProject(OneCraftProject oneCraftProject);

    /**
     * Finds a project by the project id.
     *
     * @param projectId the project id.
     * @return the project.
     */
    OneCraftProject findProjectById(Long projectId);

    /**
     * Finds all projects.
     *
     * @param page the page number.
     * @param size the page size.
     * @return the corresponding projects.
     */
    Set<OneCraftProject> findProjects(int page, int size);

    Set<OneCraftProject> findProjectsOrderByName(int page, int size);
}
