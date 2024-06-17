package io.onecraft.spring.presentation.model.deployment;

import io.onecraft.spring.domain.design.model.SoftwareComponent;
import io.onecraft.spring.domain.annotation.ConnectionProtocol;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a connection between two components.
 *
 * @param id          The id of the connection
 * @param source      The source component
 * @param target      The target component
 * @param description The description of the connection
 * @param protocol    The protocol of the connection
 * @version 1.0
 */
public record ComponentConnectionDto(Long id, @NotNull SoftwareComponent source, @NotNull SoftwareComponent target,
                                     String description,
                                     @ConnectionProtocol String protocol) {
}
