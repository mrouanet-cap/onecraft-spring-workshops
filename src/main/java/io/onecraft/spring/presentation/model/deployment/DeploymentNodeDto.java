package io.onecraft.spring.presentation.model.deployment;

import io.onecraft.spring.domain.annotation.DeploymentNodeType;
import jakarta.validation.Valid;

import java.util.Set;

/**
 * Represents a node in a deployment model.
 *
 * @param id                 Unique identifier of the node.
 * @param name               Name of the node.
 * @param type               Type or category of the node (e.g., server, database, storage).
 * @param location           Location or environment where the node is deployed.
 * @param resources          Resources or artifacts deployed on the node.
 * @param deployedComponents Software components running on the node.
 * @version 1.0
 */
public record DeploymentNodeDto(Long id, String name, @DeploymentNodeType String type, String location,
                                Set<@Valid NodeResourceDto> resources,
                                Set<@Valid DeployedSoftwareComponentDto> deployedComponents) {
}
