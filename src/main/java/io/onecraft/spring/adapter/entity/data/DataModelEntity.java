package io.onecraft.spring.adapter.entity.data;

import io.onecraft.spring.adapter.entity.OneCraftProjectTechnicalDesignEntity;
import jakarta.persistence.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * The entity class for the data model.
 *
 * @version 1.0
 */
@Entity
@Table(name = "data_model")
public class DataModelEntity implements Comparable<DataModelEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_model_id_seq")
    @SequenceGenerator(name = "data_model_id_seq", sequenceName = "data_model_id_seq", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "dataModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataModelEntityEntity> entities = new TreeSet<>();

    @OneToMany(mappedBy = "dataModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataModelRelationshipEntity> relationships = new TreeSet<>();

    @OneToMany(mappedBy = "dataModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataModelConstraintEntity> constraints = new TreeSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OneCraftProjectTechnicalDesignEntity design;

    /**
     * Default constructor.
     */
    public DataModelEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DataModelEntityEntity> getEntities() {
        return entities;
    }

    public void setEntities(Set<DataModelEntityEntity> entities) {
        this.entities = entities;
    }

    public Set<DataModelRelationshipEntity> getRelationships() {
        return relationships;
    }

    public void setRelationships(Set<DataModelRelationshipEntity> relationships) {
        this.relationships = relationships;
    }

    public Set<DataModelConstraintEntity> getConstraints() {
        return constraints;
    }

    public void setConstraints(Set<DataModelConstraintEntity> constraints) {
        this.constraints = constraints;
    }

    public OneCraftProjectTechnicalDesignEntity getDesign() {
        return design;
    }

    public void setDesign(OneCraftProjectTechnicalDesignEntity design) {
        this.design = design;
    }

    /**
     * Add an entity to the data model.
     *
     * @param entity The entity to add.
     */
    public void addEntity(DataModelEntityEntity entity) {
        entities.add(entity);
        entity.setDataModel(this);
    }

    /**
     * Remove an entity from the data model.
     *
     * @param entity The entity to remove.
     */
    public void removeEntity(DataModelEntityEntity entity) {
        entities.remove(entity);
        entity.setDataModel(null);
    }

    /**
     * Add a relationship to the data model.
     *
     * @param relationship The relationship to add.
     */
    public void addRelationship(DataModelRelationshipEntity relationship) {
        relationships.add(relationship);
        relationship.setDataModel(this);
    }

    /**
     * Remove a relationship from the data model.
     *
     * @param relationship The relationship to remove.
     */
    public void removeRelationship(DataModelRelationshipEntity relationship) {
        relationships.remove(relationship);
        relationship.setDataModel(null);
    }

    @Override
    public int compareTo(DataModelEntity o) {
        return Objects.compare(this.id, o.id, Comparator.naturalOrder());
    }
}
