package io.onecraft.spring.adapter.gpt.architecture;

/**
 * Represents a data flow between two components of the project.
 *
 * @param sourceComponent      name of the source component.
 * @param destinationComponent name of the destination component.
 * @param type                 Nature of the data flow (e.g., request/response, event notification).
 * @param content              Description of the data being transferred.
 */
public record GptDataFlow(String sourceComponent, String destinationComponent,
                          String type,
                          GptDataFlowContent content) {
}
