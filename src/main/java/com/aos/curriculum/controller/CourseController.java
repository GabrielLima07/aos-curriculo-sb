package com.aos.curriculum.controller;

import com.aos.curriculum.model.Course;
import com.aos.curriculum.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.retrieveCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable UUID id) {
        return courseService.retrieveCourseById(id);
    }

    @PutMapping("/{id}")
    public Optional<Course> updateCourse(@PathVariable UUID id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourse(@PathVariable UUID id) {
        return courseService.deleteCourse(id);
    }
}