package io.onecraft.spring.domain.design.model;

import java.util.Set;
import java.util.TreeSet;

import io.onecraft.spring.domain.annotation.TechnicalDesignStatus;
import io.onecraft.spring.domain.design.model.architecture.ArchitectureDiagram;
import io.onecraft.spring.domain.design.model.data.DataModel;
import io.onecraft.spring.domain.design.model.deployment.DeploymentDiagram;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This class represents the technical design of a project.
 *
 * @version 1.0
 */
/**
 * Represents the technical design of a OneCraft project.
 * This class contains information about the project's ID, status, description, data models, architecture diagrams,
 * deployment diagrams, and software components.
 */
public class OneCraftProjectTechnicalDesign {
    private Long id;
    @NotNull private Long projectId;
    @TechnicalDesignStatus
    private String status;
    private Set<@Valid DataModel> dataModels = new TreeSet<>();
    private Set<@Valid ArchitectureDiagram> architectureDiagrams = new TreeSet<>();
    private Set<@Valid DeploymentDiagram> deploymentDiagrams = new TreeSet<>();
    private Set<@Valid SoftwareComponent> components = new TreeSet<>();

    /**
     * Default constructor.
     */
    public OneCraftProjectTechnicalDesign() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<DataModel> getDataModels() {
        return dataModels;
    }

    public void setDataModels(Set<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    public Set<ArchitectureDiagram> getArchitectureDiagrams() {
        return architectureDiagrams;
    }

    public void setArchitectureDiagrams(Set<ArchitectureDiagram> architectureDiagrams) {
        this.architectureDiagrams = architectureDiagrams;
    }

    public Set<DeploymentDiagram> getDeploymentDiagrams() {
        return deploymentDiagrams;
    }

    public void setDeploymentDiagrams(Set<DeploymentDiagram> deploymentDiagrams) {
        this.deploymentDiagrams = deploymentDiagrams;
    }

    public Set<SoftwareComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<SoftwareComponent> components) {
        this.components = components;
    }

    /**
     * Checks if the technical design is approvable.
     *
     * @return true if the technical design is approvable, false otherwise
     */
    public boolean isApprovable(){
        return "pending".equals(status);}
}
