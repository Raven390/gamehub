package ru.gamehub.web.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gamehub.web.project.model.Project;
import ru.gamehub.web.project.model.dto.ProjectDto;
import ru.gamehub.web.project.model.mapper.ProjectMapper;
import ru.gamehub.web.project.service.ProjectService;
import ru.gamehub.web.api.ApiResponse;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProject(@RequestBody ProjectDto projectDto, Principal principal) {
        String userId = principal.getName();
        Project project = projectMapper.projectDtoToEntity(projectDto);
        Project createdProject = projectService.create(project, userId);
        return ApiResponse.success(projectMapper.projectToProjectDto(createdProject));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> getProjects(@RequestParam(defaultValue = "50") int pageSize, @RequestParam(defaultValue = "0") int pageNumber) {
        List<Project> projectList = projectService.getPage(pageSize, pageNumber);
        return ApiResponse.success(projectList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable UUID id) {
        Project project = projectService.get(id);
        return ApiResponse.success(projectMapper.projectToProjectDto(project));
    }
}
