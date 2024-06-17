package io.onecraft.spring.adapter.entity.data;

import jakarta.persistence.*;

import java.util.Comparator;
import java.util.Objects;

/**
 * This class represents the relationship between data models.
 *
 * @version 1.0
 */
@Entity
@Table(name = "data_model_relationship")
public class DataModelRelationshipEntity implements Comparable<DataModelRelationshipEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_model_relationship_id_seq")
    @SequenceGenerator(name = "data_model_relationship_id_seq", sequenceName = "data_model_relationship_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String type;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_entity_id")
    private DataModelEntityEntity sourceEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_entity_id")
    private DataModelEntityEntity targetEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DataModelEntity dataModel;

    public DataModelRelationshipEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataModelEntity getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelEntity dataModel) {
        this.dataModel = dataModel;
    }

    public DataModelEntityEntity getSourceEntity() {
        return sourceEntity;
    }

    public void setSourceEntity(DataModelEntityEntity sourceEntity) {
        this.sourceEntity = sourceEntity;
    }

    public DataModelEntityEntity getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(DataModelEntityEntity targetEntity) {
        this.targetEntity = targetEntity;
    }

    @Override
    public int compareTo(DataModelRelationshipEntity o) {
        return Objects.compare(this.id, o.id, Comparator.naturalOrder());
    }
}
