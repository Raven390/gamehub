package ru.gamehub.web.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gamehub.web.user.model.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
