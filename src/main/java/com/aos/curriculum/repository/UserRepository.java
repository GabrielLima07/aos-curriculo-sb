package com.aos.curriculum.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aos.curriculum.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
