package io.onecraft.spring.adapter.entity.architecture;

import jakarta.persistence.*;

/**
 * Represents the content of a data flow in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "data_flow_contents")
public class DataFlowContentEntity {

    // Unique identifier for the data flow content
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_flow_content_id_generator")
    @SequenceGenerator(name = "data_flow_content_id_generator", sequenceName = "data_flow_content_id_seq", allocationSize = 1)
    private Long id;

    // Type of the data in the data flow content
    private String dataType;

    // Description of the data flow content
    private String description;

    // Data flow entity associated with the data flow content
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private DataFlowEntity dataFlow;

    /**
     * Default constructor.
     */
    public DataFlowContentEntity() {
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the data type
    public String getDataType() {
        return dataType;
    }

    // Setter for the data type
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Setter for the description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the data flow
    public DataFlowEntity getDataFlow() {
        return dataFlow;
    }

    // Setter for the data flow
    public void setDataFlow(DataFlowEntity dataFlow) {
        this.dataFlow = dataFlow;
    }
}