package io.onecraft.spring.presentation.model.architecture;

import io.onecraft.spring.domain.design.model.SoftwareComponent;
import io.onecraft.spring.domain.annotation.DataFlowType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a data flow between two components of the project.
 *
 * @param id                   Unique identifier of the data flow.
 * @param sourceComponent      the source component.
 * @param destinationComponent the destination component.
 * @param type                 Nature of the data flow (e.g., request/response, event notification).
 * @param content              Description of the data being transferred.
 */
public record DataFlowDto(Long id, @NotNull SoftwareComponent sourceComponent, @NotNull SoftwareComponent destinationComponent,
                          @DataFlowType String type,
                          @Valid DataFlowContentDto content) {
}
