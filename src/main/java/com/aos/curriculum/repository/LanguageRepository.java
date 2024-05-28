package com.aos.curriculum.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aos.curriculum.model.Language;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
    
}
