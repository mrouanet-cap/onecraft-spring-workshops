package io.onecraft.spring.adapter;

import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.domain.design.model.requirement.FunctionalRequirement;
import io.onecraft.spring.domain.spi.OneCraftProjectDesignProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The stub implementation for the OneCraft project design provider.
 *
 * @version 1.0
 */
@Component
@ConditionalOnProperty(name = "onecraft.project.design.stub.enabled", havingValue = "true")
public class OneCraftProjectDesignStub implements OneCraftProjectDesignProvider {
    @Override
    public OneCraftProjectTechnicalDesign createDesign(List<FunctionalRequirement> functionalRequirements) {
        var design = new OneCraftProjectTechnicalDesign();
        design.setStatus("DRAFT");
        return design;
    }
}
