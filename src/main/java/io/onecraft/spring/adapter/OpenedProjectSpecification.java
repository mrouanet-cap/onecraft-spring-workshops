package io.onecraft.spring.adapter;

import io.onecraft.spring.adapter.entity.OneCraftProjectEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 * JPA Specification to filter opened projects
 *
 * @version 1.0
 */
public class OpenedProjectSpecification implements Specification<OneCraftProjectEntity> {

    @Override
    public Predicate toPredicate(Root<OneCraftProjectEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return (criteriaBuilder.equal(root.get("status"), "Open"));
    }
}
