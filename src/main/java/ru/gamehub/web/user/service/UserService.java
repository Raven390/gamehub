package ru.gamehub.web.user.service;

import org.springframework.stereotype.Service;
import ru.gamehub.web.user.model.User;
import ru.gamehub.web.user.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(String id) {
        return userRepository.getReferenceById(id);
    }
}
