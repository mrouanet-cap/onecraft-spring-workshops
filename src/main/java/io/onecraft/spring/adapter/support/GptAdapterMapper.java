package io.onecraft.spring.adapter.support;

import io.onecraft.spring.adapter.gpt.GptProjectTechnicalDesign;
import io.onecraft.spring.adapter.gpt.GptSoftwareComponent;
import io.onecraft.spring.adapter.gpt.architecture.*;
import io.onecraft.spring.adapter.gpt.data.*;
import io.onecraft.spring.adapter.gpt.deployment.*;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.domain.design.model.SoftwareComponent;
import io.onecraft.spring.domain.design.model.architecture.*;
import io.onecraft.spring.domain.design.model.data.*;
import io.onecraft.spring.domain.design.model.deployment.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Defines all the mapping methods to convert between GPT and domain objects.
 *
 * @version 1.0
 */
@Mapper
public interface GptAdapterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projectId", ignore = true)
    @Mapping(target = "status", constant = "DRAFT")
    OneCraftProjectTechnicalDesign toDomain(GptProjectTechnicalDesign gptDesign);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", constant = "GPT")
    @Mapping(target = "status", constant = "DRAFT")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "version", constant = "1")
    ArchitectureDiagram toDomain(GptArchitectureDiagram gptArchitectureDiagram);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", constant = "GPT")
    @Mapping(target = "status", constant = "DRAFT")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "version", constant = "1")
    DeploymentDiagram toDomain(GptDeploymentDiagram gptDeploymentDiagram);

    @Mapping(target = "id", ignore = true)
    DeploymentNode toDomain(GptDeploymentNode gptDeploymentNode);

    @Mapping(target = "id", ignore = true)
    NodeResource toDomain(GptNodeResource gptNodeResource);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sourceComponent.name", source = "sourceComponent")
    @Mapping(target = "destinationComponent.name", source = "destinationComponent")
    DataFlow toDomain(GptDataFlow gptDataFlow);

    @Mapping(target = "id", ignore = true)
    SoftwareComponent toDomain(GptSoftwareComponent gptSoftwareComponent);

    @Mapping(target = "id", ignore = true)
    DataModel toDomain(GptDataModel gptDataModel);

    @Mapping(target = "id", ignore = true)
    ArchitecturalConstraint toDomain(GptArchitecturalConstraint gptArchitecturalConstraint);

    @Mapping(target = "id", ignore = true)
    DataModelConstraint toDomain(GptDataModelConstraint gptDataModelConstraint);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "component.name", source = "componentName")
    DeployedSoftwareComponent toDomain(GptDeployedSoftwareComponent gptDeployedSoftwareComponent);

    @Mapping(target = "id", ignore = true)
    ComponentConfiguration toDomain(GptComponentConfiguration gptComponentConfiguration);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "component.name", source = "componentName")
    SoftwareComponentInterface toDomain(GptSoftwareComponentInterface gptSoftwareComponentInterface);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "source.name", source = "source")
    @Mapping(target = "target.name", source = "destination")
    ComponentConnection toDomain(GptComponentConnection gptComponentConnection);

    @Mapping(target = "id", ignore = true)
    DataFlowContent toDomain(GptDataFlowContent gptDataFlowContent);

    @Mapping(target = "id", ignore = true)
    DataModelEntityAttribute toDomain(GptDataModelEntityAttribute gptEntityAttribute);

    @Mapping(target = "id", ignore = true)
    DataModelEntity toDomain(GptDataModelEntity gptEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "targetEntity.name", source = "targetName")
    @Mapping(target = "sourceEntity.name", source = "sourceName")
    DataModelRelationship toDomain(GptDataModelRelationship gptRelationship);
}
