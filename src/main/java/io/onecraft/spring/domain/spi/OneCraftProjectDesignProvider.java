package io.onecraft.spring.domain.spi;

import io.onecraft.spring.domain.design.model.requirement.FunctionalRequirement;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;

import java.util.List;

/**
 * This interface is used to provide the design of the project.
 */
public interface OneCraftProjectDesignProvider {

    OneCraftProjectTechnicalDesign createDesign(List<FunctionalRequirement> functionalRequirements);

}
