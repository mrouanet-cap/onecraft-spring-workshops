package io.onecraft.spring.adapter.gpt.deployment;

import java.util.Set;

/**
 * Represents a deployment diagram.
 *
 * @param name        The name of the deployment diagram.
 * @param description The description of the deployment diagram.
 * @param format      The format of the deployment diagram (e.g., UML, ArchiMate).
 * @param version     The version of the deployment diagram.
 * @param connections The connections between the software components.
 * @param nodes       The nodes where the software components are deployed.
 * @version 1.0
 */
public record GptDeploymentDiagram(String name, String description,
                                   String format,
                                   Set<GptComponentConnection> connections,
                                   Set<GptDeploymentNode> nodes) {
}
