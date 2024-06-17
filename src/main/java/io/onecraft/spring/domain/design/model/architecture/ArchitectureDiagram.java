package io.onecraft.spring.domain.design.model.architecture;

import io.onecraft.spring.domain.annotation.ArchitectureDiagramFormat;
import io.onecraft.spring.domain.annotation.ArchitectureDiagramStatus;
import io.onecraft.spring.domain.annotation.ArchitectureDiagramType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * This class represents the architecture diagram of a project.
 *
 * @param name        The name of the architecture diagram. (e.g. Component Diagram, Class Diagram, etc.)
 * @param description The description of the architecture diagram. (e.g. A high-level overview of the system's
 *                    components.)
 * @param type        The type of the architecture diagram. (e.g. UML, C4, etc.)
 * @param format      The format of the architecture diagram. (e.g. PNG, JPEG, etc.)
 * @param version     The version of the architecture diagram. (e.g. 1, 2, etc.)
 * @param author      The author of the architecture diagram.
 * @param createdDate The date when the architecture diagram was created.
 * @param comments    The comment made by the developers on the architecture diagram.
 * @param tags        The tags of the architecture diagram. (e.g. #component, #class, etc.)
 * @param status      The status of the architecture diagram. (e.g. Draft, Final, etc.)
 * @param updatedDate The date when the architecture diagram was last updated.
 * @param interfaces  Show how components interact with each other, including the type of communication (e.g., REST API,
 *                    messaging queue).
 * @param dataFlows   Illustrate the flow of data between components or layers of the system.
 * @param constraints Represent any architectural constraints or design decisions that influence the system's
 *                    structure.
 */
public record ArchitectureDiagram(Long id, @NotBlank String name, @NotBlank String description,
                                  @ArchitectureDiagramType String type, @ArchitectureDiagramFormat String format,
                                  @Positive Integer version, @NotNull String author,
                                  @NotNull LocalDate createdDate, List<String> comments,
                                  Set<String> tags, @ArchitectureDiagramStatus String status,
                                  LocalDate updatedDate,
                                  Set<@Valid SoftwareComponentInterface> interfaces,
                                  Set<@Valid DataFlow> dataFlows, Set<@Valid ArchitecturalConstraint> constraints) implements Comparable<ArchitectureDiagram>{
    @Override
    public int compareTo(ArchitectureDiagram o) {
        return StringUtils.compare(name, o.name);
    }
}
