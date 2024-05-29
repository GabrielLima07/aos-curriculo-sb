package com.aos.curriculum.controller;

import com.aos.curriculum.model.Language;
import com.aos.curriculum.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("languages")
public class LanguageController {
    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageService.createLanguage(language);
    }

    @GetMapping
    public List<Language> getLanguages() {
        return languageService.retrieveLanguages();
    }

    @GetMapping("/{id}")
    public Optional<Language> getLanguage(@PathVariable UUID id) {
        return languageService.retrieveLanguageById(id);
    }

    @PutMapping("/{id}")
    public Optional<Language> updateLanguage(@PathVariable UUID id, @RequestBody Language language) {
        return languageService.updateLanguage(id, language);
    }

    @DeleteMapping("/{id}")
    public boolean deleteLanguage(@PathVariable UUID id) {
        return languageService.deleteLanguage(id);
    }
}