package com.cta.training.studenttracker.repositories;

import com.cta.training.studenttracker.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
