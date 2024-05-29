package com.aos.curriculum.repository;

import java.util.UUID;

import com.aos.curriculum.model.UserCv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserCv, UUID> {
    
}
