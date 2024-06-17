package io.onecraft.spring.presentation.model.deployment;

import io.onecraft.spring.domain.annotation.NodeResourceType;

/**
 * Represents a resource of a node.
 *
 * @param id       The id of the resource
 * @param type     The type of the resource
 * @param capacity The capacity of the resource
 * @version 1.0
 */
public record NodeResourceDto(Long id, @NodeResourceType String type, String capacity) {
}
