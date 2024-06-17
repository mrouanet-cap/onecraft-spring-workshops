package io.onecraft.spring.domain.project.model;

import io.onecraft.spring.domain.annotation.ProjectStatus;
import jakarta.validation.constraints.NotBlank;

/**
 * Details of a OneCraft project.
 */
public class OneCraftProject {

    private Long id;

    private @NotBlank String name;

    private @ProjectStatus String status;

    /**
     * The constructor for the project.
     *
     * @param name   the name of the project.
     * @param status the status of the project.
     */
    public OneCraftProject(String name, String status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Checks if the project is designable.
     * @return true if the project is status, false otherwise.
     */
    public boolean isDesignable(){
        return status.equalsIgnoreCase("open");
    }

    /**
     * Checks if the project is closable.
     * @return true if the project is status, false otherwise.
     */
    public boolean isClosable() {
        return "open".equalsIgnoreCase(status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
