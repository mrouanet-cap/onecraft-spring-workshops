package io.onecraft.spring.adapter.gpt.deployment;

/**
 * Represents a connection between two components.
 *
 * @param source      The name of the source component of the connection
 * @param destination The name of the destination component of the connection
 * @param description The description of the connection
 * @param protocol    The protocol of the connection
 * @version 1.0
 */
public record GptComponentConnection(String source, String destination, String description, String protocol) {
}
