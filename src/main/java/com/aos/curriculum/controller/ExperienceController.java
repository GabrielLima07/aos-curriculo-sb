package com.aos.curriculum.controller;

import com.aos.curriculum.model.Experience;
import com.aos.curriculum.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("experiences")
public class ExperienceController {
    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @GetMapping
    public List<Experience> getExperiences() {
        return experienceService.retrieveExperiences();
    }

    @GetMapping("/{id}")
    public Optional<Experience> getExperience(@PathVariable UUID id) {
        return experienceService.retrieveExperienceById(id);
    }

    @PutMapping("/{id}")
    public Optional<Experience> updateExperience(@PathVariable UUID id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    public boolean deleteExperience(@PathVariable UUID id) {
        return experienceService.deleteExperience(id);
    }
}