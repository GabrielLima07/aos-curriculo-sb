package com.aos.curriculum.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aos.curriculum.model.User;
import com.aos.curriculum.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }

    public Optional<User> retrieveUserById(UUID id) {
        return userRepository.findById(id);
    }

    //TODO:
    public User updateUser(UUID id, User user) {
        return user;
    }

    public boolean deleteUser(UUID id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
