package com.aos.curriculum.service;

import com.aos.curriculum.model.Experience;
import com.aos.curriculum.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> retrieveExperiences() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> retrieveExperienceById(UUID id) {
        return experienceRepository.findById(id);
    }

    public Optional<Experience> updateExperience(UUID id, Experience updatedExperience) {
        return experienceRepository.findById(id)
                .map(experience -> {
                    experience.setRole((updatedExperience.getRole() == null) ? experience.getRole() : updatedExperience.getRole());
                    experience.setCompany((updatedExperience.getCompany() == null) ? experience.getCompany() : updatedExperience.getCompany());
                    experience.setContributionTime((updatedExperience.getContributionTime() == null) ? experience.getContributionTime() : updatedExperience.getContributionTime());
                    return experienceRepository.save(experience);
                });
    }

    public boolean deleteExperience(UUID id) {
        try {
            experienceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
