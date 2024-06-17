package io.onecraft.spring.adapter.entity.deployment;

import io.onecraft.spring.adapter.entity.SoftwareComponentEntity;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a connection between two components in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "component_connections")
public class ComponentConnectionEntity implements Comparable<ComponentConnectionEntity> {

    // Unique identifier for the component connection
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "component_connection_id_generator")
    @SequenceGenerator(name = "component_connection_id_generator", sequenceName = "component_connection_id_seq", allocationSize = 1)
    private Long id;

    // Source software component of the connection
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_component_id", referencedColumnName = "id")
    private SoftwareComponentEntity source;

    // Target software component of the connection
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_component_id", referencedColumnName = "id")
    private SoftwareComponentEntity target;

    // Description of the connection
    private String description;

    // Protocol used in the connection
    private String protocol;

    // Deployment diagram associated with the connection
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DeploymentDiagramEntity deploymentDiagram;

    /**
     * Default constructor.
     */
    public ComponentConnectionEntity() {
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the source software component
    public SoftwareComponentEntity getSource() {
        return source;
    }

    // Setter for the source software component
    public void setSource(SoftwareComponentEntity source) {
        this.source = source;
    }

    // Getter for the target software component
    public SoftwareComponentEntity getTarget() {
        return target;
    }

    // Setter for the target software component
    public void setTarget(SoftwareComponentEntity target) {
        this.target = target;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Setter for the description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the protocol
    public String getProtocol() {
        return protocol;
    }

    // Setter for the protocol
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    // Getter for the deployment diagram
    public DeploymentDiagramEntity getDeploymentDiagram() {
        return deploymentDiagram;
    }

    // Setter for the deployment diagram
    public void setDeploymentDiagram(DeploymentDiagramEntity deploymentDiagram) {
        this.deploymentDiagram = deploymentDiagram;
    }

    @Override
    public int compareTo(ComponentConnectionEntity o) {
        return StringUtils.compare(protocol, o.protocol);
    }
}