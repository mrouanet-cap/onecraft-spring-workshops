package io.onecraft.spring.adapter.gpt.deployment;

import java.util.Set;

/**
 * A deployed software component.
 *
 * @param componentName  The name of the component.
 * @param configurations The configurations of the software component.
 * @version 1.0
 */
public record GptDeployedSoftwareComponent(String componentName, Set<GptComponentConfiguration> configurations) {
}
