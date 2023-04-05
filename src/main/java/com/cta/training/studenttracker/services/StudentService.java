package com.cta.training.studenttracker.services;

import com.cta.training.studenttracker.domain.Student;

public interface StudentService {
    Iterable<Student> listAllStudents();

    Student getStudentById(Integer id);

    Student saveStudent(Student student);

    void deleteStudent(Integer id);
}
