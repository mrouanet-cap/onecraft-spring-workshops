package io.onecraft.spring.presentation.support;

import io.onecraft.spring.presentation.model.OneCraftProjectCreationRequestDto;
import io.onecraft.spring.presentation.model.OneCraftProjectDesignCreationRequestDto;
import io.onecraft.spring.presentation.model.OneCraftProjectDto;
import io.onecraft.spring.presentation.model.OneCraftProjectTechnicalDesignDto;
import org.mapstruct.Mapper;

import io.onecraft.spring.domain.project.model.OneCraftProject;
import io.onecraft.spring.domain.project.model.OneCraftProjectCreationRequest;
import io.onecraft.spring.domain.project.model.OneCraftProjectDesignCreationRequest;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;

@Mapper
public interface PresentationMapper {
    
    OneCraftProjectCreationRequest toModel(OneCraftProjectCreationRequestDto creationRequestDto);

    OneCraftProjectDto toDto(OneCraftProject project);

    OneCraftProjectDesignCreationRequest toModel(OneCraftProjectDesignCreationRequestDto creationRequestDto);

    OneCraftProjectTechnicalDesignDto toDto(OneCraftProjectTechnicalDesign oneCraftProjectTechnicalDesign);

}
