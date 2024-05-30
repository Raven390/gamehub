package ru.gamehub.web.user.model;

import jakarta.persistence.*;
import org.springframework.boot.actuate.endpoint.invoke.convert.IsoOffsetDateTimeConverter;
import ru.gamehub.web.user.model.attribute.AccountStatus;
import ru.gamehub.web.user.model.attribute.Skill;
import ru.gamehub.web.util.OffsetDateTimeConverter;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Сущность пользователя системы
 */
@Entity
@Table(schema = "keycloak", name = "user_entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "created_timestamp")
    @Convert(converter = OffsetDateTimeConverter.class)
    private OffsetDateTime createdTimestamp;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OffsetDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}
