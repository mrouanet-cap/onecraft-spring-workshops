package io.onecraft.spring.adapter.entity.deployment;

import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a resource of a deployment node in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "node_resources")
public class NodeResourceEntity implements Comparable<NodeResourceEntity> {

    // Unique identifier for the node resource
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "node_resource_id_seq")
    @SequenceGenerator(name = "node_resource_id_seq", sequenceName = "node_resource_id_seq", allocationSize = 1)
    private Long id;

    // Type of the node resource
    private String type;

    // Capacity of the node resource
    private String capacity;

    // Deployment node associated with the node resource
    @ManyToOne(fetch = FetchType.LAZY)
    private DeploymentNodeEntity node;

    /**
     * Default constructor.
     */
    public NodeResourceEntity() {
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the type
    public String getType() {
        return type;
    }

    // Setter for the type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for the capacity
    public String getCapacity() {
        return capacity;
    }

    // Setter for the capacity
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    // Getter for the deployment node
    public DeploymentNodeEntity getNode() {
        return node;
    }

    // Setter for the deployment node
    public void setNode(DeploymentNodeEntity node) {
        this.node = node;
    }

    @Override
    public int compareTo(NodeResourceEntity o) {
        return StringUtils.compare(type, o.type);
    }
}