package io.onecraft.spring.adapter.entity.deployment;

import io.onecraft.spring.adapter.entity.SoftwareComponentEntity;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a deployed software component in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "deployed_software_components")
public class DeployedSoftwareComponentEntity implements Comparable<DeployedSoftwareComponentEntity> {

    // Unique identifier for the deployed software component
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deployed_software_component_id_seq")
    @SequenceGenerator(name = "deployed_software_component_id_seq", sequenceName = "deployed_software_component_id_seq", allocationSize = 1)
    private Long id;

    // Deployment node associated with the deployed software component
    @ManyToOne(fetch = FetchType.LAZY)
    private DeploymentNodeEntity deploymentNode;

    // Software component associated with the deployed software component
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "software_component_id")
    private SoftwareComponentEntity component;


    @OneToMany(mappedBy = "deployedSoftwareComponent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ComponentConfigurationEntity> configurations = new TreeSet<>();

    /**
     * Default constructor.
     */
    public DeployedSoftwareComponentEntity() {
    }

    /**
     * Adds a configuration to the deployed software component.
     * @param configuration configuration to be added
     */
    public void addConfiguration(ComponentConfigurationEntity configuration) {
        configurations.add(configuration);
        configuration.setDeployedSoftwareComponent(this);
    }

    /**
     * Removes a configuration from the deployed software component.
     * @param configuration configuration to be removed
     */
    public void removeConfiguration(ComponentConfigurationEntity configuration) {
        configurations.remove(configuration);
        configuration.setDeployedSoftwareComponent(null);
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the deployment node
    public DeploymentNodeEntity getDeploymentNode() {
        return deploymentNode;
    }

    // Setter for the deployment node
    public void setDeploymentNode(DeploymentNodeEntity deploymentNode) {
        this.deploymentNode = deploymentNode;
    }

    // Getter for the software component
    public SoftwareComponentEntity getComponent() {
        return component;
    }

    // Setter for the software component
    public void setComponent(SoftwareComponentEntity component) {
        this.component = component;
    }

    // Getter for the configurations
    public Set<ComponentConfigurationEntity> getConfigurations() {
        return configurations;
    }

    // Setter for the configurations
    public void setConfigurations(Set<ComponentConfigurationEntity> configurations) {
        this.configurations = configurations;
    }

    @Override
    public int compareTo(DeployedSoftwareComponentEntity o) {
        return StringUtils.compare(this.component.getName(), o.component.getName());
    }
}