package io.onecraft.spring.adapter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Details of a OneCraft project.
 */
@Entity
@Table(name = "one_craft_project")
public class OneCraftProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "project_id_generator")
    @SequenceGenerator(name = "project_id_generator", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String status;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.LAZY)
    private OneCraftProjectTechnicalDesignEntity design;

    public OneCraftProjectEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long projectId) {
        this.id = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the technical design for the project.
     *
     * @param design the technical design.
     */
    public void setDesign(OneCraftProjectTechnicalDesignEntity design) {
        design.setProject(this);
        this.design = design;
    }

    public OneCraftProjectTechnicalDesignEntity getDesign() {
        return design;
    }
}
