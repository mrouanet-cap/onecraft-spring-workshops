package io.onecraft.spring.domain.design.model.requirement;

import io.onecraft.spring.domain.annotation.NonFunctionalRequirementCategory;
import io.onecraft.spring.domain.annotation.RequirementId;
import io.onecraft.spring.domain.annotation.RequirementPriority;
import io.onecraft.spring.domain.annotation.RequirementStatus;
import io.onecraft.spring.presentation.model.requirement.RequirementAttachementDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

/**
 * This class represents the non-functional requirements of a project.
 * @param requirementId The unique identifier of the requirement.
 * @param requirementDescription The description of the requirement.
 * @param requirementPriority The priority of the requirement. (e.g. high, medium, low, etc.)
 * @param requirementStatus The status of the requirement. (e.g. open, closed, in-progress, etc.)
 * @param requirementCategory Category of the requirement. (e.g. performance, security, etc.)
 * @param requirementOwner Owner of the requirement. (e.g. developer, tester, product owner, etc.)
 * @param requirementReviewer Reviewer of the requirement. (e.g. architect, lead developer, etc.)
 * @param requirementCreatedDate The date when the requirement was created.
 * @param requirementUpdatedDate The date when the requirement was last updated.
 * @param requirementDueDate The date when the requirement is due. (e.g. the date when the requirement should be implemented)
 * @param requirementVersion The version of the requirement. (e.g. 1, 2, 3, etc.)
 * @param requirementComments The comments of the requirement.
 * @param requirementAttachments The attachments of the requirement. (e.g. documents, images, etc.)
 */
public record NonFunctionalRequirement(@RequirementId(pattern = "^NFR-[0-9]{1,4}$") String requirementId,
                                       @NotBlank String requirementDescription,
                                       @RequirementPriority String requirementPriority,
                                       @RequirementStatus String requirementStatus,
                                       @NonFunctionalRequirementCategory String requirementCategory,
                                       @NotBlank String requirementOwner, String requirementReviewer,
                                       @NotNull LocalDate requirementCreatedDate,
                                       LocalDate requirementUpdatedDate, @NotNull LocalDate requirementDueDate,
                                       @Positive Integer requirementVersion,
                                       List<@NotBlank String> requirementComments,
                                       List<@Valid RequirementAttachementDto> requirementAttachments) {
}
