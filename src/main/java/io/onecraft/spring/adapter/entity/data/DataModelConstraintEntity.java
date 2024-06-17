package io.onecraft.spring.adapter.entity.data;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "data_model_constraint")
public class DataModelConstraintEntity implements Comparable<DataModelConstraintEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_model_constraint_id_seq")
    @SequenceGenerator(name = "data_model_constraint_id_seq", sequenceName = "data_model_constraint_id_seq", allocationSize = 1)
    private Long id;

    private String description;

    private String type;

    private String rationale;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DataModelEntity dataModel;

    /**
     * Default constructor.
     */
    public DataModelConstraintEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public DataModelEntity getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelEntity dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public int compareTo(DataModelConstraintEntity o) {
        return Objects.compare(this.id, o.id, Long::compareTo);
    }
}
