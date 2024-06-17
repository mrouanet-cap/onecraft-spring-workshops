package io.onecraft.spring.presentation.model.requirement;

import jakarta.validation.constraints.NotBlank;

/**
 * A requirement attachment.
 *
 * @param name        The name of the attachment.
 * @param description The description of the attachment.
 * @param path        The path to the attachment.
 * @version 1.0
 */
public record RequirementAttachementDto(@NotBlank String name, @NotBlank String description, @NotBlank String path) {
}
