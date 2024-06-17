package io.onecraft.spring.adapter.entity.deployment;

import io.onecraft.spring.adapter.entity.OneCraftProjectTechnicalDesignEntity;
import io.onecraft.spring.adapter.support.StringListConverter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Represents a deployment diagram.
 */
@Entity
@Table(name = "deployment_diagrams")
public class DeploymentDiagramEntity implements Comparable<DeploymentDiagramEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deployment_diagrams_id_seq")
    @SequenceGenerator(name = "deployment_diagrams_id_seq", sequenceName = "deployment_diagrams_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    private String format;
    private Integer version;
    private String author;
    private LocalDate createdDate;

    @Convert(converter = StringListConverter.class)
    private List<String> comments;

    @Convert(converter = StringListConverter.class)
    private List<String> tags;

    private String status;
    private LocalDate updatedDate;

    @OneToMany(mappedBy = "deploymentDiagram", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ComponentConnectionEntity> connections = new TreeSet<>();

    @OneToMany(mappedBy = "deploymentDiagram", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeploymentNodeEntity> nodes = new TreeSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private OneCraftProjectTechnicalDesignEntity design;

    /**
     * Default constructor.
     */
    public DeploymentDiagramEntity() {
    }

    /**
     * Adds a connection to the deployment diagram.
     *
     * @param connection the connection to add
     */
    public void addConnection(ComponentConnectionEntity connection) {
        connections.add(connection);
        connection.setDeploymentDiagram(this);
    }

    /**
     * Removes a connection from the deployment diagram.
     *
     * @param connection the connection to remove
     */
    public void removeConnection(ComponentConnectionEntity connection) {
        connections.remove(connection);
        connection.setDeploymentDiagram(null);
    }

    /**
     * Adds a node to the deployment diagram.
     *
     * @param node the node to add
     */
    public void addNode(DeploymentNodeEntity node) {
        nodes.add(node);
        node.setDeploymentDiagram(this);
    }

    /**
     * Removes a node from the deployment diagram.
     *
     * @param node the node to remove
     */
    public void removeNode(DeploymentNodeEntity node) {
        nodes.remove(node);
        node.setDeploymentDiagram(null);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Set<ComponentConnectionEntity> getConnections() {
        return connections;
    }

    public void setConnections(Set<ComponentConnectionEntity> connections) {
        this.connections = connections;
    }

    public Set<DeploymentNodeEntity> getNodes() {
        return nodes;
    }

    public void setNodes(Set<DeploymentNodeEntity> nodes) {
        this.nodes = nodes;
    }

    public OneCraftProjectTechnicalDesignEntity getDesign() {
        return design;
    }

    public void setDesign(OneCraftProjectTechnicalDesignEntity design) {
        this.design = design;
    }

    @Override
    public int compareTo(DeploymentDiagramEntity o) {
        return Objects.compare(this.id, o.id, Comparator.naturalOrder());
    }
}
