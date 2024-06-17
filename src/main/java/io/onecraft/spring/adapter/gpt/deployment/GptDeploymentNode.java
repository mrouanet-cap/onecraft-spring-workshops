package io.onecraft.spring.adapter.gpt.deployment;

import java.util.Set;

/**
 * Represents a node in a deployment model.
 *
 * @param name               Name of the node.
 * @param type               Type or category of the node (e.g., server, database, storage).
 * @param location           Location or environment where the node is deployed.
 * @param resources          Resources or artifacts deployed on the node.
 * @param deployedComponents Software components running on the node.
 * @version 1.0
 */
public record GptDeploymentNode(String name, String type, String location,
                                Set<GptNodeResource> resources,
                                Set<GptDeployedSoftwareComponent> deployedComponents) {
}
