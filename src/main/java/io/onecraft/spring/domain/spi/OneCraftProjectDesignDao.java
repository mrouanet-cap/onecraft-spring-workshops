package io.onecraft.spring.domain.spi;

import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;

public interface OneCraftProjectDesignDao {

    OneCraftProjectTechnicalDesign getTechnicalDesign(Long designId);

    OneCraftProjectTechnicalDesign saveProjectTechnicalDesign(OneCraftProjectTechnicalDesign design);
}
