package io.onecraft.spring.domain.design.model.deployment;

import io.onecraft.spring.domain.design.model.SoftwareComponent;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

/**
 * A deployed software component.
 *
 * @param id             The id of the deployment.
 * @param component      The deployed component.
 * @param configurations The configurations of the software component.
 * @version 1.0
 */
public record DeployedSoftwareComponent(Long id, @NotNull SoftwareComponent component,
                                        Set<ComponentConfiguration> configurations) {
}
