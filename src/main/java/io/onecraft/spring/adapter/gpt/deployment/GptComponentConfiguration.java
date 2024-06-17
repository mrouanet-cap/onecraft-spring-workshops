package io.onecraft.spring.adapter.gpt.deployment;

/**
 * Represents a component configuration.
 *
 * @param component The component name concerned by the configuration
 * @param setting   The setting of the configuration
 * @param type      The type of the configuration
 * @param value     The value of the configuration
 * @version 1.0
 */
public record GptComponentConfiguration(String component, String setting, String type, String value) {
}
