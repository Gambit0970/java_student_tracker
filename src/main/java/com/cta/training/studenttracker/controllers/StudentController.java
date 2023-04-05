package com.cta.training.studenttracker.controllers;

import com.cta.training.studenttracker.services.CourseService;
import com.cta.training.studenttracker.domain.Student;
import com.cta.training.studenttracker.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("students", studentService.listAllStudents());
        System.out.println("Returning students:");
        return "students";
    }

    @RequestMapping("student/{id}")
    public String showStudent(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "studentshow";
    }

    @RequestMapping("student/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        List<String> courses = courseService.courseNames();
        model.addAttribute("allCourses", courses);
        return "studentform";
    }

    @RequestMapping("student/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @RequestMapping("student/new")
    public String newStudent(Model model){
        model.addAttribute("student", new Student());
        List<String> courses = courseService.courseNames();
        model.addAttribute("allCourses", courses);
        return "studentform";
    }

    @RequestMapping(value = "student", method = RequestMethod.POST)
    public String saveStudent(Student student){

        studentService.saveStudent(student);

        return "redirect:/student/" + student.getId();
    }

}
