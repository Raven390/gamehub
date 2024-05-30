package ru.gamehub.web.project.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.gamehub.web.project.model.Project;
import ru.gamehub.web.project.model.attribute.ProjectStatus;
import ru.gamehub.web.project.repository.ProjectRepository;
import ru.gamehub.web.user.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserService userService;

    public ProjectService(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    public Project create(Project project, String userId) {
        project.setCreatorId(userService.get(userId));
        return projectRepository.save(project);
    }

    public Project get(UUID id) {
        return projectRepository.getById(id);
    }

    public Project update(Project user) {
        return projectRepository.save(user);
    }

    public void delete(UUID id) {
        projectRepository.deleteProjectById(id);
    }

    public List<Project> getPage(int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return projectRepository.findAllByStatusIn(List.of(ProjectStatus.NEW, ProjectStatus.ACTIVE), pageable);
    }
}
