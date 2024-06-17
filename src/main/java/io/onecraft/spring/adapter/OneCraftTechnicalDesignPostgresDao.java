package io.onecraft.spring.adapter;

import io.onecraft.spring.adapter.entity.OneCraftProjectEntity;
import io.onecraft.spring.adapter.entity.OneCraftProjectTechnicalDesignEntity;
import io.onecraft.spring.adapter.repository.OneCraftProjectRepository;
import io.onecraft.spring.adapter.repository.OneCraftProjectTechnicalDesignRepository;
import io.onecraft.spring.adapter.support.DatabaseAdapterMapper;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.domain.exception.OneCraftProjectNotFoundException;
import io.onecraft.spring.domain.exception.TechnicalDesignNotFoundException;
import io.onecraft.spring.domain.spi.OneCraftProjectDesignDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class OneCraftTechnicalDesignPostgresDao implements OneCraftProjectDesignDao {

    private final OneCraftProjectTechnicalDesignRepository oneCraftProjectTechnicalDesignRepository;

    private final OneCraftProjectRepository oneCraftProjectRepository;

    private final DatabaseAdapterMapper adapterMapper;

    /**
     * The constructor for the Postgres data access object.
     *
     * @param oneCraftProjectTechnicalDesignRepository the project technical design repository.
     * @param oneCraftProjectRepository                the project repository.
     * @param adapterMapper                            the adapter mapper.
     */
    public OneCraftTechnicalDesignPostgresDao(OneCraftProjectTechnicalDesignRepository oneCraftProjectTechnicalDesignRepository, OneCraftProjectRepository oneCraftProjectRepository, DatabaseAdapterMapper adapterMapper) {
        this.oneCraftProjectTechnicalDesignRepository = oneCraftProjectTechnicalDesignRepository;
        this.oneCraftProjectRepository = oneCraftProjectRepository;
        this.adapterMapper = adapterMapper;
    }

    @Override
    public OneCraftProjectTechnicalDesign getTechnicalDesign(Long designId) {
        return adapterMapper.toDomain(oneCraftProjectTechnicalDesignRepository.findById(designId).orElseThrow(
                () -> new TechnicalDesignNotFoundException(designId)));
    }

    @Override
    public OneCraftProjectTechnicalDesign saveProjectTechnicalDesign(OneCraftProjectTechnicalDesign oneCraftProjectTechnicalDesign) {
        OneCraftProjectEntity projectToDesign = oneCraftProjectRepository.findById(
                oneCraftProjectTechnicalDesign.getProjectId()).orElseThrow(
                () -> new OneCraftProjectNotFoundException(oneCraftProjectTechnicalDesign.getProjectId()));
        projectToDesign.setDesign(adapterMapper.toEntity(oneCraftProjectTechnicalDesign));
        fillDesign(projectToDesign.getDesign());
        fillArchitectureDiagram(projectToDesign.getDesign());
        fillDataModel(projectToDesign.getDesign());
        fillDeploymentDiagram(projectToDesign.getDesign());
        fillDeploymentNode(projectToDesign.getDesign());
        fillDataFlow(projectToDesign.getDesign());
        replaceComponents(projectToDesign.getDesign());
        replaceEntities(projectToDesign.getDesign());
        return adapterMapper.toDomain(
                oneCraftProjectRepository.save(projectToDesign).getDesign());
    }

    /**
     * Fills the components, architecture diagrams, deployment diagrams and data models with the design.
     *
     * @param design the design to fill.
     */
    private void fillDesign(OneCraftProjectTechnicalDesignEntity design) {
        design.getComponents().forEach(component -> component.setDesign(design));
        design.getArchitectureDiagrams().forEach(architectureDiagram -> architectureDiagram.setDesign(design));
        design.getDeploymentDiagrams().forEach(deploymentDiagram -> deploymentDiagram.setDesign(design));
        design.getDataModels().forEach(dataModel -> dataModel.setDesign(design));
    }

    private void fillArchitectureDiagram(OneCraftProjectTechnicalDesignEntity design) {
        design.getArchitectureDiagrams().forEach(architectureDiagram -> {
            architectureDiagram.getConstraints().forEach(
                    constraint -> constraint.setArchitectureDiagram(architectureDiagram));
            architectureDiagram.getDataFlows().forEach(
                    dataFlow -> dataFlow.setArchitectureDiagram(architectureDiagram));
            architectureDiagram.getInterfaces().forEach(
                    componentInterface -> componentInterface.setArchitectureDiagram(architectureDiagram));
        });
    }

    private void replaceComponents(OneCraftProjectTechnicalDesignEntity design) {
        design.getComponents().forEach(component -> {
            // Fill component in deployed components
            design.getDeploymentDiagrams().forEach(
                    deploymentDiagram -> {
                        deploymentDiagram.getNodes().forEach(
                                node -> node.getDeployedComponents().forEach(deployedComponent -> {
                                    if (StringUtils.equals(deployedComponent.getComponent().getName(),
                                            component.getName())) {
                                        deployedComponent.setComponent(component);
                                    }
                                }));
                        deploymentDiagram.getConnections().forEach(
                                connection -> {
                                    if (StringUtils.equals(connection.getSource().getName(),
                                            component.getName())) {
                                        connection.setSource(component);
                                    }
                                    if (StringUtils.equals(connection.getTarget().getName(),
                                            component.getName())) {
                                        connection.setTarget(component);
                                    }
                                }
                        );
                    });
            design.getArchitectureDiagrams().forEach(
                    // Fill component in data flows
                    architectureDiagram -> {
                        architectureDiagram.getDataFlows().forEach(
                                dataFlow -> {
                                    if (StringUtils.equals(dataFlow.getSourceComponent().getName(),
                                            component.getName())) {
                                        dataFlow.setSourceComponent(component);
                                    }
                                    if (StringUtils.equals(dataFlow.getDestinationComponent().getName(),
                                            component.getName())) {
                                        dataFlow.setDestinationComponent(component);
                                    }
                                }
                        );
                        // Fill component in interfaces
                        architectureDiagram.getInterfaces().forEach(
                                componentInterface -> {
                                    if (StringUtils.equals(componentInterface.getComponent().getName(),
                                            component.getName())) {
                                        componentInterface.setComponent(component);
                                    }
                                }
                        );
                    }
            );
        });
    }

    /**
     * Fills entities, relationships and constraints with the data model.
     *
     * @param design the design to work with.
     */
    private void fillDataModel(OneCraftProjectTechnicalDesignEntity design) {
        design.getDataModels().forEach(dataModel -> {
            dataModel.getEntities().forEach(entity -> entity.setDataModel(dataModel));
            dataModel.getRelationships().forEach(relationship -> relationship.setDataModel(dataModel));
            dataModel.getConstraints().forEach(constraint -> constraint.setDataModel(dataModel));
        });
    }

    /**
     * Fills deployed components with the deployment node.
     *
     * @param design the design to work with.
     */
    private void fillDeploymentNode(OneCraftProjectTechnicalDesignEntity design) {
        design.getDeploymentDiagrams().forEach(deploymentDiagram -> {
            deploymentDiagram.getNodes().forEach(node -> {
                node.getDeployedComponents().forEach(deployedComponent -> deployedComponent.setDeploymentNode(node));
            });
        });
    }

    /**
     * Replaces entities in attributes and relationships.
     *
     * @param design the design to work with.
     */
    private void replaceEntities(OneCraftProjectTechnicalDesignEntity design) {
        design.getDataModels().forEach(dataModel -> {
            dataModel.getEntities().forEach(entity -> {
                // Fill entity in attributes
                entity.getAttributes().forEach(attribute -> attribute.setEntity(entity));
                // Fill entity in relationships
                dataModel.getRelationships().forEach(relationship -> {
                    if (StringUtils.equals(relationship.getSourceEntity().getName(), entity.getName())) {
                        relationship.setSourceEntity(entity);
                    }
                    if (StringUtils.equals(relationship.getTargetEntity().getName(), entity.getName())) {
                        relationship.setTargetEntity(entity);
                    }
                });
            });
        });
    }

    /**
     * Fills the deployment diagram with nodes and connections.
     *
     * @param design the design to work with.
     */
    private void fillDeploymentDiagram(OneCraftProjectTechnicalDesignEntity design) {
        design.getDeploymentDiagrams().forEach(deploymentDiagram -> {
            deploymentDiagram.getNodes().forEach(node -> node.setDeploymentDiagram(deploymentDiagram));
            deploymentDiagram.getConnections().forEach(
                    connection -> connection.setDeploymentDiagram(deploymentDiagram));
        });
    }

    private void fillDataFlow(OneCraftProjectTechnicalDesignEntity design) {
        design.getArchitectureDiagrams().forEach(architectureDiagram -> {
            architectureDiagram.getDataFlows().forEach(dataFlow -> {
                dataFlow.getContent().setDataFlow(dataFlow);
            });
        });
    }
}
