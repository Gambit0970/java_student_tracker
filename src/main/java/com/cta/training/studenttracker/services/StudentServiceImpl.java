package com.cta.training.studenttracker.services;

import com.cta.training.studenttracker.domain.Student;
import com.cta.training.studenttracker.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setProductRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
