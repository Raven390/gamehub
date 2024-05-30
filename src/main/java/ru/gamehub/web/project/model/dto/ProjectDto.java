package ru.gamehub.web.project.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gamehub.web.project.model.attribute.ProjectStatus;
import ru.gamehub.web.project.model.attribute.ProjectTag;
import ru.gamehub.web.user.model.User;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDto {

    /**
     * Уникальный идентификатор проекта.
     */
    private UUID id;

    /**
     * Название проекта.
     */
    private String name;

    /**
     * Описание проекта.
     */
    private String description;

    /*    *//**
     * Мапа ролей-участников команды, связанных с проектом.
     * Ключ - роль
     * Значение - {@link User}.id
     *//*
    private Map<TeamRole, UUID> teamMembers;*/

    /**
     * Статус проекта.
     */
    private ProjectStatus status = ProjectStatus.NEW;

    /**
     * Дата начала проекта.
     */
    private OffsetDateTime startDate = OffsetDateTime.now();

    /**
     * Планируемая дата завершения проекта.
     */
    private OffsetDateTime endDate;

    /**
     * Предустановленные теги проекта.
     */
    private List<ProjectTag> defaultTags;

    /**
     * Пользовательские теги проекта.
     */
    private List<String> customTags;

    /**
     * Создатель проекта
     */
    private String creatorId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public List<ProjectTag> getDefaultTags() {
        return defaultTags;
    }

    public void setDefaultTags(List<ProjectTag> defaultTags) {
        this.defaultTags = defaultTags;
    }

    public List<String> getCustomTags() {
        return customTags;
    }

    public void setCustomTags(List<String> customTags) {
        this.customTags = customTags;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
}
