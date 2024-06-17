package io.onecraft.spring.adapter.gpt.data;

import java.util.Set;

/**
 * This class represents a data model produced during the design phase of the project.
 *
 * @param entities      Represent the main objects or concepts in the data model.
 * @param relationships Connections between entities, indicating how they are associated.
 * @param constraints   Rules or limitations that govern the data model.
 */
public record GptDataModel(Set<GptDataModelEntity> entities,
                           Set<GptDataModelRelationship> relationships,
                           Set<GptDataModelConstraint> constraints) {
}
