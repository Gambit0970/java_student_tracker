package com.cta.training.studenttracker.services;

import com.cta.training.studenttracker.domain.Cohort;
import com.cta.training.studenttracker.domain.Course;

import java.util.List;

public interface CohortService {

    Iterable<Cohort> listAllCohorts();

    List<String> cohortNames();

    Cohort getCohortById(Integer id);

    Cohort saveCohort(Cohort cohort);

    void deleteCohort(Integer id);

}
