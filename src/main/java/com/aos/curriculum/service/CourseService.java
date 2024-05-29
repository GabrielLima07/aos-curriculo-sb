package com.aos.curriculum.service;

import com.aos.curriculum.model.Course;
import com.aos.curriculum.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

     public Course createCourse(Course course) {
        return courseRepository.save(course);
     }

     public List<Course> retrieveCourses() {
        return courseRepository.findAll();
     }

     public Optional<Course> retrieveCourseById(UUID id) {
        return courseRepository.findById(id);
     }

     public Optional<Course> updateCourse(UUID id, Course updatedCourse) {
         return courseRepository.findById(id)
                 .map(course -> {
                     course.setName((updatedCourse.getName() == null) ? course.getName() : updatedCourse.getName());
                     course.setDuration((updatedCourse.getDuration() == null) ? course.getDuration() : updatedCourse.getDuration());
                     return courseRepository.save(course);
                 });
     }

     public boolean deleteCourse(UUID id) {
        try {
            courseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
     }
}
