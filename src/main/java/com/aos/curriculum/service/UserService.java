package com.aos.curriculum.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.aos.curriculum.model.UserCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aos.curriculum.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCv createUser(UserCv userCv) {
        return userRepository.save(userCv);
    }

    public List<UserCv> retrieveUsers() {
        return userRepository.findAll();
    }

    public Optional<UserCv> retrieveUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<UserCv> updateUser(UUID id, UserCv updatedUserCv) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName((updatedUserCv.getName() == null) ? user.getName() : updatedUserCv.getName());
                    user.setEmail((updatedUserCv.getEmail() == null) ? user.getEmail() : updatedUserCv.getEmail());
                    user.setAge((updatedUserCv.getAge() == null) ? user.getAge() : updatedUserCv.getAge());
                    user.setWorking((updatedUserCv.getWorking() == null) ? user.getWorking() : updatedUserCv.getWorking());
                    user.setCourses((updatedUserCv.getCourses() == null) ? user.getCourses() : updatedUserCv.getCourses());
                    user.setExperiences((updatedUserCv.getExperiences() == null) ? user.getExperiences() : updatedUserCv.getExperiences());
                    user.setLanguages((updatedUserCv.getLanguages() == null) ? user.getLanguages() : updatedUserCv.getLanguages());
                    return userRepository.save(user);
                });
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
