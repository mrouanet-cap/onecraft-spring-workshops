package io.onecraft.spring.domain.design.model.requirement;

import jakarta.validation.constraints.NotBlank;

/**
 * A requirement attachment.
 *
 * @param name        The name of the attachment.
 * @param description The description of the attachment.
 * @param path        The path to the attachment.
 * @version 1.0
 */
public record RequirementAttachement(@NotBlank String name, @NotBlank String description, @NotBlank String path) {
}
