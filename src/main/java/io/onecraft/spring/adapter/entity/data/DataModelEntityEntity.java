package io.onecraft.spring.adapter.entity.data;

import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * This class represents the entity of a data model.
 *
 * @version 1.0
 */
@Entity
@Table(name = "data_model_entity")
public class DataModelEntityEntity implements Comparable<DataModelEntityEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_model_entity_id_seq")
    @SequenceGenerator(name = "data_model_entity_id_seq", sequenceName = "data_model_entity_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataModelEntityAttributeEntity> attributes = new TreeSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private DataModelEntity dataModel;

    /**
     * Default constructor.
     */
    public DataModelEntityEntity() {
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

    public Set<DataModelEntityAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<DataModelEntityAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public DataModelEntity getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelEntity dataModel) {
        this.dataModel = dataModel;
    }

    /**
     * Add an attribute to the entity.
     * @param attribute the attribute to add
     */
    public void addAttribute(DataModelEntityAttributeEntity attribute) {
        attribute.setEntity(this);
        this.attributes.add(attribute);
    }

    /**
     * Remove an attribute from the entity.
     * @param attribute the attribute to remove
     */
    public void removeAttribute(DataModelEntityAttributeEntity attribute) {
        attribute.setEntity(null);
        this.attributes.remove(attribute);
    }

    @Override
    public int compareTo(DataModelEntityEntity o) {
        return StringUtils.compare(this.name, o.name);
    }
}
