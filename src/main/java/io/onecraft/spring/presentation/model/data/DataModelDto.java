package io.onecraft.spring.presentation.model.data;

import jakarta.validation.Valid;

import java.util.Set;

/**
 * This class represents a data model produced during the design phase of the project.
 *
 * @param id            unique identifier of the data model
 * @param entities      Represent the main objects or concepts in the data model.
 * @param relationships Connections between entities, indicating how they are associated.
 * @param constraints   Rules or limitations that govern the data model.
 */
public record DataModelDto(Long id, Set<@Valid DataModelEntityDto> entities,
                           Set<@Valid DataModelRelationshipDto> relationships,
                           Set<@Valid DataModelConstraintDto> constraints) {
}
