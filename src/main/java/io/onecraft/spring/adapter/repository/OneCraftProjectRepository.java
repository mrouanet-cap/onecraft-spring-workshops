package io.onecraft.spring.adapter.repository;

import io.onecraft.spring.adapter.entity.OneCraftProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OneCraftProjectRepository extends JpaRepository<OneCraftProjectEntity, Long>, JpaSpecificationExecutor<OneCraftProjectEntity> {

}
