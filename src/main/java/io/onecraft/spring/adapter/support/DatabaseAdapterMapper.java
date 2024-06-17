package io.onecraft.spring.adapter.support;

import io.onecraft.spring.adapter.entity.OneCraftProjectEntity;
import io.onecraft.spring.adapter.entity.OneCraftProjectTechnicalDesignEntity;
import io.onecraft.spring.adapter.entity.SoftwareComponentEntity;
import io.onecraft.spring.adapter.entity.architecture.ArchitecturalConstraintEntity;
import io.onecraft.spring.adapter.entity.architecture.ArchitectureDiagramEntity;
import io.onecraft.spring.adapter.entity.architecture.DataFlowEntity;
import io.onecraft.spring.adapter.entity.architecture.SoftwareComponentInterfaceEntity;
import io.onecraft.spring.adapter.entity.data.DataModelConstraintEntity;
import io.onecraft.spring.adapter.entity.data.DataModelEntityAttributeEntity;
import io.onecraft.spring.adapter.entity.data.DataModelEntityEntity;
import io.onecraft.spring.adapter.entity.data.DataModelRelationshipEntity;
import io.onecraft.spring.adapter.entity.deployment.*;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.domain.design.model.SoftwareComponent;
import io.onecraft.spring.domain.design.model.architecture.ArchitecturalConstraint;
import io.onecraft.spring.domain.design.model.architecture.ArchitectureDiagram;
import io.onecraft.spring.domain.design.model.architecture.DataFlow;
import io.onecraft.spring.domain.design.model.architecture.SoftwareComponentInterface;
import io.onecraft.spring.domain.design.model.data.*;
import io.onecraft.spring.domain.design.model.deployment.*;
import io.onecraft.spring.domain.project.model.OneCraftProject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper
public interface DatabaseAdapterMapper {
    @Mapping(target = "design", ignore = true)
    OneCraftProjectEntity toEntity(OneCraftProject project);

    OneCraftProject toDomain(OneCraftProjectEntity entity);

    @Mapping(target = "project", ignore = true)
    OneCraftProjectTechnicalDesignEntity toEntity(OneCraftProjectTechnicalDesign design);

    @Mapping(target = "projectId", source = "project.id")
    OneCraftProjectTechnicalDesign toDomain(OneCraftProjectTechnicalDesignEntity entity);

    ComponentConnection toDomain(ComponentConnectionEntity entity);

    DataModelEntity toDomain(DataModelEntityEntity entity);

    DeployedSoftwareComponent toDomain(DeployedSoftwareComponentEntity entity);

    ComponentConfiguration toDomain(ComponentConfigurationEntity entity);

    DataFlow toDomain(DataFlowEntity entity);

    DataModelEntityAttribute toDomain(DataModelEntityAttributeEntity entity);

    DataModelConstraint toDomain(DataModelConstraintEntity entity);

    @Mapping(target = "deployedSoftwareComponent", ignore = true)
    ComponentConfigurationEntity toEntity(ComponentConfiguration configuration);

    @Mapping(target = "node", ignore = true)
    NodeResourceEntity toEntity(NodeResource resource);

    NodeResource toDomain(NodeResourceEntity entity);

    @Mapping(target = "deploymentDiagram", ignore = true)
    DeploymentNodeEntity toEntity(DeploymentNode node);

    @Mapping(target = "design", ignore = true)
    DeploymentDiagramEntity toEntity(DeploymentDiagram diagram);

    @Mapping(target = "deploymentNode", ignore = true)
    DeployedSoftwareComponentEntity toEntity(DeployedSoftwareComponent component);

    @Mapping(target = "deploymentDiagram", ignore = true)
    ComponentConnectionEntity toEntity(ComponentConnection connection);

    @Mapping(target = "design", ignore = true)
    ArchitectureDiagramEntity toEntity(ArchitectureDiagram diagram);

    @Mapping(target = "design", ignore = true)
    SoftwareComponentEntity toEntity(SoftwareComponent component);

    @Mapping(target = "architectureDiagram", ignore = true)
    SoftwareComponentInterfaceEntity toEntity(SoftwareComponentInterface component);

    @Mapping(target = "architectureDiagram", ignore = true)
    ArchitecturalConstraintEntity toEntity(ArchitecturalConstraint component);

    @Mapping(target = "architectureDiagram", ignore = true)
    DataFlowEntity toEntity(DataFlow dataFlow);

    @Mapping(target = "design", ignore = true)
    io.onecraft.spring.adapter.entity.data.DataModelEntity toEntity(DataModel dataModel);

    @Mapping(target = "dataModel", ignore = true)
    DataModelConstraintEntity toEntity(DataModelConstraint constraint);

    @Mapping(target = "dataModel", ignore = true)
    DataModelRelationshipEntity toEntity(DataModelRelationship relationship);

    @Mapping(target = "dataModel", ignore = true)
    DataModelEntityEntity toEntity(DataModelEntity dataModelEntity);

    @Mapping(target = "entity", ignore = true)
    DataModelEntityAttributeEntity toEntity(DataModelEntityAttribute attribute);

    DataModelRelationship toDomain(DataModelRelationshipEntity relationship);

    Set<OneCraftProject> toDomain(List<OneCraftProjectEntity> content);
}
