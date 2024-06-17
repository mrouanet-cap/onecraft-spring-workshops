package io.onecraft.spring.domain.design.model.architecture;

import io.onecraft.spring.domain.annotation.DataType;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents the content of a data flow between two components.
 *
 * @param id          Unique identifier of the data flow content.
 * @param dataType    Type or format of the data being transferred (e.g., JSON, XML, binary).
 * @param description Information about the content being transferred, including its structure or purpose.
 */
public record DataFlowContent(Long id, @DataType String dataType, @NotBlank String description) {
}
