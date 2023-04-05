package com.cta.training.studenttracker.services;

import com.cta.training.studenttracker.repositories.CourseRepository;
import com.cta.training.studenttracker.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> listAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<String> courseNames() {
        List<String> courseNames = new ArrayList<>();
        Iterable<Course> courses = courseRepository.findAll();
        for (Course course : courses){
            courseNames.add(course.getName());
        }
        return courseNames;
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
