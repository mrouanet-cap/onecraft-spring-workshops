package io.onecraft.spring.domain.design.model.deployment;

import io.onecraft.spring.domain.annotation.DataType;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a component configuration.
 *
 * @param id            The id of the configuration
 * @param setting       The setting of the configuration
 * @param type          The type of the configuration
 * @param value         The value of the configuration
 * @version 1.0
 */
public record ComponentConfiguration(Long id, @NotBlank String setting,
                                     @DataType String type, @NotBlank String value) {
}
