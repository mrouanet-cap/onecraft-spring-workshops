package io.onecraft.spring.adapter.entity.architecture;

import io.onecraft.spring.adapter.entity.OneCraftProjectTechnicalDesignEntity;
import io.onecraft.spring.adapter.support.StringListConverter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Represents an architecture diagram in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "architecture_diagrams")
public class ArchitectureDiagramEntity implements Comparable<ArchitectureDiagramEntity> {

    // Unique identifier for the architecture diagram
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "architecture_diagrams_id_seq")
    @SequenceGenerator(name = "architecture_diagrams_id_seq", sequenceName = "architecture_diagrams_id_seq", allocationSize = 1)
    private Long id;

    // Name of the architecture diagram
    private String name;

    // Description of the architecture diagram
    private String description;

    // Type of the architecture diagram
    private String type;

    // Format of the architecture diagram
    private String format;

    // Version of the architecture diagram
    private Integer version;

    // Author of the architecture diagram
    private String author;

    // Creation date of the architecture diagram
    private LocalDate createdDate;

    // List of comments associated with the architecture diagram
    @Convert(converter = StringListConverter.class)
    private List<String> comments;

    // List of tags associated with the architecture diagram
    @Convert(converter = StringListConverter.class)
    private List<String> tags;

    // Status of the architecture diagram
    private String status;

    // Last updated date of the architecture diagram
    private LocalDate updatedDate;

    // List of data flows associated with the architecture diagram
    @OneToMany(mappedBy = "architectureDiagram", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataFlowEntity> dataFlows = new TreeSet<>();

    // List of architectural constraints associated with the architecture diagram
    @OneToMany(mappedBy = "architectureDiagram", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArchitecturalConstraintEntity> constraints = new TreeSet<>();

    // List of software component interfaces associated with the architecture diagram
    @OneToMany(mappedBy = "architectureDiagram", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SoftwareComponentInterfaceEntity> interfaces = new TreeSet<>();

    // Technical design entity associated with the architecture diagram
    @ManyToOne(fetch = FetchType.LAZY)
    private OneCraftProjectTechnicalDesignEntity design;

    /**
     * Default constructor.
     */
    public ArchitectureDiagramEntity() {
    }

    /**
     * Adds the specified data flow to the list of data flows.
     *
     * @param dataFlow the data flow to add
     */
    public void addDataFlow(DataFlowEntity dataFlow) {
        dataFlows.add(dataFlow);
        dataFlow.setArchitectureDiagram(this);
    }

    /**
     * Removes the specified data flow from the list of data flows.
     *
     * @param dataFlow the data flow to remove
     */
    public void removeDataFlow(DataFlowEntity dataFlow) {
        dataFlows.remove(dataFlow);
        dataFlow.setArchitectureDiagram(null);
    }

    /**
     * Adds the specified architectural constraint to the list of architectural constraints.
     *
     * @param constraint the architectural constraint to add
     */
    public void addConstraint(ArchitecturalConstraintEntity constraint) {
        constraints.add(constraint);
        constraint.setArchitectureDiagram(this);
    }

    /**
     * Removes the specified architectural constraint from the list of architectural constraints.
     *
     * @param constraint the architectural constraint to remove
     */
    public void removeConstraint(ArchitecturalConstraintEntity constraint) {
        constraints.remove(constraint);
        constraint.setArchitectureDiagram(null);
    }

    /**
     * Adds the specified software component interface to the list of software component interfaces.
     *
     * @param softwareComponentInterface the software component interface to add
     */
    public void addInterface(SoftwareComponentInterfaceEntity softwareComponentInterface) {
        interfaces.add(softwareComponentInterface);
        softwareComponentInterface.setArchitectureDiagram(this);
    }

    /**
     * Removes the specified software component interface from the list of software component interfaces.
     *
     * @param softwareComponentInterface the software component interface to remove
     */
    public void removeInterface(SoftwareComponentInterfaceEntity softwareComponentInterface) {
        interfaces.remove(softwareComponentInterface);
        softwareComponentInterface.setArchitectureDiagram(null);
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the list of data flows
    public Set<DataFlowEntity> getDataFlows() {
        return dataFlows;
    }

    // Setter for the list of data flows
    public void setDataFlows(Set<DataFlowEntity> dataFlows) {
        this.dataFlows = dataFlows;
    }

    // Getter for the list of architectural constraints
    public Set<ArchitecturalConstraintEntity> getConstraints() {
        return constraints;
    }

    // Setter for the list of architectural constraints
    public void setConstraints(Set<ArchitecturalConstraintEntity> constraints) {
        this.constraints = constraints;
    }

    // Getter for the list of software component interfaces
    public Set<SoftwareComponentInterfaceEntity> getInterfaces() {
        return interfaces;
    }

    // Setter for the list of software component interfaces
    public void setInterfaces(Set<SoftwareComponentInterfaceEntity> interfaces) {
        this.interfaces = interfaces;
    }

    // Getter for the technical design entity
    public OneCraftProjectTechnicalDesignEntity getDesign() {
        return design;
    }

    // Setter for the technical design entity
    public void setDesign(OneCraftProjectTechnicalDesignEntity design) {
        this.design = design;
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Setter for the description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the type
    public String getType() {
        return type;
    }

    // Setter for the type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for the format
    public String getFormat() {
        return format;
    }

    // Setter for the format
    public void setFormat(String format) {
        this.format = format;
    }

    // Getter for the version
    public Integer getVersion() {
        return version;
    }

    // Setter for the version
    public void setVersion(Integer version) {
        this.version = version;
    }

    // Getter for the author
    public String getAuthor() {
        return author;
    }

    // Setter for the author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for the creation date
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    // Setter for the creation date
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    // Getter for the list of comments
    public List<String> getComments() {
        return comments;
    }

    // Setter for the list of comments
    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    // Getter for the list of tags
    public List<String> getTags() {
        return tags;
    }

    // Setter for the list of tags
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    // Getter for the status
    public String getStatus() {
        return status;
    }

    // Setter for the status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for the last updated date
    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    // Setter for the last updated date
    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public int compareTo(ArchitectureDiagramEntity o) {
        return Objects.compare(this.id, o.id, Comparator.naturalOrder());
    }
}