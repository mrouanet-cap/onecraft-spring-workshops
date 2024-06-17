package io.onecraft.spring.presentation.model.requirement;

import io.onecraft.spring.domain.annotation.NonFunctionalRequirementCategory;
import io.onecraft.spring.domain.annotation.RequirementId;
import io.onecraft.spring.domain.annotation.RequirementPriority;
import io.onecraft.spring.domain.annotation.RequirementStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record NonFunctionalRequirementDto(@RequirementId(pattern = "^NFR-[0-9]{1,4}$") String requirementId,
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
