package io.onecraft.spring.adapter.entity.architecture;

import jakarta.persistence.*;

import java.util.Comparator;
import java.util.Objects;

/**
 * Represents an architectural constraint in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "architectural_constraints")
public class ArchitecturalConstraintEntity implements Comparable<ArchitecturalConstraintEntity> {

    // Unique identifier for the architectural constraint
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "architectural_constraint_id_generator")
    @SequenceGenerator(name = "architectural_constraint_id_generator", sequenceName = "architectural_constraint_id_seq", allocationSize = 1)
    private Long id;

    // Description of the architectural constraint
    private String description;

    // Type of the architectural constraint
    private String type;

    // Rationale behind the architectural constraint
    private String rationale;

    // Architecture diagram entity associated with the architectural constraint
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ArchitectureDiagramEntity architectureDiagram;

    /**
     * Default constructor.
     */
    public ArchitecturalConstraintEntity() {
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
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

    // Getter for the rationale
    public String getRationale() {
        return rationale;
    }

    // Setter for the rationale
    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    // Getter for the architecture diagram entity
    public ArchitectureDiagramEntity getArchitectureDiagram() {
        return architectureDiagram;
    }

    // Setter for the architecture diagram entity
    public void setArchitectureDiagram(ArchitectureDiagramEntity architectureDiagram) {
        this.architectureDiagram = architectureDiagram;
    }

    @Override
    public int compareTo(ArchitecturalConstraintEntity o) {
        return Objects.compare(this.id, o.id, Comparator.naturalOrder());
    }
}