package io.onecraft.spring.domain.design.model.data;

import jakarta.validation.Valid;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Objects;
import java.util.Set;

/**
 * This class represents a data model produced during the design phase of the project.
 *
 * @param id            unique identifier of the data model
 * @param entities      Represent the main objects or concepts in the data model.
 * @param relationships Connections between entities, indicating how they are associated.
 * @param constraints   Rules or limitations that govern the data model.
 */
public record DataModel(Long id, Set<@Valid DataModelEntity> entities,
                        Set<@Valid DataModelRelationship> relationships,
                        Set<@Valid DataModelConstraint> constraints) implements Comparable<DataModel> {
    @Override
    public int compareTo(DataModel o) {
        return Objects.compare(id, o.id, NumberUtils::compare);
    }
}
