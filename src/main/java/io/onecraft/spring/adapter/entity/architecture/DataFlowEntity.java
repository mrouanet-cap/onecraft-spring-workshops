package io.onecraft.spring.adapter.entity.architecture;

import io.onecraft.spring.adapter.entity.SoftwareComponentEntity;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a data flow in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "data_flows")
public class DataFlowEntity implements Comparable<DataFlowEntity> {

    // Unique identifier for the data flow
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_flows_id_seq")
    @SequenceGenerator(name = "data_flows_id_seq", sequenceName = "data_flows_id_seq", allocationSize = 1)
    private Long id;

    // Source software component of the data flow
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_component_id")
    private SoftwareComponentEntity sourceComponent;

    // Destination software component of the data flow
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_component_id")
    private SoftwareComponentEntity destinationComponent;

    // Type of the data flow
    private String type;

    // Content of the data flow
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dataFlow")
    private DataFlowContentEntity content;

    // Architecture diagram associated with the data flow
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ArchitectureDiagramEntity architectureDiagram;

    /**
     * Default constructor.
     */
    public DataFlowEntity() {
    }

    // Getter for the id
    public Long getId() {
        return id;
    }

    // Setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the source software component
    public SoftwareComponentEntity getSourceComponent() {
        return sourceComponent;
    }

    // Setter for the source software component
    public void setSourceComponent(SoftwareComponentEntity sourceComponent) {
        this.sourceComponent = sourceComponent;
    }

    // Getter for the destination software component
    public SoftwareComponentEntity getDestinationComponent() {
        return destinationComponent;
    }

    // Setter for the destination software component
    public void setDestinationComponent(SoftwareComponentEntity destinationComponent) {
        this.destinationComponent = destinationComponent;
    }

    // Getter for the type
    public String getType() {
        return type;
    }

    // Setter for the type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for the content
    public DataFlowContentEntity getContent() {
        return content;
    }

    // Setter for the content
    public void setContent(DataFlowContentEntity content) {
        this.content = content;
    }

    // Getter for the architecture diagram
    public ArchitectureDiagramEntity getArchitectureDiagram() {
        return architectureDiagram;
    }

    // Setter for the architecture diagram
    public void setArchitectureDiagram(ArchitectureDiagramEntity architectureDiagram) {
        this.architectureDiagram = architectureDiagram;
    }

    @Override
    public int compareTo(DataFlowEntity o) {
        return StringUtils.compare(this.type, o.type);
    }
}