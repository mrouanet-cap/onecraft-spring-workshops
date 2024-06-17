package io.onecraft.spring.presentation.model.deployment;

import io.onecraft.spring.domain.annotation.DeploymentDiagramFormat;
import io.onecraft.spring.domain.annotation.DeploymentDiagramStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Represents a deployment diagram.
 *
 * @param id             Unique identifier of the deployment diagram.
 * @param name           The name of the deployment diagram.
 * @param description    The description of the deployment diagram.
 * @param format         The format of the deployment diagram (e.g., UML, ArchiMate).
 * @param version        The version of the deployment diagram.
 * @param author         The author of the deployment diagram.
 * @param createdDate    The date when the deployment diagram was created.
 * @param comments       The comment made by the developers on the deployment diagram.
 * @param tags           The tags of the deployment diagram.
 * @param status         The status of the deployment diagram (e.g., Draft, Final).
 * @param updatedDate    The date when the deployment diagram was last updated.
 * @param connections    The connections between the software components.
 * @param nodes          The nodes where the software components are deployed.
 * @version 1.0
 */
public record DeploymentDiagramDto(Long id, @NotBlank String name, @NotBlank String description,
                                   @DeploymentDiagramFormat String format,
                                   @Positive Integer version, @NotNull String author,
                                   @NotNull LocalDate createdDate, List<String> comments,
                                   List<String> tags, @DeploymentDiagramStatus String status,
                                   LocalDate updatedDate,
                                   Set<@Valid ComponentConnectionDto> connections,
                                   Set<@Valid DeploymentNodeDto> nodes) {
}
