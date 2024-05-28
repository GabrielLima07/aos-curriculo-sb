package com.aos.curriculum.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aos.curriculum.model.Language;
import com.aos.curriculum.model.User;
import com.aos.curriculum.repository.LanguageRepository;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;
    
    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    public List<Language> retrieveLanguages() {
        return languageRepository.findAll();
    }

    public Optional<Language> retrieveLanguageById(UUID id) {
        return languageRepository.findById(id);
    }

    //TODO:
    public Language updateLanguage(UUID id, Language language) {
        return language;
    }

    public boolean deleteLanguage(UUID id) {
        try {
            languageRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
