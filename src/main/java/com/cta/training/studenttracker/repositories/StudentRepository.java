package com.cta.training.studenttracker.repositories;

import com.cta.training.studenttracker.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>{
}
