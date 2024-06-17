package io.onecraft.spring.presentation.model;

import io.onecraft.spring.presentation.model.architecture.ArchitectureDiagramDto;
import io.onecraft.spring.presentation.model.data.DataModelDto;
import io.onecraft.spring.presentation.model.deployment.DeploymentDiagramDto;
import jakarta.validation.Valid;

import java.util.Set;

/**
 * This class represents the design of a project.
 *
 * @param id                   unique identifier of the design
 * @param projectId            unique identifier of the project
 * @param status               the status of the design
 * @param dataModels           the data models of the design
 * @param architectureDiagrams the architecture diagrams of the design
 * @param deploymentDiagrams   the deployment diagrams of the design
 * @param components           the software components of the design
 * @version 1.0
 */
public record OneCraftProjectTechnicalDesignDto(Long id, Long projectId, String status,
                                                Set<@Valid DataModelDto> dataModels,
                                                Set<@Valid ArchitectureDiagramDto> architectureDiagrams,
                                                Set<@Valid DeploymentDiagramDto> deploymentDiagrams,
                                                Set<@Valid SoftwareComponentDto> components) {

}
