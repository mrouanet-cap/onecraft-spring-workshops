package io.onecraft.spring.adapter;

import io.onecraft.spring.adapter.entity.OneCraftProjectEntity_;
import io.onecraft.spring.adapter.repository.OneCraftProjectRepository;
import io.onecraft.spring.adapter.support.DatabaseAdapterMapper;
import io.onecraft.spring.domain.exception.OneCraftProjectNotFoundException;
import io.onecraft.spring.domain.project.model.OneCraftProject;
import io.onecraft.spring.domain.spi.OneCraftProjectDao;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OneCraftProjectPostgresDao implements OneCraftProjectDao {

    private final OneCraftProjectRepository oneCraftProjectRepository;

    private final DatabaseAdapterMapper adapterMapper;

    /**
     * The constructor for the Postgres data access object.
     *
     * @param oneCraftProjectRepository the project repository.
     * @param adapterMapper             the adapter mapper.
     */
    public OneCraftProjectPostgresDao(OneCraftProjectRepository oneCraftProjectRepository, DatabaseAdapterMapper adapterMapper) {
        this.oneCraftProjectRepository = oneCraftProjectRepository;
        this.adapterMapper = adapterMapper;
    }

    @Override
    public OneCraftProject saveProject(OneCraftProject oneCraftProject) {
        return adapterMapper.toDomain(oneCraftProjectRepository.save(adapterMapper.toEntity(oneCraftProject)));
    }

    @Override
    public OneCraftProject findProjectById(Long projectId) {
        return adapterMapper.toDomain(oneCraftProjectRepository.findById(projectId).orElseThrow(
                () -> new OneCraftProjectNotFoundException(projectId)));
    }

    @Override
    public Set<OneCraftProject> findProjects(int page, int size) {
        return adapterMapper.toDomain(oneCraftProjectRepository.findAll(PageRequest.of(page, size)).getContent());
    }

    @Override
    public Set<OneCraftProject> findProjectsOrderByName(int page, int size) {
        return adapterMapper.toDomain(oneCraftProjectRepository.findAll(new OpenedProjectSpecification(), Sort.by(Sort.Direction.ASC,
                OneCraftProjectEntity_.NAME)));
    }

}
