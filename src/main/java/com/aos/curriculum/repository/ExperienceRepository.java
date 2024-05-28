package com.aos.curriculum.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aos.curriculum.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, UUID> {
    
}
