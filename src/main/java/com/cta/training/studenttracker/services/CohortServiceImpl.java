package com.cta.training.studenttracker.services;

import com.cta.training.studenttracker.domain.Cohort;
import com.cta.training.studenttracker.domain.Course;
import com.cta.training.studenttracker.repositories.CohortRepository;
import com.cta.training.studenttracker.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CohortServiceImpl implements CohortService{

    private CohortRepository cohortRepository;

    @Autowired
    public void setCourseRepository(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }

    @Override
    public Iterable<Cohort> listAllCohorts() {
        return cohortRepository.findAll();
    }

    @Override
    public List<String> cohortNames() {
        List<String> cohortNames = new ArrayList<>();
        Iterable<Cohort> cohorts = cohortRepository.findAll();
        for (Cohort cohort : cohorts){
            cohortNames.add(cohort.getName());
        }
        return cohortNames;
    }

    @Override
    public Cohort getCohortById(Integer id) {
        return cohortRepository.findById(id).orElse(null);
    }

    @Override
    public Cohort saveCohort(Cohort cohort) {
        return cohortRepository.save(cohort);
    }

    @Override
    public void deleteCohort(Integer id) {
        cohortRepository.deleteById(id);
    }

}
