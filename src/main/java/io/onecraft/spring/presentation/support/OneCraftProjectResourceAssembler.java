package io.onecraft.spring.presentation.support;

import io.onecraft.spring.domain.project.model.OneCraftProject;
import io.onecraft.spring.presentation.controller.OneCraftProjectController;
import io.onecraft.spring.presentation.model.OneCraftProjectDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * The resource assembler for the OneCraft project.
 *
 * @version 1.0
 */
@Component
public class OneCraftProjectResourceAssembler implements RepresentationModelAssembler<OneCraftProject, EntityModel<OneCraftProjectDto>> {

    private final PresentationMapper mapper;

    /**
     * Constructor
     *
     * @param mapper the instance of the presentation mapper
     */
    public OneCraftProjectResourceAssembler(PresentationMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EntityModel<OneCraftProjectDto> toModel(OneCraftProject entity) {
        EntityModel<OneCraftProjectDto> projectResource = EntityModel.of(mapper.toDto(entity)).add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
                OneCraftProjectController.class).getOneCraftProject(entity.getId())).withSelfRel());
        if(entity.isDesignable()){
            projectResource.add(
                    WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(OneCraftProjectController.class).createDesign(entity.getId(),
                                    null)).withRel("create_design"));
        }
        if(entity.isClosable()){
            projectResource.add(
                    WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(OneCraftProjectController.class).closeProject(entity.getId())).withRel("close"));
        }
        return projectResource;
    }
}
