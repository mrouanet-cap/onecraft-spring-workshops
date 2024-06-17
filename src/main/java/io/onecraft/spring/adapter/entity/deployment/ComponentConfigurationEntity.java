package io.onecraft.spring.adapter.entity.deployment;

import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a component configuration in the database.
 *
 * @version 1.0
 */
@Entity
@Table(name = "component_configurations")
public class ComponentConfigurationEntity implements Comparable<ComponentConfigurationEntity>{

    // Unique identifier for the component configuration
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "component_configuration_id_generator")
    @SequenceGenerator(name = "component_configuration_id_generator", sequenceName = "component_configuration_id_seq", allocationSize = 1)
    private Long id;

    // Setting of the component configuration
    private String setting;

    // Type of the component configuration
    private String type;

    // Value of the component configuration
    private String value;

    // Deployed software component to which the configuration belongs
    @ManyToOne(fetch = FetchType.LAZY)
    private DeployedSoftwareComponentEntity deployedSoftwareComponent;

    /**
     * Default constructor.
     */
    public ComponentConfigurationEntity() {
    }

    /**
     * Returns the unique identifier of the component configuration.
     * @return current value of the identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the component configuration.
     * @param id new value of the identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the setting
    public String getSetting() {
        return setting;
    }

    // Setter for the setting
    public void setSetting(String setting) {
        this.setting = setting;
    }

    // Getter for the type
    public String getType() {
        return type;
    }

    // Setter for the type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for the value
    public String getValue() {
        return value;
    }

    // Setter for the value
    public void setValue(String value) {
        this.value = value;
    }

    // Getter for the deployed software component
    public DeployedSoftwareComponentEntity getDeployedSoftwareComponent() {
        return deployedSoftwareComponent;
    }

    // Setter for the deployed software component
    public void setDeployedSoftwareComponent(DeployedSoftwareComponentEntity deployedSoftwareComponent) {
        this.deployedSoftwareComponent = deployedSoftwareComponent;
    }

    @Override
    public int compareTo(ComponentConfigurationEntity o) {
        return StringUtils.compare(setting, o.setting);
    }
}