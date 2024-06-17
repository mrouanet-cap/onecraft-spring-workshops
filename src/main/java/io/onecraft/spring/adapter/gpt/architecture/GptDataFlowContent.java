package io.onecraft.spring.adapter.gpt.architecture;

/**
 * Represents the content of a data flow between two components.
 *
 * @param dataType    Type or format of the data being transferred (e.g., JSON, XML, binary).
 * @param description Information about the content being transferred, including its structure or purpose.
 */
public record GptDataFlowContent(String dataType, String description) {
}
