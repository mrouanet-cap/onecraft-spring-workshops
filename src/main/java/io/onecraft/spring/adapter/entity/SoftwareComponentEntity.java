package io.onecraft.spring.adapter.entity;

import io.onecraft.spring.adapter.entity.architecture.SoftwareComponentInterfaceEntity;
import jakarta.persistence.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a software component in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "software_components")
public class SoftwareComponentEntity implements Comparable<SoftwareComponentEntity> {

    // Unique identifier for the software component
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "component_id_generator")
    @SequenceGenerator(name = "component_id_generator", sequenceName = "component_id_seq", allocationSize = 1)
    private Long id;

    // Name of the software component
    private String name;

    // Type of the software component
    private String type;

    // Description of the software component
    private String description;

    // Technical design entity associated with the software component
    @ManyToOne(fetch = FetchType.LAZY)
    private OneCraftProjectTechnicalDesignEntity design;

    @OneToMany(mappedBy = "component", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SoftwareComponentInterfaceEntity> interfaces = new TreeSet<>();

    /**
     * Default constructor.
     */
    public SoftwareComponentEntity() {
    }

    /**
     * Adds an interface to the software component.
     *
     * @param componentInterface the interface to add
     */
    public void addInterface(SoftwareComponentInterfaceEntity componentInterface) {
        interfaces.add(componentInterface);
        componentInterface.setComponent(this);
    }

    /**
     * Removes an interface from the software component.
     *
     * @param componentInterface the interface to remove
     */
    public void removeInterface(SoftwareComponentInterfaceEntity componentInterface) {
        interfaces.remove(componentInterface);
        componentInterface.setComponent(null);
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

    // Getter for the technical design entity
    public OneCraftProjectTechnicalDesignEntity getDesign() {
        return design;
    }

    // Setter for the technical design entity
    public void setDesign(OneCraftProjectTechnicalDesignEntity design) {
        this.design = design;
    }

    @Override
    public int compareTo(SoftwareComponentEntity o) {
        return Objects.compare(this.id, o.id, Comparator.naturalOrder());
    }
}