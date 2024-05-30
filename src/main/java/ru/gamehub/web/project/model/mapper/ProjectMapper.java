package ru.gamehub.web.project.model.mapper;

import org.mapstruct.Mapper;
import ru.gamehub.web.project.model.Project;
import ru.gamehub.web.project.model.dto.ProjectDto;
import ru.gamehub.web.user.model.User;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project projectDtoToEntity(ProjectDto projectDto);
    ProjectDto projectToProjectDto(Project project);
    List<ProjectDto> projectListToProjectDtoList(List<Project> projectList);

    default User map(String value) {
        User user = new User();
        user.setId(value);
        return user;
    }

    default String map(User value) {
        return value.getId();
    }
}
