package com.cta.training.studenttracker.controllers;

import com.cta.training.studenttracker.domain.Cohort;
import com.cta.training.studenttracker.services.CohortService;
import com.cta.training.studenttracker.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CohortController {

    private CohortService cohortService;
    private CourseService courseService;

    @Autowired
    public void setCohortService(CohortService cohortService) {
        this.cohortService = cohortService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


    @RequestMapping(value = "/cohorts", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("cohorts", cohortService.listAllCohorts());
        System.out.println("Returning cohorts:");
        return "cohorts";
    }

    @RequestMapping("cohort/{id}")
    public String showCohort(@PathVariable Integer id, Model model){
        model.addAttribute("cohort", cohortService.getCohortById(id));
        return "cohortshow";
    }

    @RequestMapping("cohort/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("cohort", cohortService.getCohortById(id));
        List<String> courses = courseService.courseNames();
        model.addAttribute("allCourses", courses);
        return "cohortform";
    }

    @RequestMapping("cohort/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        cohortService.deleteCohort(id);
        return "redirect:/cohorts";
    }

    @RequestMapping("cohort/new")
    public String newCohort(Model model){
        model.addAttribute("cohort", new Cohort());
        List<String> courses = courseService.courseNames();
        model.addAttribute("allCourses", courses);
        return "cohortform";
    }

    @RequestMapping(value = "cohort", method = RequestMethod.POST)
    public String saveCohort(Cohort cohort){

        cohortService.saveCohort(cohort);

        return "redirect:/cohort/" + cohort.getId();
    }


}
