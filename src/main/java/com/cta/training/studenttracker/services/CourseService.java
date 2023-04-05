package com.cta.training.studenttracker.services;

import com.cta.training.studenttracker.domain.Course;

import java.util.List;

public interface CourseService {

    Iterable<Course> listAllCourses();

    List<String> courseNames();

    Course getCourseById(Integer id);

    Course saveCourse(Course course);

}
