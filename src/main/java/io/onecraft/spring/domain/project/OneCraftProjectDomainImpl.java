package io.onecraft.spring.domain.project;

import io.onecraft.spring.annotation.TimeMonitored;
import io.onecraft.spring.domain.api.OneCraftProjectDomain;
import io.onecraft.spring.domain.project.model.OneCraftProject;
import io.onecraft.spring.domain.project.model.OneCraftProjectCreationRequest;
import io.onecraft.spring.domain.spi.OneCraftProjectDao;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * The domain implementation for the OneCraft project.
 *
 * @version 1.0
 */
@Service
@Transactional
public class OneCraftProjectDomainImpl implements OneCraftProjectDomain {

    private final OneCraftProjectDao projectDao;

    /**
     * The constructor for the domain implementation.
     *
     * @param projectDao the project data access object.
     * @since 1.0
     */
    public OneCraftProjectDomainImpl(OneCraftProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public OneCraftProject createProject(OneCraftProjectCreationRequest creationRequest) {
        return projectDao.saveProject(new OneCraftProject(creationRequest.name(), "open"));
    }


    @Override
    @TimeMonitored
    public OneCraftProject getProject(Long projectId) {
        return projectDao.findProjectById(projectId);
    }

    @Override
    public OneCraftProject closeProject(Long projectId) {
        OneCraftProject projectToClose = projectDao.findProjectById(projectId);
        if(!projectToClose.isClosable()){
            throw new IllegalArgumentException("Project %d is not closable".formatted(projectId));
        }
        projectToClose.setStatus("closed");
        return projectDao.saveProject(projectToClose);
    }

}
