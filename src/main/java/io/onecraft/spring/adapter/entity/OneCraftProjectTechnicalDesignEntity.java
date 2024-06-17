package io.onecraft.spring.adapter.entity;

import io.onecraft.spring.adapter.entity.architecture.ArchitectureDiagramEntity;
import io.onecraft.spring.adapter.entity.data.DataModelEntity;
import io.onecraft.spring.adapter.entity.deployment.DeploymentDiagramEntity;
import jakarta.persistence.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents the technical design of a OneCraft project in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "one_craft_project_technical_designs")
public class OneCraftProjectTechnicalDesignEntity {

    // Unique identifier for the technical design
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "design_id_generator")
    @SequenceGenerator(name = "design_id_generator", sequenceName = "design_id_seq", allocationSize = 1)
    private Long id;

    // OneCraft project associated with the technical design
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private OneCraftProjectEntity project;

    // Status of the design
    private String status;

    // List of software components in the design
    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SoftwareComponentEntity> components = new TreeSet<>();

    // List of data models in the design
    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataModelEntity> dataModels = new TreeSet<>();

    // List of architecture diagrams in the design
    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArchitectureDiagramEntity> architectureDiagrams = new TreeSet<>();

    // List of deployment diagrams in the design
    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeploymentDiagramEntity> deploymentDiagrams = new TreeSet<>();

    /**
     * Default constructor.
     */
    public OneCraftProjectTechnicalDesignEntity() {
    }

    /**
     * Constructor with design id and status.
     *
     * @param designId     the id of the design
     * @param designStatus the status of the design
     */
    public OneCraftProjectTechnicalDesignEntity(Long designId, String designStatus) {
        this.id = designId;
        this.status = designStatus;
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long designId) {
        this.id = designId;
    }

    // Getter for the design status
    public String getStatus() {
        return status;
    }

    // Setter for the design status
    public void setStatus(String designStatus) {
        this.status = designStatus;
    }

    // Getter for the project
    public OneCraftProjectEntity getProject() {
        return project;
    }

    // Setter for the project
    public void setProject(OneCraftProjectEntity project) {
        this.project = project;
    }

    // Getter for the list of software components
    public Set<SoftwareComponentEntity> getComponents() {
        return components;
    }

    // Setter for the list of software components
    public void setComponents(Set<SoftwareComponentEntity> components) {
        this.components = components;
    }

    // Getter for the list of data models
    public Set<DataModelEntity> getDataModels() {
        return dataModels;
    }

    // Setter for the list of data models
    public void setDataModels(Set<DataModelEntity> dataModels) {
        this.dataModels = dataModels;
    }

    // Getter for the list of architecture diagrams
    public Set<ArchitectureDiagramEntity> getArchitectureDiagrams() {
        return architectureDiagrams;
    }

    // Setter for the list of architecture diagrams
    public void setArchitectureDiagrams(Set<ArchitectureDiagramEntity> architectureDiagrams) {
        this.architectureDiagrams = architectureDiagrams;
    }

    // Getter for the list of deployment diagrams
    public Set<DeploymentDiagramEntity> getDeploymentDiagrams() {
        return deploymentDiagrams;
    }

    // Setter for the list of deployment diagrams
    public void setDeploymentDiagrams(Set<DeploymentDiagramEntity> deploymentDiagrams) {
        this.deploymentDiagrams = deploymentDiagrams;
    }

    /**
     * Add a component to the design.
     *
     * @param component the component to add
     */
    public void addComponent(SoftwareComponentEntity component) {
        component.setDesign(this);
        this.components.add(component);
    }

    /**
     * Remove a component from the design.
     *
     * @param component the component to remove
     */
    public void removeComponent(SoftwareComponentEntity component) {
        component.setDesign(null);
        this.components.remove(component);
    }

    /**
     * Add a data model to the design.
     *
     * @param dataModel the data model to add
     */
    public void addDataModel(DataModelEntity dataModel) {
        dataModel.setDesign(this);
        this.dataModels.add(dataModel);
    }

    /**
     * Remove a data model from the design.
     *
     * @param dataModel the data model to remove
     */
    public void removeDataModel(DataModelEntity dataModel) {
        dataModel.setDesign(null);
        this.dataModels.remove(dataModel);
    }

    /**
     * Add an architecture diagram to the design.
     *
     * @param architectureDiagram the architecture diagram to add
     */
    public void addArchitectureDiagram(ArchitectureDiagramEntity architectureDiagram) {
        architectureDiagram.setDesign(this);
        this.architectureDiagrams.add(architectureDiagram);
    }

    /**
     * Remove an architecture diagram from the design.
     *
     * @param architectureDiagram the architecture diagram to remove
     */
    public void removeArchitectureDiagram(ArchitectureDiagramEntity architectureDiagram) {
        architectureDiagram.setDesign(null);
        this.architectureDiagrams.remove(architectureDiagram);
    }

    /**
     * Add a deployment diagram to the design.
     *
     * @param deploymentDiagram the deployment diagram to add
     */
    public void addDeploymentDiagram(DeploymentDiagramEntity deploymentDiagram) {
        deploymentDiagram.setDesign(this);
        this.deploymentDiagrams.add(deploymentDiagram);
    }

    /**
     * Remove a deployment diagram from the design.
     *
     * @param deploymentDiagram the deployment diagram to remove
     */
    public void removeDeploymentDiagram(DeploymentDiagramEntity deploymentDiagram) {
        deploymentDiagram.setDesign(null);
        this.deploymentDiagrams.remove(deploymentDiagram);
    }

}