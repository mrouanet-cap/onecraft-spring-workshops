package io.onecraft.spring.presentation.support;

import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.presentation.controller.OneCraftTechnicalDesignController;
import io.onecraft.spring.presentation.model.OneCraftProjectTechnicalDesignDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * The resource assembler for the OneCraft project technical design.
 *
 * @version 1.0
 */
@Component
public class OneCraftProjectTechnicalDesignResourceAssembler implements RepresentationModelAssembler<OneCraftProjectTechnicalDesign, EntityModel<OneCraftProjectTechnicalDesignDto>> {

    private final PresentationMapper mapper;

    /**
     * Constructor
     *
     * @param mapper the instance of the presentation mapper
     */
    public OneCraftProjectTechnicalDesignResourceAssembler(PresentationMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EntityModel<OneCraftProjectTechnicalDesignDto> toModel(OneCraftProjectTechnicalDesign entity) {
        EntityModel<OneCraftProjectTechnicalDesignDto> designEntity = EntityModel.of(mapper.toDto(entity)).add(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
                        OneCraftTechnicalDesignController.class).getTechnicalDesign(entity.getId())).withSelfRel());
        if (entity.isApprovable()) {
            designEntity.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
                    OneCraftTechnicalDesignController.class).approveTechnicalDesign(entity.getId())).withRel(
                    "approve"));
        }
        return designEntity;
    }
}
