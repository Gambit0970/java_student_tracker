package com.cta.training.studenttracker.controllers;

import com.cta.training.studenttracker.domain.Course;
import com.cta.training.studenttracker.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("courses", courseService.listAllCourses());
        System.out.println("Returning courses:");
        return "courses";
    }


    @RequestMapping("/course/new")
    public String newStudent(Model model){
        model.addAttribute("course", new Course());
        return "courseform";
    }

    @RequestMapping(value = "course", method = RequestMethod.POST)
    public String saveCourse(Course course){

        courseService.saveCourse(course);

        return "redirect:/courses";
    }

}
