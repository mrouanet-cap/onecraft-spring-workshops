package io.onecraft.spring.presentation.model.requirement;

import io.onecraft.spring.domain.annotation.FunctionalRequirementCategory;
import io.onecraft.spring.domain.annotation.RequirementId;
import io.onecraft.spring.domain.annotation.RequirementPriority;
import io.onecraft.spring.domain.annotation.RequirementStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

/**
 * A functional requirement.
 *
 * @param requirementId          The unique identifier of the requirement.
 * @param requirementDescription The description of the requirement.
 * @param requirementPriority    The priority of the requirement.
 * @param requirementStatus      The status of the requirement.
 * @param requirementCategory    The category of the requirement.
 * @param requirementOwner       The owner of the requirement.
 * @param requirementReviewer    The reviewer of the requirement.
 * @param requirementCreatedDate The date the requirement was created.
 * @param requirementUpdatedDate The date the requirement was updated.
 * @param requirementDueDate     The date the requirement is due.
 * @param requirementVersion     The version of the requirement.
 * @param requirementComments    The comments of the requirement.
 * @param requirementAttachments The attachments of the requirement.
 * @version 1.0
 */
public record FunctionalRequirementDto(@RequirementId(pattern = "^FR-[0-9]{1,4}$") String requirementId,
                                       @NotBlank String requirementDescription,
                                       @RequirementPriority String requirementPriority,
                                       @RequirementStatus String requirementStatus,
                                       @FunctionalRequirementCategory String requirementCategory,
                                       @NotBlank String requirementOwner, String requirementReviewer,
                                       @NotNull LocalDate requirementCreatedDate,
                                       LocalDate requirementUpdatedDate, @NotNull LocalDate requirementDueDate,
                                       @Positive Integer requirementVersion,
                                       List<@NotBlank String> requirementComments,
                                       List<@Valid RequirementAttachementDto> requirementAttachments) {
}
