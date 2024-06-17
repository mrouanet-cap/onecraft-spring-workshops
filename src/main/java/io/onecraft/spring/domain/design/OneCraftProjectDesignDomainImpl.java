package io.onecraft.spring.domain.design;

import io.onecraft.spring.annotation.TimeMonitored;
import io.onecraft.spring.domain.api.OneCraftProjectDesignDomain;
import io.onecraft.spring.domain.project.model.OneCraftProject;
import io.onecraft.spring.domain.project.model.OneCraftProjectDesignCreationRequest;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.domain.spi.OneCraftProjectDao;
import io.onecraft.spring.domain.spi.OneCraftProjectDesignDao;
import io.onecraft.spring.domain.spi.OneCraftProjectDesignProvider;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * The domain implementation for the OneCraft project.
 *
 * @version 1.0
 */
@Service
@Transactional
public class OneCraftProjectDesignDomainImpl implements OneCraftProjectDesignDomain {

    private final OneCraftProjectDao projectDao;

    private final OneCraftProjectDesignDao projectDesignDao;

    private final OneCraftProjectDesignProvider projectDesignProvider;

    /**
     * The constructor for the domain implementation.
     *
     * @param projectDao            the project data access object.
     * @param projectDesignDao      the project design data access object.
     * @param projectDesignProvider the project design provider.
     * @since 1.0
     */
    public OneCraftProjectDesignDomainImpl(OneCraftProjectDao projectDao, OneCraftProjectDesignDao projectDesignDao, OneCraftProjectDesignProvider projectDesignProvider) {
        this.projectDao = projectDao;
        this.projectDesignDao = projectDesignDao;
        this.projectDesignProvider = projectDesignProvider;
    }

    @Override
    @TimeMonitored
    public OneCraftProjectTechnicalDesign designProject(Long projectId, OneCraftProjectDesignCreationRequest designCreationRequest) {
        OneCraftProject projectToDesign = projectDao.findProjectById(projectId);
        if(!projectToDesign.isDesignable()){
            throw new IllegalArgumentException("Project %d is not designable".formatted(projectId));
        }
        OneCraftProjectTechnicalDesign design = projectDesignProvider.createDesign(
                designCreationRequest.functionalRequirements());
        design.setProjectId(projectId);
        return projectDesignDao.saveProjectTechnicalDesign(design);
    }

    @Override
    public OneCraftProjectTechnicalDesign getDesign(Long designId) {
        return projectDesignDao.getTechnicalDesign(designId);
    }

    @Override
    public OneCraftProjectTechnicalDesign approveDesign(Long designId) {
        OneCraftProjectTechnicalDesign design = projectDesignDao.getTechnicalDesign(designId);
        if(!design.isApprovable()){
            throw new IllegalArgumentException("Design %d is not approvable".formatted(designId));
        }
        design.setStatus("Approved");
        return projectDesignDao.saveProjectTechnicalDesign(design);
    }

}
