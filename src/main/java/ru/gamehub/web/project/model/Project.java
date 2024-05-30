package ru.gamehub.web.project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import ru.gamehub.web.project.model.attribute.ProjectStatus;
import ru.gamehub.web.user.model.User;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Класс, представляющий модель проекта.
 */
@Entity
@Table(name = "project", schema = "gamehub")
public class Project {
    /**
     * Уникальный идентификатор проекта.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Название проекта.
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание проекта.
     */
    @Column(name = "description")
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
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProjectStatus status;

    /**
     * Дата начала проекта.
     */
    @Column(name = "start_date", columnDefinition = "timestamptz default now()")
    private OffsetDateTime startDate = OffsetDateTime.now();

    /**
     * Планируемая дата завершения проекта.
     */
    @Column(name = "end_date")
    private OffsetDateTime endDate;

//    /**
//     * Предустановленные теги проекта.
//     */
//    private List<ProjectTag> defaultTags;

//    /**
//     * Пользовательские теги проекта.
//     */
//    private List<String> customTags;

    /**
     * Создатель проекта
     */
    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creatorId;

    public Project() {
    }

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

/*    public Map<TeamRole, UUID> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Map<TeamRole, UUID> teamMembers) {
        this.teamMembers = teamMembers;
    }*/

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

    public User getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(User creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return getId().equals(project.getId());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

