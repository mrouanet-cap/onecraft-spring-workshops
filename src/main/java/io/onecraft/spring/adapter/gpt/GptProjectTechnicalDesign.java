package io.onecraft.spring.adapter.gpt;


import io.onecraft.spring.adapter.gpt.architecture.GptArchitectureDiagram;
import io.onecraft.spring.adapter.gpt.data.GptDataModel;
import io.onecraft.spring.adapter.gpt.deployment.GptDeploymentDiagram;

import java.util.List;
import java.util.Set;

/**
 * This class represents the technical design of a project.
 *
 * @version 1.0
 */

/**
 * Represents the technical design of a OneCraft project. This class contains information about the project's ID,
 * status, description, data models, architecture diagrams, deployment diagrams, and software components.
 */
public class GptProjectTechnicalDesign {
    private Set<GptDataModel> dataModels;
    private Set<GptArchitectureDiagram> architectureDiagrams;
    private Set<GptDeploymentDiagram> deploymentDiagrams;
    private Set<GptSoftwareComponent> components;

    /**
     * Default constructor.
     */
    public GptProjectTechnicalDesign() {
    }

    public Set<GptDataModel> getDataModels() {
        return dataModels;
    }

    public void setDataModels(Set<GptDataModel> dataModels) {
        this.dataModels = dataModels;
    }

    public Set<GptArchitectureDiagram> getArchitectureDiagrams() {
        return architectureDiagrams;
    }

    public void setArchitectureDiagrams(Set<GptArchitectureDiagram> architectureDiagrams) {
        this.architectureDiagrams = architectureDiagrams;
    }

    public Set<GptDeploymentDiagram> getDeploymentDiagrams() {
        return deploymentDiagrams;
    }

    public void setDeploymentDiagrams(Set<GptDeploymentDiagram> deploymentDiagrams) {
        this.deploymentDiagrams = deploymentDiagrams;
    }

    public Set<GptSoftwareComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<GptSoftwareComponent> components) {
        this.components = components;
    }
}
