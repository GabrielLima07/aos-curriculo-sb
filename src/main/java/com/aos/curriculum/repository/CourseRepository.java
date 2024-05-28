package com.aos.curriculum.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aos.curriculum.model.Course;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    
}
