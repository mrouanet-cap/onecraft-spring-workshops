package io.onecraft.spring.adapter.entity.deployment;

import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a node in a deployment model.
 *
 * @version 1.0
 */
@Entity
@Table(name = "deployment_nodes")
public class DeploymentNodeEntity implements Comparable<DeploymentNodeEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deployment_node_seq")
    @SequenceGenerator(name = "deployment_node_seq", sequenceName = "deployment_node_seq", allocationSize = 1)
    private Long id;

    // The name of the node
    private String name;

    // The type of the node
    private String type;

    // The location of the node
    private String location;

    @OneToMany(mappedBy = "node", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NodeResourceEntity> resources = new TreeSet<>();

    @OneToMany(mappedBy = "deploymentNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeployedSoftwareComponentEntity> deployedComponents = new TreeSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private DeploymentDiagramEntity deploymentDiagram;

    public DeploymentNodeEntity() {
    }

    /**
     * Adds a resource to this node.
     *
     * @param resource the resource to add
     */
    public void addResource(NodeResourceEntity resource) {
        resources.add(resource);
        resource.setNode(this);
    }

    /**
     * Removes a resource from this node.
     *
     * @param resource the resource to remove
     */
    public void removeResource(NodeResourceEntity resource) {
        resources.remove(resource);
        resource.setNode(null);
    }

    /**
     * Adds a deployed component to this node.
     *
     * @param component the component to add
     */
    public void addDeployedComponent(DeployedSoftwareComponentEntity component) {
        deployedComponents.add(component);
        component.setDeploymentNode(this);
    }

    /**
     * Removes a deployed component from this node.
     *
     * @param component the component to remove
     */
    public void removeDeployedComponent(DeployedSoftwareComponentEntity component) {
        deployedComponents.remove(component);
        component.setDeploymentNode(null);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<NodeResourceEntity> getResources() {
        return resources;
    }

    public void setResources(Set<NodeResourceEntity> resources) {
        this.resources = resources;
    }

    public Set<DeployedSoftwareComponentEntity> getDeployedComponents() {
        return deployedComponents;
    }

    public void setDeployedComponents(Set<DeployedSoftwareComponentEntity> deployedComponents) {
        this.deployedComponents = deployedComponents;
    }

    public DeploymentDiagramEntity getDeploymentDiagram() {
        return deploymentDiagram;
    }

    public void setDeploymentDiagram(DeploymentDiagramEntity deploymentDiagram) {
        this.deploymentDiagram = deploymentDiagram;
    }

    @Override
    public int compareTo(DeploymentNodeEntity o) {
        return StringUtils.compare(this.name, o.name);
    }
}
