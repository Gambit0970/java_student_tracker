package com.cta.training.studenttracker.bootstrap;

import com.cta.training.studenttracker.domain.Course;
import com.cta.training.studenttracker.domain.Student;
import com.cta.training.studenttracker.repositories.CourseRepository;
import com.cta.training.studenttracker.repositories.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class StudentLoader implements ApplicationListener<ContextRefreshedEvent> {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    private Logger log = LogManager.getLogger(StudentLoader.class);

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Course test = new Course();
        test.setName("Test");
        test.setDescription("Core training and test plus automation");
        courseRepository.save(test);

        Course dev = new Course();
        dev.setName("Development");
        dev.setDescription("Core training with programming, web development and advanced OOP / patterns");
        courseRepository.save(dev);

        Student student1 = new Student();
        student1.setName("Bob");
        student1.setCohort("1");
        student1.setCourse("test");
        student1.setStudentID("1");
        studentRepository.save(student1);
        log.info("Saved Student - id: " + student1.getId());

        Student student2 = new Student();
        student2.setName("Alice");
        student2.setCohort("1");
        student2.setCourse("test");
        student2.setStudentID("2");
        studentRepository.save(student2);
        log.info("Saved Student - id: " + student2.getId());    }
}
