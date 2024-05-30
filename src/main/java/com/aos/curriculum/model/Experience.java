package com.aos.curriculum.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String contributionTime;

    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    @JsonBackReference
    private UserCv userCv;
}