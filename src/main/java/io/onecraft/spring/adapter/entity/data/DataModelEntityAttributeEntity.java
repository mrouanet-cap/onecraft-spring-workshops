package io.onecraft.spring.adapter.entity.data;

import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.Objects;

/**
 * This class represents the entity of a data model attribute.
 *
 * @version 1.0
 */
@Entity
@Table(name = "data_model_entity_attribute")
public class DataModelEntityAttributeEntity implements Comparable<DataModelEntityAttributeEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_model_entity_attribute_id_seq")
    @SequenceGenerator(name = "data_model_entity_attribute_id_seq", sequenceName = "data_model_entity_attribute_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String type;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DataModelEntityEntity entity;

    /**
     * Default constructor.
     */
    public DataModelEntityAttributeEntity() {
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

    public DataModelEntityEntity getEntity() {
        return entity;
    }

    public void setEntity(DataModelEntityEntity entity) {
        this.entity = entity;
    }

    @Override
    public int compareTo(DataModelEntityAttributeEntity o) {
        return StringUtils.compare(this.name, o.name);
    }
}
