package io.onecraft.spring.adapter.entity.architecture;

import io.onecraft.spring.adapter.entity.SoftwareComponentEntity;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents an interface of a software component in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "software_component_interface")
public class SoftwareComponentInterfaceEntity implements Comparable<SoftwareComponentInterfaceEntity> {

    // Unique identifier for the software component interface
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "software_component_interface_id_seq")
    @SequenceGenerator(name = "software_component_interface_id_seq", sequenceName = "software_component_interface_id_seq", allocationSize = 1)
    private Long id;

    // Name of the software component interface
    private String name;

    // Type of the software component interface
    private String type;

    // Description of the software component interface
    private String description;

    // Architecture diagram that the software component interface is part of
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ArchitectureDiagramEntity architectureDiagram;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SoftwareComponentEntity component;

    /**
     * Default constructor.
     */
    public SoftwareComponentInterfaceEntity() {
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the type
    public String getType() {
        return type;
    }

    // Setter for the type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Setter for the description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the architecture diagram
    public ArchitectureDiagramEntity getArchitectureDiagram() {
        return architectureDiagram;
    }

    // Setter for the architecture diagram
    public void setArchitectureDiagram(ArchitectureDiagramEntity architectureDiagram) {
        this.architectureDiagram = architectureDiagram;
    }

    // Getter for the software component
    public SoftwareComponentEntity getComponent() {
        return component;
    }

    // Setter for the software component
    public void setComponent(SoftwareComponentEntity component) {
        this.component = component;
    }

    @Override
    public int compareTo(SoftwareComponentInterfaceEntity o) {
        return StringUtils.compareIgnoreCase(name, o.name);
    }
}