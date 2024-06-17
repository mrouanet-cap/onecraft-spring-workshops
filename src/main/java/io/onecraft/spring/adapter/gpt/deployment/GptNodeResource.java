package io.onecraft.spring.adapter.gpt.deployment;

/**
 * Represents a resource of a node.
 *
 * @param type     The type of the resource
 * @param capacity The capacity of the resource
 * @version 1.0
 */
public record GptNodeResource(String type, String capacity) {
}
