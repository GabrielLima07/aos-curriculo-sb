package com.aos.curriculum.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class UserCv {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Boolean working;

    @OneToMany(mappedBy = "userCv", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Course> courses;

    @OneToMany(mappedBy = "userCv", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Language> languages;

    @OneToMany(mappedBy = "userCv", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Experience> experiences;
}