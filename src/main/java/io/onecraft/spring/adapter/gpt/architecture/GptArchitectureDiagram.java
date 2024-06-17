package io.onecraft.spring.adapter.gpt.architecture;

import java.util.Set;

/**
 * This class represents the architecture diagram of a project.
 *
 * @param name        The name of the architecture diagram. (e.g. Component Diagram, Class Diagram, etc.)
 * @param description The description of the architecture diagram. (e.g. A high-level overview of the system's
 *                    components.)
 * @param type        The type of the architecture diagram. (e.g. UML, C4, etc.)
 * @param format      The format of the architecture diagram. (e.g. PNG, JPEG, etc.)
 * @param interfaces  Show how components interact with each other, including the type of communication (e.g., REST API,
 *                    messaging queue).
 * @param dataFlows   Illustrate the flow of data between components or layers of the system.
 * @param constraints Represent any architectural constraints or design decisions that influence the system's
 *                    structure.
 */
public record GptArchitectureDiagram(String name, String description,
                                     String type, String format,
                                     Set<GptSoftwareComponentInterface> interfaces,
                                     Set<GptDataFlow> dataFlows, Set<GptArchitecturalConstraint> constraints) {
}
