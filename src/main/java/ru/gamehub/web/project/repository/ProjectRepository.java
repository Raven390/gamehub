package ru.gamehub.web.project.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gamehub.web.project.model.Project;
import ru.gamehub.web.project.model.attribute.ProjectStatus;
import ru.gamehub.web.user.model.User;


import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer> {
    List<Project> findAllByStatusIn(List<ProjectStatus> projectStatuses, Pageable pageable);

    Project save(Project project);
    Project getById(UUID id);
    void deleteProjectById(UUID id);
}
